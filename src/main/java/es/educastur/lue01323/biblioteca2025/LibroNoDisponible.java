/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.lue01323.biblioteca2025;

/**
 *
 * @author 1dawd12
 */
public class LibroNoDisponible extends Exception {

    public LibroNoDisponible(String cadena) {
        super(cadena);                                                          //Llama al constructor de Exception
    }
}
