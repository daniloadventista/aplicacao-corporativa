/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.Filial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class FilialFacade extends AsbstractFacade<Filial> implements FilialFacadeRemote {
@Stateless(mappedName = "ejb/FilialFacade")
public class FilialFacade extends AbstractFacade<Filial> implements FilialFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilialFacade() {
        super(Filial.class);
    }
}
