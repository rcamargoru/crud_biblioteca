/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.rcamargoru.biblioteca.repository;

import co.com.rcamargoru.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 * repostiorio para crud de autor
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
