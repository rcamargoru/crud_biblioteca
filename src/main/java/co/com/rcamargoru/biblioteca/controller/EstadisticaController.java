/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.controller;

import co.com.rcamargoru.biblioteca.service.EstadisticaService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 * controlador para ser llamado desde http para la gestión de estadisticas
 */
@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    private final EstadisticaService estadisticaService;

    public EstadisticaController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }
//metodo para extraer datos y hacer graficas
    @GetMapping("/prestamos-por-mes")
    public Map<Integer, Long> obtenerPrestamosPorMes(@RequestParam int anio) {
        return estadisticaService.obtenerPrestamosPorMes(anio);
    }    
}
