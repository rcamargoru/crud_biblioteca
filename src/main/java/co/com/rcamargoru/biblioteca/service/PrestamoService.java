/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.PrestamoRequestDTO;
import co.com.rcamargoru.biblioteca.dto.PrestamoResponseDTO;
import co.com.rcamargoru.biblioteca.exception.BadRequestException;
import co.com.rcamargoru.biblioteca.model.Libro;
import co.com.rcamargoru.biblioteca.model.Prestamo;
import co.com.rcamargoru.biblioteca.model.Usuario;
import co.com.rcamargoru.biblioteca.repository.LibroRepository;
import co.com.rcamargoru.biblioteca.repository.PrestamoRepository;
import co.com.rcamargoru.biblioteca.repository.UsuarioRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 * Logica de app - Prestamo
 */
@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository, UsuarioRepository usuarioRepository, LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;

    }

    
        public Map<Integer, Long> obtenerPrestamosPorMes(int anio) {
        List<Object[]> resultados = prestamoRepository.contarPrestamosPorMes(anio);

        Map<Integer, Long> prestamosPorMes = new HashMap<>();
        for (Object[] fila : resultados) {
            Integer mes = ((Number) fila[0]).intValue();
            Long cantidad = ((Number) fila[1]).longValue();
            prestamosPorMes.put(mes, cantidad);
        }
        return prestamosPorMes;
    }
    
    //Metodo para crear prestamo
    public PrestamoResponseDTO crearPrestamo(PrestamoRequestDTO request) {
        Prestamo nuevoPrestamo = new Prestamo();
        Libro libro = libroRepository.findById(request.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        nuevoPrestamo.setLibro(libro);
        Usuario cliente = usuarioRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        nuevoPrestamo.setCliente(cliente);
        if (libro.getStock() <= 0) {
            throw new BadRequestException("No hay ejemplares disponibles para este libro");
        }
        long prestamosActivos = prestamoRepository.countByClienteIdAndEstado(cliente.getId(), "En préstamo");
        if (prestamosActivos >= 5) {
            throw new BadRequestException("El usuario ya tiene el máximo de préstamos permitidos");
        }
        boolean existePrestamo = prestamoRepository.existsByClienteIdAndLibroIdAndEstado(
                cliente.getId(), libro.getId(), "En préstamo");
        if (existePrestamo) {
            throw new BadRequestException("El usuario ya tiene este libro prestado actualmente");
        }
        nuevoPrestamo.setEstado("En préstamo");
        Date hoy = new Date();
        nuevoPrestamo.setFechaPrestamo(hoy);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hoy);
        calendar.add(Calendar.DAY_OF_MONTH, 25);
        Date fechaDevolucion = calendar.getTime();
        nuevoPrestamo.setFechaPosibleDevolucion(fechaDevolucion);
        nuevoPrestamo.setFechaRealDevolucion(null);
        libro.setStock(libro.getStock() - 1);
        libroRepository.save(libro);
        Prestamo guardado = prestamoRepository.save(nuevoPrestamo);
        return mapToResponseDto(guardado);
    }

    // metodo para actualizar prestamo
    public PrestamoResponseDTO actualizarPrestamo(Long id, PrestamoRequestDTO request) {
Prestamo actualizaPrestamo = new Prestamo();
        Libro libro = libroRepository.findById(request.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        actualizaPrestamo.setLibro(libro);
        Usuario cliente = usuarioRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        actualizaPrestamo.setCliente(cliente);
        actualizaPrestamo.setEstado(request.getEstado());
        Date hoy = new Date();  
        Calendar calendar = Calendar.getInstance();
        actualizaPrestamo.setFechaRealDevolucion(null);
        if(actualizaPrestamo.getEstado().equals("En ampliación")){
        actualizaPrestamo.setFechaRealDevolucion(null);     
        calendar.setTime(hoy);
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        Date fechaDevolucion = calendar.getTime();
        actualizaPrestamo.setFechaPosibleDevolucion(fechaDevolucion);
        }
        else if(actualizaPrestamo.getEstado().equals("Devuelto")){
        actualizaPrestamo.setFechaRealDevolucion(hoy);
        libro.setStock(libro.getStock() + 1);
        libroRepository.save(libro);
        }
        Prestamo actualizado = prestamoRepository.save(actualizaPrestamo);
        return mapToResponseDto(actualizado);
    }

    // Metodo para listar todos los libros
    public List<PrestamoResponseDTO> listarPrestamos() {
        return prestamoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo para obtener libro por id
    public PrestamoResponseDTO obtenerPrestamoPorId(Long id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));

        return mapToResponseDto(prestamo);
    }

    // Metodo para Eliminar prestamo
    public void eliminarPrestamo(Long id) {

    }

    //Conversión de entidad a DTO
    private PrestamoResponseDTO mapToResponseDto(Prestamo prestamo) {
        PrestamoResponseDTO dto = new PrestamoResponseDTO();
        dto.setId(prestamo.getId());
        dto.setLibroNombre(prestamo.getLibro().getTitulo());
        dto.setClienteNombre(prestamo.getCliente().getNombre());
        dto.setFechaPrestamo(prestamo.getFechaPrestamo());
        dto.setFechaPosibleDevolucion(prestamo.getFechaPosibleDevolucion());
        dto.setFechaRealDevolucion(prestamo.getFechaRealDevolucion());
        dto.setEstado(prestamo.getEstado());
        return dto;
    }
}
