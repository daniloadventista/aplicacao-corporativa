/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Danilo e Jaiane
 */
@ManagedBean
public class UsuarioBean {

    public UsuarioBean() {
        loginMessage = "";
        try {
            Properties props = new Properties();
//            props.load(new java.io.FileInputStream("D:\\Temp\\comFaces\\"
//                    + "aplicacao-corporativa\\Enterprise Application\\"
//                    + "Enterprise Application-war\\jndi.properties"));
            InitialContext ctx = new InitialContext();
            usuarioFacade = (UsuarioFacadeRemote) ctx.lookup("ejb/UsuarioFacade");
        } //        catch (IOException e) {
        //            System.out.println("Jndi nao encontrado");
        //        }
        catch (NamingException ex) {
            System.out.println("Jndi : Naming exception");
        }

    }
    private Usuario usuario;
    private int numero;
    @EJB
    private UsuarioFacadeRemote usuarioFacade;
    private Long id;
    private String nome;
    private String senha;
    private char sexo;
    private String email;
    private String telefone;
    private Date dataNasc;
    private Long RG;
    private Long CPF;
    private boolean isFunc;
    private String loginMessage;

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getRG() {
        return RG;
    }

    public void setRG(Long RG) {
        this.RG = RG;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public boolean isIsFunc() {
        return isFunc;
    }

    public void setIsFunc(boolean isFunc) {
        this.isFunc = isFunc;
    }

    public void create() {
        usuario = new Usuario(this.getNome(), this.getSenha());
        //setar atributos do usuario

        usuario.setCPF(this.getCPF());
        usuario.setDataNasc(this.getDataNasc());
        usuario.setEmail(this.getEmail());
        usuario.setIsFunc(this.isIsFunc());
        usuario.setNome(this.getNome());
        usuario.setRG(this.getRG());
        usuario.setSenha(this.getSenha());
        usuario.setSexo(this.getSexo());
        usuario.setTelefone(this.getTelefone());

        try {
            usuarioFacade.create(usuario);
            System.out.println("Usuario Gravado.");
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erro ao gravar Usuario.");
            System.out.println(e.toString());
            System.out.println();
        }
    }

    public List<Usuario> findAll() {
        return (usuarioFacade.findAll());
    }

    public void delete(Usuario entity) {
        usuarioFacade.remove(entity);
    }

    public void update(Usuario entity) {
        usuarioFacade.edit(entity);
    }

    public Usuario find(Object id) {
        return usuarioFacade.find(id);
    }

    public void login() {
        List<Usuario> usuarios = null;
        usuarios = this.findAll();
        
        boolean existe = false;
        for (Usuario usr : usuarios) {
            if (this.email.equals(usr.getEmail())) {
                existe = true;
                if (senha.equals(usr.getSenha())) {
                    System.out.println("Usuálio Logado");
                    this.loginMessage = "Usuálio Logado";
                    break;
                } else {
                    System.out.println("Senha Invalida");
                    this.loginMessage = ("Senha Invalida");
                }
            }
        }
        if (!existe) {
            System.out.println("Usuario Inexistente");
            this.loginMessage = ("Usuario Inexistente");
        }

    }
}