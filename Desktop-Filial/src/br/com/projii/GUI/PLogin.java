/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.GUI;

import br.com.projii.controller.CategoriaController;
import br.com.projii.controller.FilialController;
import br.com.projii.controller.UsuarioController;
import br.com.projii.jpa.Categoria;
import br.com.projii.jpa.Filial;
import br.com.projii.jpa.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dj002
 */
public class PLogin extends javax.swing.JPanel {

    private static BaseJF Parent;
    /**
     * Creates new form PLogin
     */
    private FilialController filialController = null;

    public PLogin(BaseJF parent) {
        this.Parent = parent;
        initComponents();
        atualizarComboBoxes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCBFilial = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Nome de Usuario");

        jLabel2.setText("Senha");

        jButton1.setText("Logar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCBFilial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));

        jLabel3.setText("Filial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBFilial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UsuarioController uc;
        List<Usuario> usuarios = null;
        try {
            uc = new UsuarioController();
            usuarios = uc.findAll();
        } catch (Exception ex) {
            Logger.getLogger(PLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        char[] senha;
        String strSenha = "";
        boolean existe = false;
        for (Usuario usr : usuarios) {
            if (jTextField1.getText().equals(usr.getNome())) {
                existe = true;
                senha = jPasswordField1.getPassword();
                strSenha = new String(senha);
                if (strSenha.equals(usr.getSenha())) {
                    JOptionPane.showMessageDialog(this, "Usuálio Logado");
                    this.Parent.setUsuario(usr.getNome());
                    this.Parent.setIdUsuario(usr.getId());
                    this.Parent.setSFilial(jCBFilial.getSelectedItem().toString());
                    this.Parent.atualizaUsr();
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Senha Invalida");
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "Usuario Inexistente");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void atualizarComboBoxes() {
        try {
            if (filialController == null) {
                filialController = new FilialController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        List<Filial> filiais = filialController.findAll();

      
        jCBFilial.removeAllItems();
        for (Filial filial : filiais) {
            jCBFilial.addItem(filial.getNome());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCBFilial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
