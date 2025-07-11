/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.controller;

import co.com.rcamargoru.biblioteca.dto.AutorRequestDTO;
import co.com.rcamargoru.biblioteca.dto.AutorResponseDTO;
import co.com.rcamargoru.biblioteca.service.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping("/api/autores")
public class AutorController {
  private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> crearAutor(@RequestBody AutorRequestDTO requestDto) {
        AutorResponseDTO autorCreado = autorService.crearAutor(requestDto);
        return ResponseEntity.ok(autorCreado);
    }
    
        @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> obtenerAutorPorId(@PathVariable Long id) {
        AutorResponseDTO autor = autorService.obtenerAutorPorId(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> obtenerTodosLosAutores() {
        List<AutorResponseDTO> autores = autorService.listarAutores();
        return ResponseEntity.ok(autores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> actualizarAutor(
            @PathVariable Long id,
            @RequestBody AutorRequestDTO requestDto) {
        AutorResponseDTO autorActualizado = autorService.actualizarAutor(id, requestDto);
        return ResponseEntity.ok(autorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }   
}
