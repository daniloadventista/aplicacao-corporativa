/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Estoque;
import br.com.projii.jpa.facade.EstoqueFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EstoqueController {

    private EstoqueFacadeRemote estoqueFacadeRemote;

    public EstoqueController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        estoqueFacadeRemote = (EstoqueFacadeRemote)ctx.lookup("ejb/EstoqueFacade");
    }

    public void create(Estoque entity) {
        estoqueFacadeRemote.create(entity);
    }

    public List<Estoque> findAll() {
        return (estoqueFacadeRemote.findAll());
    }
    public void delete(Estoque entity) {
        estoqueFacadeRemote.remove(entity);
    }
    public void update(Estoque entity) {
        estoqueFacadeRemote.edit(entity);
    }
    public Estoque find(Object id) {
        return estoqueFacadeRemote.find(id);
    }
}
