/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.AutorRequestDTO;
import co.com.rcamargoru.biblioteca.dto.AutorResponseDTO;
import co.com.rcamargoru.biblioteca.model.Autor;
import co.com.rcamargoru.biblioteca.repository.AutorRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 * Logica de app - Autor
 */
@Service
public class AutorService {

private final AutorRepository autorRepository;    
    
    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
 //Metodo para crear autor
    public AutorResponseDTO crearAutor(AutorRequestDTO request) {
        Autor nuevoAutor = new Autor();
        nuevoAutor.setNombre(request.getNombre());
        nuevoAutor.setGenero(request.getGenero());
        nuevoAutor.setPais(request.getPais());
        nuevoAutor.setFechaNacimiento(request.getFechaNacimiento());
        nuevoAutor.setEstado(request.getEstado());
        Autor guardado = autorRepository.save(nuevoAutor);
        return mapToResponseDto(guardado);
    }
  // metodo para actualizar autor
    public AutorResponseDTO actualizarAutor(Long id, AutorRequestDTO request) {
        Autor ActualizaAutor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        //ActualizaAutor.setAutor(autor);
        ActualizaAutor.setGenero(request.getGenero());
        ActualizaAutor.setNombre(request.getNombre());
        ActualizaAutor.setPais(request.getPais());
        Autor actualizado = autorRepository.save(ActualizaAutor);
        return mapToResponseDto(actualizado);
    }

    // Metodo para listar todos los autores
    public List<AutorResponseDTO> listarAutores() {
        return autorRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo para obtener autor por id
    public AutorResponseDTO obtenerAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        return mapToResponseDto(autor);
    }

    // Metodo para Eliminar autor
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    //Conversión de entidad a DTO
    private AutorResponseDTO mapToResponseDto(Autor autor) {
        AutorResponseDTO dto = new AutorResponseDTO();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setFechaNacimiento(autor.getFechaNacimiento());
        dto.setGenero(autor.getGenero());
        dto.setPais(autor.getPais());
        dto.setEstado(autor.getEstado());
        return dto;
    }  
}
