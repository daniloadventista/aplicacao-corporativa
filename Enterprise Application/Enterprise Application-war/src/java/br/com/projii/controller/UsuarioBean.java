/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
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
        usuario = new Usuario("", "");
    }
    private Usuario usuario;
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void Usuario(String nome, String senha) {
        this.usuario = new Usuario(nome, senha);
    }

    public String getNome() {
        return this.usuario.getNome();
    }

    public String getSenha() {
        return this.usuario.getSenha();
    }

    public void setNome(String nome) {
        this.usuario.setNome(nome);
    }

    public void setSenha(String senha) {
        usuario.setSenha(senha);
    }

    public Long getId() {
        return this.usuario.getId();
    }

    public void setId(Long id) {
        this.usuario.setId(id);
    }

    public String getTelefone() {
        return this.usuario.getTelefone();
    }

    public void setTelefone(String telefone) {
        this.usuario.setTelefone(telefone); 
    }

    public String getEndereco() {
        return this.usuario.getEndereco();
    }

    public void setEndereco(String endereco) {
        this.usuario.setEndereco(endereco);
    }

    public Long getCep() {
        return this.usuario.getCPF();
    }

    public void setCep(Long cep) {
        this.usuario.setCPF(cep);
    }

    public char getSexo() {
        return this.usuario.getSexo();
    }

    public void setSexo(char sexo) {
        this.usuario.setSexo(sexo);
    }

    public String getEmail() {
        return this.usuario.getEmail();
    }

    public void setEmail(String email) {
        this.usuario.setEmail(email);
    }

    public Date getDataNasc() {
        return this.usuario.getDataNasc();
    }

    public void setDataNasc(String dataNasc) {
        this.setDataNasc(dataNasc);
    }

    public Long getRG() {
        return this.usuario.getRG();
    }

    public void setRG(Long RG) {
        this.setRG(RG);
    }

    public Long getCPF() {
        return this.usuario.getCPF();
    }

    public void setCPF(Long CPF) {
        this.usuario.setCPF(CPF);
    }

    public boolean isIsFunc() {
        return this.usuario.isIsFunc();
    }

    public void setIsFunc(boolean isFunc) {
        this.setIsFunc(isFunc);
    }
}