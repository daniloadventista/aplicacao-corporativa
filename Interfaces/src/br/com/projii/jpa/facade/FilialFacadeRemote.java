/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;

import br.com.projii.jpa.Filial;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface FilialFacadeRemote {

    void create(Filial filial);

    void edit(Filial filial);

    void remove(Filial filial);

    Filial find(Object id);

    List<Filial> findAll();

    List<Filial> findRange(int[] range);

    int count();
    
}