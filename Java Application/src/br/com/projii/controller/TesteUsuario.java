/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dj002
 */
public class TesteUsuario {
    public static void main(String[] args){
        try {
            UsuarioController usuarioController = new UsuarioController();
            Usuario usuario = new Usuario("Teste", "55543211234");
            usuario.setCPF(new Long("22233344485"));
            usuario.setCep(new Long("09300500"));
            usuario.setDataNasc(new Date());
            usuario.setEmail("teste@teste.com");
            usuario.setEndereco("Rua teste");
            usuario.setRG(new Long("407001001"));
            usuario.setSenha("teste");
            usuario.setSexo('M');
            
            usuarioController.create(usuario);
            
        } catch (Exception ex) {
            Logger.getLogger(TesteUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
