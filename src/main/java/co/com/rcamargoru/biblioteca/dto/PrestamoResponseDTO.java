/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.dto;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class PrestamoResponseDTO {

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
     * @return the libroNombre
     */
    public String getLibroNombre() {
        return libroNombre;
    }

    /**
     * @param libroNombre the libroNombre to set
     */
    public void setLibroNombre(String libroNombre) {
        this.libroNombre = libroNombre;
    }

    /**
     * @return the clienteNombre
     */
    public String getClienteNombre() {
        return clienteNombre;
    }

    /**
     * @param clienteNombre the clienteNombre to set
     */
    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
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
    private Long id;
    private String libroNombre;
    private String clienteNombre;
    private Date fechaPrestamo;
    private Date fechaPosibleDevolucion;
    private Date fechaRealDevolucion;
    private String estado;    
}
