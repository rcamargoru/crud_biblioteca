/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.controller;

import co.com.rcamargoru.biblioteca.dto.LibroRequestDTO;
import co.com.rcamargoru.biblioteca.dto.LibroResponseDTO;
import co.com.rcamargoru.biblioteca.service.LibroService;
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
 * controlador para ser llamado desde http para la gestión de libros
 */
@RestController
@RequestMapping("/api/libros")
public class LibroController {
   private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroResponseDTO> crearLibro(@RequestBody LibroRequestDTO request) {
        LibroResponseDTO nuevoLibro = libroService.crearLibro(request);
        return ResponseEntity.ok(nuevoLibro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> obtenerLibroPorId(@PathVariable Long id) {
        LibroResponseDTO libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> obtenerTodosLosLibros() {
        List<LibroResponseDTO> libros = libroService.listarLibros();
        return ResponseEntity.ok(libros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> actualizarLibro(
            @PathVariable Long id,
            @RequestBody LibroRequestDTO request) {
        LibroResponseDTO actualizado = libroService.actualizarLibro(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }  
}
