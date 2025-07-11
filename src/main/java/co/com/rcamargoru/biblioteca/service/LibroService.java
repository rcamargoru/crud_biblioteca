/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.LibroRequestDTO;
import co.com.rcamargoru.biblioteca.dto.LibroResponseDTO;
import co.com.rcamargoru.biblioteca.model.Autor;
import co.com.rcamargoru.biblioteca.model.Genero;
import co.com.rcamargoru.biblioteca.model.Libro;
import co.com.rcamargoru.biblioteca.repository.AutorRepository;
import co.com.rcamargoru.biblioteca.repository.GeneroRepository;
import co.com.rcamargoru.biblioteca.repository.LibroRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final GeneroRepository generoRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository, GeneroRepository generoRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.generoRepository = generoRepository;

    }
    //Metodo para crear libro
    public LibroResponseDTO crearLibro(LibroRequestDTO request) {
        Libro nuevoLibro = new Libro();
        nuevoLibro.setIsbn(request.getIsbn());
        nuevoLibro.setTitulo(request.getTitulo());
        Autor autor = autorRepository.findById(request.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        nuevoLibro.setAutor(autor);
        Genero genero = generoRepository.findById(request.getGeneroId())
                .orElseThrow(() -> new RuntimeException("Genero no encontrado"));
        nuevoLibro.setGenero(genero);
        nuevoLibro.setStock(request.getStock());
        nuevoLibro.setEstado(request.getEstado());
        Libro guardado = libroRepository.save(nuevoLibro);
        return mapToResponseDto(guardado);
    }
    // metodo para actualizar libro
    public LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO request) {
        Libro actualizaLibro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        actualizaLibro.setTitulo(request.getTitulo());
        Autor autor = autorRepository.findById(request.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        actualizaLibro.setAutor(autor);
        Genero genero = generoRepository.findById(request.getGeneroId())
                .orElseThrow(() -> new RuntimeException("Genero no encontrado"));
        actualizaLibro.setGenero(genero);
        actualizaLibro.setIsbn(request.getIsbn());
        actualizaLibro.setStock(request.getStock());
        actualizaLibro.setEstado(request.getEstado());
        Libro actualizado = libroRepository.save(actualizaLibro);
        return mapToResponseDto(actualizado);
    }

    // Metodo para listar todos los libros
    public List<LibroResponseDTO> listarLibros() {
        return libroRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo para obtener libro por id
    public LibroResponseDTO obtenerLibroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        return mapToResponseDto(libro);
    }

    // Metodo para Eliminar libro
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    //Conversión de entidad a DTO
    private LibroResponseDTO mapToResponseDto(Libro libro) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setId(libro.getId());
        dto.setIsbn(libro.getIsbn());
        dto.setTitulo(libro.getTitulo());
        dto.setAutorNombre(libro.getAutor().getNombre());
        dto.setGeneroNombre(libro.getGenero().getNombre());
        dto.setStock(libro.getStock());
        dto.setEstado(libro.getEstado());
        return dto;
    }
}
