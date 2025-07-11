/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.controller;

import co.com.rcamargoru.biblioteca.dto.GeneroRequestDTO;
import co.com.rcamargoru.biblioteca.dto.GeneroResponseDTO;
import co.com.rcamargoru.biblioteca.service.GeneroService;
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
 * controlador para ser llamado desde http para la gestión de generos
 */
@RestController
@RequestMapping("/api/generos")
public class GeneroController {
  private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public ResponseEntity<GeneroResponseDTO> crearGenero(@RequestBody GeneroRequestDTO requestDto) {
        GeneroResponseDTO generoCreado = generoService.crearGenero(requestDto);
        return ResponseEntity.ok(generoCreado);
    }
    
        @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> obtenerGeneroPorId(@PathVariable Long id) {
        GeneroResponseDTO genero = generoService.obtenerGeneroPorId(id);
        return ResponseEntity.ok(genero);
    }

    @GetMapping
    public ResponseEntity<List<GeneroResponseDTO>> obtenerTodosLosGeneros() {
        List<GeneroResponseDTO> generos = generoService.listarGeneros();
        return ResponseEntity.ok(generos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> actualizarGenero(
            @PathVariable Long id,
            @RequestBody GeneroRequestDTO requestDto) {
        GeneroResponseDTO generoActualizado = generoService.actualizaGenero(id, requestDto);
        return ResponseEntity.ok(generoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable Long id) {
        generoService.eliminarGenero(id);
        return ResponseEntity.noContent().build();
    }      
}
