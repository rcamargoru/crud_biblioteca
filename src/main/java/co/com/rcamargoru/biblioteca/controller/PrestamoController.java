/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.controller;

import co.com.rcamargoru.biblioteca.dto.PrestamoRequestDTO;
import co.com.rcamargoru.biblioteca.dto.PrestamoResponseDTO;
import co.com.rcamargoru.biblioteca.service.PrestamoService;
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
@RequestMapping("/api/prestamos")
public class PrestamoController {
 private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDTO> crearPrestamo(@RequestBody PrestamoRequestDTO request) {
        PrestamoResponseDTO nuevoPrestamo = prestamoService.crearPrestamo(request);
        return ResponseEntity.ok(nuevoPrestamo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponseDTO> obtenerPrestamoPorId(@PathVariable Long id) {
        PrestamoResponseDTO Prestamo = prestamoService.obtenerPrestamoPorId(id);
        return ResponseEntity.ok(Prestamo);
    }

    @GetMapping
    public ResponseEntity<List<PrestamoResponseDTO>> obtenerTodosLosPrestamos() {
        List<PrestamoResponseDTO> prestamos = prestamoService.listarPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoResponseDTO> actualizarPrestamo(
            @PathVariable Long id,
            @RequestBody PrestamoRequestDTO request) {
        PrestamoResponseDTO actualizado = prestamoService.actualizarPrestamo(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }      
}
