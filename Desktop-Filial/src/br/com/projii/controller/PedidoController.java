/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Pedido;
import br.com.projii.jpa.facade.PedidoFacadeRemote;
import br.com.projii.jpa.facade.PedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PedidoController {

    private PedidoFacadeRemote pedidoFacade;

    public PedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        pedidoFacade = (PedidoFacadeRemote)ctx.lookup("ejb/PedidoFacade");
    }

    public void create(Pedido entity) {
        pedidoFacade.create(entity);
    }

    public List<Pedido> findAll() {
        return (pedidoFacade.findAll());
    }
    public void delete(Pedido entity) {
        pedidoFacade.remove(entity);
    }
    public void update(Pedido entity) {
        pedidoFacade.edit(entity);
    }
    public Pedido find(Object id) {
        return pedidoFacade.find(id);
    }
}
