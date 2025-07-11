/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "prestamos")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario cliente;
    
    private Date fechaPrestamo;
    private Date fechaPosibleDevolucion;
    private Date fechaRealDevolucion;
    private String estado;  
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the cliente
     */
    public Usuario getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaPrestamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fechaPosibleDevolucion
     */
    public Date getFechaPosibleDevolucion() {
        return fechaPosibleDevolucion;
    }

    /**
     * @param fechaPosibleDevolucion the fechaPosibleDevolucion to set
     */
    public void setFechaPosibleDevolucion(Date fechaPosibleDevolucion) {
        this.fechaPosibleDevolucion = fechaPosibleDevolucion;
    }

    /**
     * @return the fechaRealDevolucion
     */
    public Date getFechaRealDevolucion() {
        return fechaRealDevolucion;
    }

    /**
     * @param fechaRealDevolucion the fechaRealDevolucion to set
     */
    public void setFechaRealDevolucion(Date fechaRealDevolucion) {
        this.fechaRealDevolucion = fechaRealDevolucion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
 
 
}
