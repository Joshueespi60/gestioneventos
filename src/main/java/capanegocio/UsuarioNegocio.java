/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.UsuarioDAO;
import capaentidad.Usuario;

/**
 *
 * @author Joshue
 */
public class UsuarioNegocio {
    private UsuarioDAO usuarioDAO;

    public UsuarioNegocio() {
        usuarioDAO = new UsuarioDAO();
    }

    // Método para validar el usuario
    public boolean validarUsuario(String username, String password) {
        Usuario usuario = usuarioDAO.login(username, password);
        
        if (usuario != null) {
            return true;  // El usuario fue encontrado
        } else {
            return false;  // El usuario no fue encontrado o la contraseña es incorrecta
        }
    }
}
