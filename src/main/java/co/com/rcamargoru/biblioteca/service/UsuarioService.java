/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.dto.UsuarioRequestDTO;
import co.com.rcamargoru.biblioteca.dto.UsuarioResponseDTO;
import co.com.rcamargoru.biblioteca.model.Usuario;
import co.com.rcamargoru.biblioteca.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 * Logica de app - Usuario
 */
@Service
public class UsuarioService {
 private final UsuarioRepository usuarioRepository;    
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
 //Metodo para crear usuario
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(request.getNombre());
        nuevoUsuario.setDocumento(request.getDocumento());
        nuevoUsuario.setFechaNacimiento(request.getFechaNacimiento());
        nuevoUsuario.setEstado(request.getEstado());
        Usuario guardado = usuarioRepository.save(nuevoUsuario);
        return mapToResponseDto(guardado);
    }
  // metodo para actualizar usuario
    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO request) {
        Usuario ActualizaUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ActualizaUsuario.setDocumento(request.getDocumento());
        ActualizaUsuario.setNombre(request.getNombre());
        ActualizaUsuario.setEstado(request.getEstado());
        Usuario actualizado = usuarioRepository.save(ActualizaUsuario);
        return mapToResponseDto(actualizado);
    }

    // Metodo para listar todos los usuarios
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo para obtener usuario por id
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToResponseDto(usuario);
    }

    // Metodo para Eliminar usuario
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    //Conversión de entidad a DTO
    private UsuarioResponseDTO mapToResponseDto(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setDocumento(usuario.getDocumento());
        dto.setEstado(usuario.getEstado());
        return dto;
    }     
}
