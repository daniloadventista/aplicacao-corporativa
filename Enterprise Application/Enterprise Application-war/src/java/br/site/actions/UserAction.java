/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.site.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 *
 * @author eswar@vaannila.com
 */
public class UserAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String CONTATO = "contato";
    private final static String SERVICOS = "servicos";
    private final static String LOCAL = "local";
    private final static String EMPRESA = "empresa";
    private final static String GALERIA = "galeria";
    private final static String STUDIO = "studio";
    private final static String PRODUTOS = "produtos";
    private final static String SAUDE = "saude";
    private final static String ESTETICA = "estetica";
    private final static String PESMAOS = "pesmaos";
    private final static String NOIVA = "noiva";
    private final static String LAPIS = "lapis";
    private final static String CURIOSIDADES = "curiosidades";
    private final static String HIDRAT = "hidrat";
    
    public ActionForward home(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      
        return mapping.findForward(SUCCESS);
    }

    public ActionForward contato(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	//GenericDAO teste = new GenericDAO();

        UserForm userForm = (UserForm) form;
        //userForm.salvar(userForm);
        //userForm.setMessage("Inside update user method.");
        return mapping.findForward(CONTATO);
    }

    public ActionForward servicos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm userForm = (UserForm) form;
      //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(SERVICOS);
        
    }
    public ActionForward local(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(LOCAL);
        }
    public ActionForward empresa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(EMPRESA);
        }
    public ActionForward galeria(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(GALERIA);
        }
    public ActionForward studio(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(STUDIO);
        }
    public ActionForward produtos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(PRODUTOS);
        }
    public ActionForward paginaSaude(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(SAUDE);
        }
    public ActionForward estetica(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(ESTETICA);
        }
    public ActionForward pesmaos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(PESMAOS);
        }
    public ActionForward noiva(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(NOIVA);
        }
    public ActionForward lapis(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(LAPIS);
        }
    public ActionForward curiosidades(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(CURIOSIDADES);
        }
    public ActionForward hidrat(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       UserForm userForm = (UserForm) form;
          //  userForm.setMessage("Inside delete user method.");
        return mapping.findForward(HIDRAT);
        }
}