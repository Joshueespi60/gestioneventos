/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capaentidad.Evento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joshue
 */
public class EventoDAO {
    private Connection connection;

    public EventoDAO() {
        // Conexión a la base de datos
        this.connection = ConexionDB.getConnection();
    }

    // Método para guardar un nuevo evento
    public boolean guardarEvento(Evento evento) {
        String query = "INSERT INTO eventos (nombre, fecha, lugar, descripcion, capacidad, precio) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, evento.getNombre());
            pst.setTimestamp(2, Timestamp.valueOf(evento.getFecha()));  // Convierte LocalDateTime a Timestamp
            pst.setString(3, evento.getLugar());
            pst.setString(4, evento.getDescripcion());
            pst.setInt(5, evento.getCapacidad());
            pst.setDouble(6, evento.getPrecio());
            
            return pst.executeUpdate() > 0;  // Si la inserción es exitosa
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para obtener todos los eventos
    public List<Evento> obtenerEventos() {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Evento evento = new Evento(
                        rs.getInt("id_evento"),
                        rs.getString("nombre"),
                        rs.getTimestamp("fecha").toLocalDateTime(), // Convertir Timestamp a LocalDateTime
                        rs.getString("lugar"),
                        rs.getString("descripcion"),
                        rs.getInt("capacidad"),
                        rs.getDouble("precio")
                );
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return eventos;
    }
}
