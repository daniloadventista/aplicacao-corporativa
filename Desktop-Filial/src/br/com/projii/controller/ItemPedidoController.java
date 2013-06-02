/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.ItemPedido;
import br.com.projii.jpa.facade.ItemPedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ItemPedidoController {

    private ItemPedidoFacadeRemote itemPedidoFacadeRemote;

    public ItemPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        itemPedidoFacadeRemote = (ItemPedidoFacadeRemote)ctx.lookup("ejb/ItemPedidoFacade");
    }

    public void create(ItemPedido entity) {
        itemPedidoFacadeRemote.create(entity);
    }

    public List<ItemPedido> findAll() {
        return (itemPedidoFacadeRemote.findAll());
    }
    public void delete(ItemPedido entity) {
        itemPedidoFacadeRemote.remove(entity);
    }
    public void update(ItemPedido entity) {
        itemPedidoFacadeRemote.edit(entity);
    }
    public ItemPedido find(Object id) {
        return itemPedidoFacadeRemote.find(id);
    }
}
