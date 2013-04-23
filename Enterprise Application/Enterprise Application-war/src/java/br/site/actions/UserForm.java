/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.site.actions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eswar@vaannila.com
 */
@Entity
@Table(name = "CADASTRO")
public class UserForm extends org.apache.struts.action.ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    @Id
    @GeneratedValue
    @Column(name = "ID_CAD")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "EMAIL_CAD", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "SENHA_CAD", nullable = false, length = 20)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Column(name = "TEL_CAD", nullable = false, length = 20)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "ENDE_CAD", nullable = false, length = 100)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public UserForm() {
        super();
        // TODO Auto-generated constructor stub
    }
}
