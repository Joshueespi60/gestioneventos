/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidad;

import java.time.LocalDateTime;


public class Evento {
     private int id;
    private String nombre;
    private LocalDateTime fecha;
    private String lugar;
    private String descripcion;
    private int capacidad;
    private double precio;

    // Constructor para crear un evento
    public Evento(String nombre, LocalDateTime fecha, String lugar, String descripcion, int capacidad, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Constructor cuando se obtiene un evento de la base de datos
    public Evento(int id, String nombre, LocalDateTime fecha, String lugar, String descripcion, int capacidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    // Getters
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

    // Setters (solo si es necesario)
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString (Opcional)
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                '}';
    }
}
