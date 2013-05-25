/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.GUI;

import javax.swing.JScrollPane;

/**
 *
 * @author 41080130
 */
public class BaseJF extends javax.swing.JFrame {

    /**
     * Creates new form BaseJF
     */

    private String Usuario;

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    private PLogin login;
    private EfetuarCompra efetuarCompra;
    private JScrollPane jScrollPane;

    public BaseJF() {
        initComponents();
        this.setTitle("System Mack");
        this.setResizable(false);
        callLogin();
        //callManterUsuario();
    }
    
    protected void removerTudo() {
        this.getContentPane().removeAll();
    }

    protected void atualizaUsr() {
        jMILogar.setText(this.Usuario);
    }

    protected void callLogin() {
        removerTudo();
        initComponents();

        jMILogar.setText("Login");
        login = new PLogin(this);
        this.add(login);
        login.setVisible(true);
        //(800,600)
        login.setLocation(200, 100);
        login.setSize(400, 300);
    }
    
    private void callEfetuarCompra() {
        removerTudo();
        initComponents();

        efetuarCompra = new EfetuarCompra();
        jScrollPane = new JScrollPane(efetuarCompra);
        this.add(jScrollPane);

        jScrollPane.setVisible(true);
        //(800,600)
        jScrollPane.setLocation(150, 100);
        jScrollPane.setSize(500, 410);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMArquivo = new javax.swing.JMenu();
        jMEditar = new javax.swing.JMenu();
        jMILogar = new javax.swing.JMenuItem();
        jMMUsuario = new javax.swing.JMenu();
        jMICompra = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jMArquivo.setText("Arquivo");
        jMenuBar1.add(jMArquivo);

        jMEditar.setText("Editar");

        jMILogar.setText("Usuario");
        jMILogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILogarActionPerformed(evt);
            }
        });
        jMEditar.add(jMILogar);

        jMenuBar1.add(jMEditar);

        jMMUsuario.setText("Compra");
        jMMUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMMUsuarioFocusGained(evt);
            }
        });

        jMICompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMICompra.setText("Efetuar Compra");
        jMICompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICompraActionPerformed(evt);
            }
        });
        jMMUsuario.add(jMICompra);

        jMenuBar1.add(jMMUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMILogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILogarActionPerformed
        removerTudo();
        callLogin();
    }//GEN-LAST:event_jMILogarActionPerformed

    private void jMICompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICompraActionPerformed
        callEfetuarCompra();
    }//GEN-LAST:event_jMICompraActionPerformed

    private void jMMUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMMUsuarioFocusGained

    }//GEN-LAST:event_jMMUsuarioFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaseJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseJF().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMArquivo;
    private javax.swing.JMenu jMEditar;
    private javax.swing.JMenuItem jMICompra;
    private javax.swing.JMenuItem jMILogar;
    private javax.swing.JMenu jMMUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

    
}