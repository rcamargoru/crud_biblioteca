/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.dto;

import co.com.rcamargoru.biblioteca.model.Autor;

/**
 *
 * @author Administrador
 */
//Clase para crear/editar
public class LibroRequestDTO {

    private String titulo;
    private Long autorId;
    private Long generoId;
    private int stock;
    private Boolean estado;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autorId
     */
    public Long getAutorId() {
        return autorId;
    }

    /**
     * @param autorId the autorId to set
     */
    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    /**
     * @return the generoId
     */
    public Long getGeneroId() {
        return generoId;
    }

    /**
     * @param generoId the generoId to set
     */
    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
