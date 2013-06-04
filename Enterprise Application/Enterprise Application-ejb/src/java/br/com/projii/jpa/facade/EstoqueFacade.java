/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.Estoque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class EstoqueFacade extends AsbstractFacade<Estoque> implements EstoqueFacadeRemote {
@Stateless(mappedName = "ejb/EstoqueFacade")
public class EstoqueFacade extends AbstractFacade<Estoque> implements EstoqueFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueFacade() {
        super(Estoque.class);
    }
}
