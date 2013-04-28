/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Filial;
import br.com.projii.jpa.facade.FilialFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class FilialController {

    private FilialFacadeRemote filialFacade;

    public FilialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        filialFacade = (FilialFacadeRemote)ctx.lookup("ejb/FilialFacade");
    }

    public void create(Filial entity) {
        filialFacade.create(entity);
    }

    public List<Filial> findAll() {
        return (filialFacade.findAll());
    }
    public void delete(Filial entity) {
        filialFacade.remove(entity);
    }
    public void update(Filial entity) {
        filialFacade.edit(entity);
    }
    public Filial find(Object id) {
        return filialFacade.find(id);
    }
}
