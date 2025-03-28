/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;
import capadatos.EventoDAO;
import capaentidad.Evento;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Joshue
 */
public class EventoNegocio {
   private EventoDAO eventoDAO;

    public EventoNegocio() {
        eventoDAO = new EventoDAO();
    }

    // Método para guardar un nuevo evento
    public boolean guardarEvento(String nombre, String fecha, String lugar, String descripcion, int capacidad, double precio) {
        // Convertir la fecha de String a LocalDateTime
        LocalDateTime fechaEvento = LocalDateTime.parse(fecha);
        
        Evento evento = new Evento(nombre, fechaEvento, lugar, descripcion, capacidad, precio);
        
        return eventoDAO.guardarEvento(evento);  // Llamamos al método DAO para guardar el evento
    }

    // Método para obtener todos los eventos
    public List<Evento> obtenerEventos() {
        return eventoDAO.obtenerEventos();
    }
}
