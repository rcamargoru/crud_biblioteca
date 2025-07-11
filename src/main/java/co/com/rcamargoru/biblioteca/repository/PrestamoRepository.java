/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.rcamargoru.biblioteca.repository;

import co.com.rcamargoru.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

 long countByClienteIdAndEstado(Long id, String estado);

    public boolean existsByClienteIdAndLibroIdAndEstado(Long id, Long id0, String en_préstamo);
    
}
