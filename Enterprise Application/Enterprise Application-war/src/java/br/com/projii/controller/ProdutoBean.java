/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Produto;
import br.com.projii.jpa.facade.ProdutoFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author THIAGO
 */
@ManagedBean
public class ProdutoBean {

    public ProdutoBean() {
        loginMessage = "";
        try {
            Properties props = new Properties();
//            props.load(new java.io.FileInputStream("D:\\Temp\\comFaces\\"
//                    + "aplicacao-corporativa\\Enterprise Application\\"
//                    + "Enterprise Application-war\\jndi.properties"));
            InitialContext ctx = new InitialContext();
            produtoFacade = (ProdutoFacadeRemote) ctx.lookup("ejb/ProdutoFacade");
        } //        catch (IOException e) {
        //            System.out.println("Jndi nao encontrado");
        //        }
        catch (NamingException ex) {
            System.out.println("Jndi : Naming exception");
        }

    }
    @EJB
    private ProdutoFacadeRemote produtoFacade;
    private String loginMessage;
    private Long id;
    private String nome;
    private String descricao;
    private String especificacao;
    private Double preco;
    private Long categoriaId;

    /**
     * @return the loginMessage
     */
    public String getLoginMessage() {
        return loginMessage;
    }

    /**
     * @param loginMessage the loginMessage to set
     */
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the especificacao
     */
    public String getEspecificacao() {
        return especificacao;
    }

    /**
     * @param especificacao the especificacao to set
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the categoriaId
     */
    public Long getCategoriaId() {
        return categoriaId;
    }

    /**
     * @param categoriaId the categoriaId to set
     */
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
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

    public void listarProdutos() {
      //  Gson gson = new Gson();
        List<Produto> prod = new ArrayList<Produto> ();
        prod = this.findAll();
        //String listString = gson.toJson(prod);       
        System.out.print("testeete" + prod );

    }
}
