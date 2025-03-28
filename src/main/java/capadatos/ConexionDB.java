/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/gestioneventos";  // URL de la base de datos
    private static final String USER = "root";  // Usuario de la base de datos
    private static final String PASSWORD = "";  // Contraseña de la base de datos

    // Método para obtener la conexión
    public static Connection getConnection() {
        try {
            System.out.println("Intentando conectar a la base de datos...");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
}
