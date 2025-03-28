/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidad;

import java.time.LocalDateTime;

/**
 *
 * @author Joshue
 */
public class Evento {
    private int id;
    private String nombre;
    private LocalDateTime fecha;
    private String lugar;
    private String descripcion;
    private int capacidad;
    private double precio;

    public Evento(String nombre, LocalDateTime fecha, String lugar, String descripcion, int capacidad, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Constructor para cuando obtenemos un evento de la base de datos
    public Evento(int id, String nombre, LocalDateTime fecha, String lugar, String descripcion, int capacidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecio() {
        return precio;
    }
}
