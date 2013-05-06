/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Produto;
import br.com.projii.jpa.facade.ProdutoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ProdutoController {

    private ProdutoFacadeRemote produtoFacade;

    public ProdutoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ProdutoFacadeRemote)ctx.lookup("ejb/ProdutoFacade");
    }

    public void create(Produto entity) {
        produtoFacade.create(entity);
    }

    public List<Produto> findAll() {
        return (produtoFacade.findAll());
    }
    public void delete(Produto entity) {
        produtoFacade.remove(entity);
    }
    public void update(Produto entity) {
        produtoFacade.edit(entity);
    }
    public Produto find(Object id) {
        return produtoFacade.find(id);
    }
}
