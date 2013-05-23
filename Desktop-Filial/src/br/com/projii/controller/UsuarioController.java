/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class UsuarioController {

    private UsuarioFacadeRemote usuarioFacade;

    public UsuarioController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        usuarioFacade = (UsuarioFacadeRemote)ctx.lookup("ejb/UsuarioFacade");
    }

    public void create(Usuario entity) {
        usuarioFacade.create(entity);
    }

    public List<Usuario> findAll() {
        return (usuarioFacade.findAll());
    }
    public void delete(Usuario entity) {
        usuarioFacade.remove(entity);
    }
    public void update(Usuario entity) {
        usuarioFacade.edit(entity);
    }
    public Usuario find(Object id) {
        return usuarioFacade.find(id);
    }
}
