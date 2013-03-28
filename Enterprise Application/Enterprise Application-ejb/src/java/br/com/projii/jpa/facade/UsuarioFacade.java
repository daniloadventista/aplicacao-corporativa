/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class UsuarioFacade extends AsbstractFacade<Usuario> implements UsuarioFacadeRemote {
@Stateless(mappedName = "ejb/UsuarioFacade")
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
}
