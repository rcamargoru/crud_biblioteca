/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.rcamargoru.biblioteca.repository;

import co.com.rcamargoru.biblioteca.model.Prestamo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 * repostiorio para crud de prestamo
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

 long countByClienteIdAndEstado(Long id, String estado);

    public boolean existsByClienteIdAndLibroIdAndEstado(Long id, Long id0, String en_préstamo);
    
        @Query("SELECT FUNCTION('MONTH', p.fechaPrestamo) AS mes, COUNT(p) " +
           "FROM Prestamo p " +
           "WHERE FUNCTION('YEAR', p.fechaPrestamo) = :anio " +
           "GROUP BY FUNCTION('MONTH', p.fechaPrestamo) " +
           "ORDER BY mes")
            List<Object[]> contarPrestamosPorMes(int anio);
    
}
