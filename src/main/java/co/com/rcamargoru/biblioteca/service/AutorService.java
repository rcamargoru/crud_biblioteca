/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.AutorRequestDTO;
import co.com.rcamargoru.biblioteca.dto.AutorResponseDTO;
import co.com.rcamargoru.biblioteca.model.Autor;
import co.com.rcamargoru.biblioteca.repository.AutorRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
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
        nuevoAutor.setFechaNacimiento(request.getFechaNacimiento().MIN);
        nuevoAutor.setEstado(request.getEstado());
        Autor guardado = autorRepository.save(nuevoAutor);
        return mapToResponseDto(guardado);
    }
//----------------------
    
//----------------------
    //Conversión de entidad a DTO
    private AutorResponseDTO mapToResponseDto(Autor autor) {
        AutorResponseDTO dto = new AutorResponseDTO();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setFechaNacimiento(autor.getFechaNacimiento().MIN);
        dto.setGenero(autor.getGenero());
        dto.setPais(autor.getPais());
        dto.setEstado(autor.getEstado());
        return dto;
    }  
}
