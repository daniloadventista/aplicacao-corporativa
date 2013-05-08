/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacade;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Danilo e Jaiane
 */
@ManagedBean
public class UsuarioController {


    @EJB
    private UsuarioFacadeRemote usuarioFacade;
    private int numero;

    public UsuarioController() {
        usuarioFacade = new UsuarioFacade();
    }
    
    public void create(Usuario usuario) {
        if (!(usuarioFacade == null)) {
            if (!(usuario == null)) {
                try {
                    usuarioFacade.create(usuario);
                    System.out.println("Erro ao gravar Usuario.");
                } catch (Exception e) {
                    System.out.println("Erro ao gravar Usuario.");
                }
            }
        }
    }
}