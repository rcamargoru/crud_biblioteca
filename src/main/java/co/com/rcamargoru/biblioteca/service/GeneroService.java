/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.GeneroRequestDTO;
import co.com.rcamargoru.biblioteca.dto.GeneroResponseDTO;
import co.com.rcamargoru.biblioteca.exception.ResourceNotFoundException;
import co.com.rcamargoru.biblioteca.model.Genero;
import co.com.rcamargoru.biblioteca.repository.GeneroRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 * Logica de app - genero
 */
@Service
public class GeneroService {
  
private final GeneroRepository generoRepository;    
    
    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
    
 //Metodo para crear genero
    public GeneroResponseDTO crearGenero(GeneroRequestDTO request) {
        Genero nuevoGenero = new Genero();
        nuevoGenero.setNombre(request.getNombre());
        nuevoGenero.setDescripcion(request.getDescripcion());
        nuevoGenero.setEstado(request.getEstado());
        Genero guardado = generoRepository.save(nuevoGenero);
        return mapToResponseDto(guardado);
    }
  // metodo para actualizar genero
    public GeneroResponseDTO actualizaGenero(Long id, GeneroRequestDTO request) {
        Genero ActualizaGenero = generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genero no encontrado"));
        ActualizaGenero.setDescripcion(request.getDescripcion());
        ActualizaGenero.setNombre(request.getNombre());
        ActualizaGenero.setEstado(request.getEstado());
        Genero actualizado = generoRepository.save(ActualizaGenero);
        return mapToResponseDto(actualizado);
    }

    // Metodo para listar todos los generos
    public List<GeneroResponseDTO> listarGeneros() {
        return generoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo para obtener genero por id
    public GeneroResponseDTO obtenerGeneroPorId(Long id) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero no encontrado con ID: " + id));
        return mapToResponseDto(genero);
    }

    // Metodo para Eliminar genero
    public void eliminarGenero(Long id) {
        generoRepository.deleteById(id);
    }

    //Conversión de entidad a DTO
    private GeneroResponseDTO mapToResponseDto(Genero genero) {
        GeneroResponseDTO dto = new GeneroResponseDTO();
        dto.setNombre(genero.getNombre());
        dto.setId(genero.getId());
        dto.setDescripcion(genero.getDescripcion());
        dto.setEstado(genero.getEstado());
        return dto;
    }    
}
