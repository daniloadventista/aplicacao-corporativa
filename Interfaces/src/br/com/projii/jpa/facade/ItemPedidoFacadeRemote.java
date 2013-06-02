/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;

import br.com.projii.jpa.ItemPedido;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface ItemPedidoFacadeRemote {

    void create(ItemPedido itemPedido);

    void edit(ItemPedido itemPedido);

    void remove(ItemPedido itemPedido);

    ItemPedido find(Object id);

    List<ItemPedido> findAll();

    List<ItemPedido> findRange(int[] range);

    int count();
    
}