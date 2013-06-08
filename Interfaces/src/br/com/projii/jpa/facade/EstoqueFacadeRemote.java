/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;

import br.com.projii.jpa.Estoque;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EstoqueFacadeRemote {

    void create(Estoque estoque);

    void edit(Estoque estoque);

    void remove(Estoque estoque);

    Estoque find(Object id);

    List<Estoque> findAll();

    List<Estoque> findRange(int[] range);

    int count();

    public List<Estoque> csPorId(Long idProduto);
    
}