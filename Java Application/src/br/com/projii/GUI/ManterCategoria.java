/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.GUI;

import br.com.projii.controller.CategoriaController;
import br.com.projii.jpa.Categoria;
import com.sun.msv.scanner.dtd.MessageCatalog;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dj002
 */
public class ManterCategoria extends javax.swing.JPanel {

    private CategoriaController categoriaController = null;

    /**
     * Creates new form ManterCategoria
     */
    public ManterCategoria() {
        initComponents();
        atualizarJTCategoria();
        ajustaTablePreferences();

    }

    private void ajustaTablePreferences() {
//        jTCategoria.setSize(1500, 300);
        jTCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTCategoria.getColumnModel().getColumn(1).setPreferredWidth(200);
        
    }

    public void atualizarJTCategoria() {
        try {
            if (categoriaController == null) {
                categoriaController = new CategoriaController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        Categoria[] categorias = categoriaController.findAll().toArray(new Categoria[0]);
        Object[][] objects = new Object[categorias.length][2];
        for (int i = 0; i < categorias.length; i++) {
            objects[i][0] = categorias[i].getId();
            objects[i][1] = categorias[i].getNome();
        }
        jTCategoria.setModel(new javax.swing.table.DefaultTableModel(
                objects,
                new String[]{
                    "id", "Nome"
                }));
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
        jLabel2 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jTFNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCategoria = new javax.swing.JTable();
        jBCadastrar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(490, 400));
        setRequestFocusEnabled(false);

        jLabel1.setText("id");

        jLabel2.setText("nome");

        jTFId.setEditable(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 280));

        jTCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCategoria);

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCadastrar)
                    .addComponent(jBExcluir)
                    .addComponent(jBAlterar)
                    .addComponent(jBLimpar)))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void limpaTxts() {
        jTFId.setText("");
        jTFNome.setText("");
    }
    private void jTCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCategoriaMouseClicked
        // TODO add your handling code here:
        //botao alterar fica ativo
//        jbAlterar.setEnabled(true);
//        jbExcluir.setEnabled(true);
        // tabela ganha foco
        limpaTxts();
        int linha = jTCategoria.getSelectedRow();
        //pegar conteudo da linha no banco de dados e jogar nos jtf
        if (!(jTCategoria.getValueAt(linha, 0) == null)) {
            jTFId.setText(jTCategoria.getValueAt(linha, 0).toString());
        }
        if (!(jTCategoria.getValueAt(linha, 1) == null)) {
            jTFNome.setText(jTCategoria.getValueAt(linha, 1).toString());
        }
    }//GEN-LAST:event_jTCategoriaMouseClicked

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        limpaTxts();
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Usuario usuario = null;
        try {
            usuario = new Usuario(jTFNome.getText(), jTFSenha.getText());
            usuario.setCPF(Long.parseLong(jTFCPF.getText()));
            usuario.setCep(Long.parseLong(jTFCep.getText()));
            usuario.setDataNasc(new Date(Integer.parseInt(jTFDataNascAno.getText()),
                    Integer.parseInt(jTFDataNascMes.getText()),
                    Integer.parseInt(jTFDataNascDia.getText())));
            usuario.setEmail(jTFEmail.getText());
            usuario.setEndereco(jTFEndereco.getText());
            if (jRBFuncS.isSelected()) {
                usuario.setIsFunc(true);
            } else {
                usuario.setIsFunc(false);
            }
            usuario.setTelefone(jTFTelefone.getText());
            usuario.setRG(Long.parseLong(jTFRG.getText()));
            if (jRBSexoM.isSelected()) {
                usuario.setSexo('M');
            } else {
                usuario.setSexo('F');
            }
            try {
                if (categoriaController == null) {
                    categoriaController = new UsuarioController();
                }
                categoriaController.create(usuario);
                atualizarJTCategoria();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao gravar usuario: " + usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro Formulario mal preenchido",
                    "System Mack", 2);
        }

        limpaTxts();
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        try {
            if (categoriaController == null) {
                categoriaController = new UsuarioController();
            }
            Object id = jTCategoria.getValueAt(jTCategoria.getSelectedRow(), 0);
            Usuario u = categoriaController.find(id);
            categoriaController.delete(u);
            atualizarJTCategoria();
            limpaTxts();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar o usuario");
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        Usuario usuario = null;
        try {
            if (categoriaController == null) {
                categoriaController = new UsuarioController();
            }
            Object id = jTCategoria.getValueAt(jTCategoria.getSelectedRow(), 0);
            usuario = categoriaController.find(id);

            usuario.setCPF(Long.parseLong(jTFCPF.getText()));
            usuario.setCep(Long.parseLong(jTFCep.getText()));
            usuario.setDataNasc(new Date(Integer.parseInt(jTFDataNascAno.getText()),
                    Integer.parseInt(jTFDataNascMes.getText()),
                    Integer.parseInt(jTFDataNascDia.getText())));
            usuario.setEmail(jTFEmail.getText());
            usuario.setEndereco(jTFEndereco.getText());
            if (jRBFuncS.isSelected()) {
                usuario.setIsFunc(true);
            } else {
                usuario.setIsFunc(false);
            }
            usuario.setRG(Long.parseLong(jTFRG.getText()));
            usuario.setTelefone(jTFTelefone.getText());
            if (jRBSexoM.isSelected()) {
                usuario.setSexo('M');
            } else {
                usuario.setSexo('F');
            }
            try {
                categoriaController.update(usuario);
                atualizarJTCategoria();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao Alterar o usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro Formulario mal preenchido",
                    "System Mack", 2);
        }
        limpaTxts();
    }//GEN-LAST:event_jBAlterarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCategoria;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
