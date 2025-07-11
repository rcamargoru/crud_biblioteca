/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.dto;

/**
 *
 * @author Administrador
 */
public class LibroResponseDTO {

    private Long id;
    private String titulo;
    private String autorNombre;
    private String generoNombre;
    private int stock;
    private String isbn;
    private Boolean estado;

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
     * @return the autorNombre
     */
    public String getAutorNombre() {
        return autorNombre;
    }

    /**
     * @param autorNombre the autorNombre to set
     */
    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the generoNombre
     */
    public String getGeneroNombre() {
        return generoNombre;
    }

    /**
     * @param generoNombre the generoNombre to set
     */
    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
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
