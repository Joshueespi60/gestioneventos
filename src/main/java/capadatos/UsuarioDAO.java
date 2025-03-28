/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capaentidad.Usuario;
import java.sql.*;

/**
 *
 * @author Joshue
 */
public class UsuarioDAO {
     // Método para verificar si un usuario existe en la base de datos
    public Usuario login(String username, String password) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection connection = ConexionDB.getConnection(); 
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, username);  // Establecer el nombre de usuario
            pst.setString(2, password);  // Establecer la contraseña

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta.");
            e.printStackTrace();
        }
        return usuario;
    }
}
