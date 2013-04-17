/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class CategoriaFacade extends AsbstractFacade<Categoria> implements CategoriaFacadeRemote {
@Stateless(mappedName = "ejb/CategoriaFacade")
public class CategoriaFacade extends AbstractFacade<Categoria> implements CategoriaFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
}
