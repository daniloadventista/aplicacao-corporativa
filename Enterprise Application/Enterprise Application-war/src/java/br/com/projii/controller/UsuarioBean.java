/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacade;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Danilo e Jaiane
 */
@ManagedBean
public class UsuarioBean {

    public UsuarioBean() {
        usuarioFacade = new UsuarioFacade();
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
        usuario.setNome(this.getSenha());
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
}