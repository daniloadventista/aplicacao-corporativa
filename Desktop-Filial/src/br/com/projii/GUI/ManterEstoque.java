/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.GUI;

import br.com.projii.controller.CategoriaController;
import br.com.projii.controller.EstoqueController;
import br.com.projii.controller.FilialController;
import br.com.projii.controller.ItemPedidoController;
import br.com.projii.controller.PedidoController;
import br.com.projii.controller.ProdutoController;
import br.com.projii.jpa.Estoque;
import br.com.projii.jpa.Filial;
import br.com.projii.jpa.ItemPedido;
import br.com.projii.jpa.Pedido;
import br.com.projii.jpa.Produto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dj002
 */
public class ManterEstoque extends javax.swing.JPanel {

    private BaseJF parent;
    private ProdutoController produtoController = null;
    private EstoqueController estoqueController = null;
    private FilialController filialController = null;
    private PedidoController pedidoController = null;
    private ItemPedidoController itemPedidoController = null;

    /**
     * Creates new form EfetuarCompra
     */
    public ManterEstoque(BaseJF parent) {
        this.parent = parent;
        initComponents();
        atualizarJTProduto();
        atualizarJTEstoque();
        ajustaTablePreferences();
    }

    private void ajustaTablePreferences() {
//        jTProduto.setSize(1500, 300);
        jTProduto.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTProduto.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTProduto.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTEstoque.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTEstoque.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTEstoque.getColumnModel().getColumn(3).setPreferredWidth(40);

    }

    public void atualizarJTProduto() {
        try {
            if (produtoController == null) {
                produtoController = new ProdutoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        Produto[] produtos = produtoController.findAll().toArray(new Produto[0]);
        Object[][] objects = new Object[produtos.length][3];
        for (int i = 0; i < produtos.length; i++) {
            objects[i][0] = produtos[i].getId();
            objects[i][1] = produtos[i].getNome();
            objects[i][2] = produtos[i].getPreco();
        }
        jTProduto.setModel(new javax.swing.table.DefaultTableModel(
                objects,
                new String[]{
                    "id", "Nome", "Preço"
                }));
    }

    public void atualizarJTEstoque() {
        try {
            if (estoqueController == null) {
                estoqueController = new EstoqueController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        Estoque[] estoques = estoqueController.findAll().toArray(new Estoque[0]);
        Object[][] objects = new Object[estoques.length][4];
        for (int i = 0; i < estoques.length; i++) {
            objects[i][0] = estoques[i].getId();
            objects[i][1] = estoques[i].getIdFilial();
            objects[i][2] = estoques[i].getIdProduto();
            objects[i][3] = estoques[i].getQtde();
        }
        jTEstoque.setModel(new javax.swing.table.DefaultTableModel(
                objects,
                new String[]{
                    "id", "Filial", "Produto", "Qtde"
                }));
    }

    public void insereNoJTEstoque(long idP) {
        try {
            if (produtoController == null) {
                produtoController = new ProdutoController();
            }
            if (estoqueController == null) {
                estoqueController = new EstoqueController();
            }
            if (filialController == null) {
                filialController = new FilialController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        int resposta;
        boolean nessaFialial = false;
        Produto p = produtoController.find(idP);

        //logica verifica fillial
        long idFilial = 0;

        String nomeFilial = parent.getSFilial();
        List<Filial> filiais = filialController.findAll();
        for (Filial filial : filiais) {
            if (filial.getNome().equals(nomeFilial)) {
                idFilial = filial.getId();
            }
        }


        List<Estoque> estoques = estoqueController.csPorIdProduto(idP);
        for (Estoque estoque : estoques) {
            Filial filial = filialController.find(estoque.getIdFilial());
            if (!(filial == null)) {
                if (filial.getNome().equals(nomeFilial)) {
                    nessaFialial = true;
                    break;
                } else {
                    nessaFialial = false;
                }
            }
        }

        if (estoques.size() > 0 && nessaFialial) {
            JOptionPane.showMessageDialog(this, "Produto ja inserido no estoque",
                    "System Mack", JOptionPane.QUESTION_MESSAGE);
        } else {
            Estoque estoque = new Estoque(idP);
            estoque.setIdFilial(idFilial);//TODO mudar
            JOptionPane.showMessageDialog(this, p.toString());
            //0 = sim //1 = nao
            resposta = (JOptionPane.showConfirmDialog(this, "Deseja inserir "
                    + "este produto ao estoque", "System Mack",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
            if (resposta == 0) {
                String s;
                int qtde = 0;
                do {
                    s = JOptionPane.showInputDialog(this, "Quantidade ? ", "System Mack",
                            JOptionPane.QUESTION_MESSAGE);
                    try {
                        qtde = Integer.parseInt(s);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Quantidade Invalida");
                    }
                } while (qtde <= 0);
                estoque.setQtde((long) qtde);
                estoqueController.create(estoque);
                atualizarJTEstoque();
            }
        }

    }

    public void alteraEstoque(long id) {
        try {
            if (estoqueController == null) {
                estoqueController = new EstoqueController();
            }
            if (filialController == null) {
                filialController = new FilialController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }

        //logica verifica fillial
        long idFilial = 0;

        String nomeFilial = parent.getSFilial();
        List<Filial> filiais = filialController.findAll();
        for (Filial filial : filiais) {
            if (filial.getNome().equals(nomeFilial)) {
                idFilial = filial.getId();
            }
        }

        Estoque estoque = estoqueController.find(id);
        long idFilialEst = estoque.getIdFilial();
        if (idFilialEst == idFilial) {
            String s;
            int qtde = 0;
            do {
                s = JOptionPane.showInputDialog(this, "Nova Quantidade ? ",
                        "System Mack", JOptionPane.QUESTION_MESSAGE);
                try {
                    qtde = Integer.parseInt(s);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Quantidade Invalida");
                }
            } while (qtde <= 0);
            estoque.setQtde((long) qtde);
            estoqueController.update(estoque);
            atualizarJTEstoque();
        } else {
            JOptionPane.showMessageDialog(this, "Estoque de outra loja",
                    "System Mack", JOptionPane.QUESTION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTProduto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jBProcProdId = new javax.swing.JButton();
        jBProcProdNome = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTEstoque = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(490, 400));
        setRequestFocusEnabled(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 280));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProduto);

        jLabel7.setText("id");

        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });

        jLabel8.setText("Procurar por:");

        jLabel9.setText("nome");

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });

        jBProcProdId.setText("Procurar");
        jBProcProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcProdIdActionPerformed(evt);
            }
        });

        jBProcProdNome.setText("Procurar");
        jBProcProdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcProdNomeActionPerformed(evt);
            }
        });

        jScrollPane3.setPreferredSize(new java.awt.Dimension(1000, 280));

        jTEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Filial", "Produto", "QTDE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEstoqueMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTEstoque);

        jLabel10.setText("Estoque de Compras:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBProcProdId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBProcProdNome, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBProcProdId)
                        .addGap(9, 9, 9)
                        .addComponent(jBProcProdNome))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jTProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutoMouseClicked
        // TODO add your handling code here:
        int linha = jTProduto.getSelectedRow();
        long id = 0;
        if (!(jTProduto.getValueAt(linha, 0) == null)) {
            id = Long.parseLong(jTProduto.getValueAt(linha, 0).toString());
        }
        //procura e exibe o produto
        insereNoJTEstoque(id);
    }//GEN-LAST:event_jTProdutoMouseClicked

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdActionPerformed

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    private void jTEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEstoqueMouseClicked
        // TODO add your handling code here:
        int linha = jTEstoque.getSelectedRow();
        long id = 0;
        if (!(jTEstoque.getValueAt(linha, 0) == null)) {
            id = Long.parseLong(jTEstoque.getValueAt(linha, 0).toString());
        }
        alteraEstoque(id);
    }//GEN-LAST:event_jTEstoqueMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jBProcProdIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcProdIdActionPerformed
        try {
            if (produtoController == null) {
                produtoController = new ProdutoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        Produto produto;
        try {
            long idP = Long.parseLong(jTFId.getText());
            produto = produtoController.find(idP);
            insereNoJTEstoque(idP);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Produtos nao encontrado", "System Mack",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBProcProdIdActionPerformed

    private void jBProcProdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcProdNomeActionPerformed
        try {
            if (produtoController == null) {
                produtoController = new ProdutoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        List<Produto> produtos;
        try {
            long idP = 0;
            String nome = jTFNome.getText();
            produtos = produtoController.findAll();
            for (Produto produto : produtos) {
                if (produto.getNome().equals(nome)) {
                    idP = produto.getId();
                }
            }
            if (idP != 0) {
                insereNoJTEstoque(idP);
            } else {
                JOptionPane.showMessageDialog(this, "Produto nao encontrado", "System Mack",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Produto nao encontrado", "System Mack",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBProcProdNomeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBProcProdId;
    private javax.swing.JButton jBProcProdNome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTEstoque;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTable jTProduto;
    // End of variables declaration//GEN-END:variables
}
