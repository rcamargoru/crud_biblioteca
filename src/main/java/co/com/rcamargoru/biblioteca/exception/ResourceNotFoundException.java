/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.rcamargoru.biblioteca.exception;

/**
 *
 * @author Administrador
 * Clase para el manejo de errores de no enocntrar
 */
public class ResourceNotFoundException extends RuntimeException{
    
     public ResourceNotFoundException(String mensaje) {
        super(mensaje); 
    }   
}
