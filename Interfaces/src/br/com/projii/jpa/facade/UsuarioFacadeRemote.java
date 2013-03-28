/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;

import br.com.projii.jpa.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface UsuarioFacadeRemote {

    void create(Usuario contato);

    void edit(Usuario contato);

    void remove(Usuario contato);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
