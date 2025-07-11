/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.dto;

import java.util.Date;

/**
 *
 * @author Administrador
 * clase intermedia para no depender de la entidad prestamo - entrada
 */
public class PrestamoRequestDTO {

 
    private Long libroId;
    private Long clienteId;
    private Date fechaPrestamo;
    private Date fechaPosibleDevolucion;
    private Date fechaRealDevolucion;
    private String estado;     
  
   /**
     * @return the libroId
     */
    public Long getLibroId() {
        return libroId;
    }

    /**
     * @param libroId the libroId to set
     */
    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    /**
     * @return the clienteId
     */
    public Long getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
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
