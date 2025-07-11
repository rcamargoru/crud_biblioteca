/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.service;

import co.com.rcamargoru.biblioteca.repository.PrestamoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 * Logica de app - estadistica
 */
@Service
public class EstadisticaService {
 private final PrestamoRepository prestamoRepository;

    public EstadisticaService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Map<Integer, Long> obtenerPrestamosPorMes(int anio) {
        List<Object[]> resultados = prestamoRepository.contarPrestamosPorMes(anio);

        Map<Integer, Long> prestamosPorMes = new HashMap<>();
        for (Object[] fila : resultados) {
            Integer mes = ((Number) fila[0]).intValue();
            Long cantidad = ((Number) fila[1]).longValue();
            prestamosPorMes.put(mes, cantidad);
        }
        return prestamosPorMes;
    }   
}
