/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.ItemPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class ItemPedidoFacade extends AsbstractFacade<ItemPedido> implements ItemPedidoFacadeRemote {
@Stateless(mappedName = "ejb/ItemPedidoFacade")
public class ItemPedidoFacade extends AbstractFacade<ItemPedido> implements ItemPedidoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemPedidoFacade() {
        super(ItemPedido.class);
    }
}
