/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.controller;

import br.com.projii.jpa.Usuario;
import br.com.projii.jpa.facade.UsuarioFacadeRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

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
    private Usuario usuario = new Usuario(null, null);
    private int numero;
    @EJB
    private UsuarioFacadeRemote usuarioFacade;
    private Long id;
    private String nome;
    private String senha;
    private String senha2;
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

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public void create() {
        setUsuario(new Usuario(this.getNome(), this.getSenha()));
        //setar atributos do usuario

        getUsuario().setCPF(this.getCPF());
        getUsuario().setDataNasc(this.getDataNasc());
        getUsuario().setEmail(this.getEmail());
        getUsuario().setIsFunc(this.isIsFunc());
        getUsuario().setNome(this.getNome());
        getUsuario().setRG(this.getRG());
        getUsuario().setSenha(this.getSenha());
        getUsuario().setSexo(this.getSexo());
        getUsuario().setTelefone(this.getTelefone());

        try {
            if (!usuario.getSenha().equals(getSenha2())) {
                this.loginMessage = "Senhas não correspondem.";
                System.out.println("Senhas não correspondem.");
            } else {
                usuarioFacade.create(getUsuario());
                System.out.println("Usuario Gravado.");
                this.loginMessage = "Usuálio Gravado";
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erro ao gravar Usuario.");
            this.loginMessage = "Erro ao gravar Usuario";
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

    public String login() throws IOException {
        List<Usuario> usuarios = null;
        usuarios = this.findAll();

        boolean existe = false;
        for (Usuario usr : usuarios) {
            if (this.email.equals(usr.getEmail())) {
                existe = true;
                if (senha.equals(usr.getSenha())) {
                    System.out.println("Usuálio Logado");
                    this.loginMessage = "Usuálio Logado";
                    //  callFind(usr.getId());
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nome", nome);
                    HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    sessao.setAttribute("user", usr);
                    setUsuario(usr);
                   // FacesContext.getCurrentInstance().getExternalContext().redirect("/Enterprise_Application-war/minhaConta.xhtml");
                    break;
                } else {
                    //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                    System.out.println("Senha Invalida");
                    this.loginMessage = ("Senha Invalida");
                }
            }
        }
        if (!existe) {
            System.out.println("Usuario Inexistente");
            this.loginMessage = ("Usuario Inexistente");
        }
        return "minhaConta";
    }

    public String logout() throws IOException {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.clear();
        return "login";
    }

    public void callFind(long id) {
        try {

            this.setUsuario(find(id));
            this.nome = getUsuario().getNome();
            this.email = getUsuario().getEmail();
            this.senha = getUsuario().getSenha();
            this.telefone = getUsuario().getTelefone();
            this.CPF = getUsuario().getCPF();
            this.RG = getUsuario().getRG();
            this.dataNasc = getUsuario().getDataNasc();
            this.sexo = getUsuario().getSexo();

        } catch (Exception e) {
            System.out.print("buscar");
        }
    }

    public String alterarCliente() {
        UsuarioBean bean = new UsuarioBean();
        usuario = bean.find(id);
        usuario.setCPF(this.getCPF());
        usuario.setDataNasc(this.getDataNasc());
        usuario.setEmail(this.getEmail());
        usuario.setIsFunc(this.isIsFunc());
        usuario.setNome(this.getNome());
        usuario.setRG(this.getRG());
        usuario.setSenha(this.getSenha());
        usuario.setSexo(this.getSexo());
        usuario.setTelefone(this.getTelefone());
        
        bean.update(usuario);
        return "minhaConta";

    }
    private DataModel listaDados;

    public DataModel getListarClientes() {
//        List<Usuario> usuarios = null;
//        usuarios = this.findAll();
//        for (Usuario usr : usuarios) {
//
//            if (this.email.equals(usr.getEmail()) && senha.equals(usr.getSenha())) {
        //List<Usuario> lista = new UsuarioBean().findAll();
        List<Usuario> lista = new ArrayList<Usuario>();
        lista.add(usuario);
        listaDados = new ListDataModel(lista);
//                
//            }
//        }
        return listaDados;

    }
       
    public String prepararAlterarCliente() {
        setUsuario((Usuario) (listaDados.getRowData()));
     
        return "minhaConta";
    }

    public String excluirCliente() {

        Usuario cad = (Usuario) (listaDados.getRowData());
        UsuarioBean user = new UsuarioBean();
        user.delete(cad);
        return "minhaConta";

    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}