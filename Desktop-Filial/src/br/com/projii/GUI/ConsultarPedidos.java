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
import br.com.projii.controller.UsuarioController;
import br.com.projii.jpa.Estoque;
import br.com.projii.jpa.Filial;
import br.com.projii.jpa.ItemPedido;
import br.com.projii.jpa.Pedido;
import br.com.projii.jpa.Produto;
import br.com.projii.jpa.Usuario;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dj002
 */
public class ConsultarPedidos extends javax.swing.JPanel {

    private BaseJF parent;
    private ProdutoController produtoController = null;
    private FilialController filialController = null;
    private PedidoController pedidoController = null;
    private ItemPedidoController itemPedidoController = null;
    private EstoqueController estoqueController;
    private static final Font COURIER_NEW = new Font("Courier New",
            Font.PLAIN, 11);

    /**
     * Creates new form EfetuarCompra
     */
    public ConsultarPedidos(BaseJF baseJF) {
        initComponents();
        this.parent = baseJF;
        atualizarJTPedido();
        ajustaTablePreferences();
    }

    private void ajustaTablePreferences() {
//        jTProduto.setSize(1500, 300);
        jTPedido.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTPedido.getColumnModel().getColumn(1).setPreferredWidth(80);

    }

    public void atualizarJTPedido() {
        try {
            if (pedidoController == null) {
                pedidoController = new PedidoController();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }

        List<Pedido> pedidos = pedidoController.findAll();
        ArrayList<Pedido> mPedidos = new ArrayList<Pedido>();

        for (Pedido pedido : pedidos) {
            if (!(pedido.isEntregue())) {
                mPedidos.add(pedido);
            }
        }
        Pedido[] pedidosV = mPedidos.toArray(new Pedido[0]);
        Object[][] objects = new Object[pedidosV.length][3];
        for (int j = 0; j < pedidosV.length; j++) {
            objects[j][0] = pedidosV[j].getId();
            objects[j][1] = pedidosV[j].getIdUsuario();
        }
        jTPedido.setModel(new javax.swing.table.DefaultTableModel(
                objects,
                new String[]{
                    "id Pedido", "id Usuario"
                }));
    }

    public void atualizaJTAPedido(long idPedido) {
        try {
            if (pedidoController == null) {
                pedidoController = new PedidoController();
            }
            if (itemPedidoController == null) {
                itemPedidoController = new ItemPedidoController();
            }
            if (produtoController == null) {
                produtoController = new ProdutoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }

        Pedido pedido = pedidoController.find(idPedido);
        List<ItemPedido> itensPedido = itemPedidoController.findAll();
        String s = pedido.toString();
        double total = 0;
        for (ItemPedido itemPedido : itensPedido) {
            if (itemPedido.getPedido().getId().equals(pedido.getId())) {
                Produto produto = produtoController.find(itemPedido.getIdProduto());
                s = s + "\n" + itemPedido.toString();
//                s = s + "\n" + produto.toString();


                if (produto.getNome().length() < 16) {
                    int i = 16 - produto.getNome().length();
                    s = s + "\n" + produto.getNome();
                    for (int j = 0; j < i; j++) {
                        s = s + ".";
                    }
//                    System.out.format("%10.3f%n", pi);
                    s = s + ".....:" + String.format("%10.3f", produto.getPreco());
                    s = s + ".....:" + String.format("%10.3f", produto.getPreco() * itemPedido.getQtde());
                    total = total + produto.getPreco() * itemPedido.getQtde();
                } else {
                    s = s + "\n" + produto.getNome().substring(0, 15);
//                    s = s + ".....:" + produto.getPreco() * itemPedido.getQtde();
//                    total = total + produto.getPreco() * itemPedido.getQtde();
//                    s = s + ".....:" + produto.getPreco();
                    s = s + ".....:" + String.format("%10.3f", produto.getPreco());
                    s = s + ".....:" + String.format("%10.3f", produto.getPreco() * itemPedido.getQtde());
                    total = total + produto.getPreco() * itemPedido.getQtde();

                }
            }
        }
        s = s + "\nTotal:...............:" + String.format("%10.3f", total);
        jTAPedido.setText(s);
        jTAPedido.setFont(COURIER_NEW);
    }

    private void encaminhaPedido(long id) {
        try {
            if (pedidoController == null) {
                pedidoController = new PedidoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return;
        }
        int resposta;
        //0 = sim //1 = nao
        atualizaJTAPedido(id);

        resposta = (JOptionPane.showConfirmDialog(this, "Deseja atender "
                + "este pedido ?"
                + "",
                "System Mack",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
        Pedido p = pedidoController.find(id);

        if (resposta == 0) {
//            boolean verificaItensDoPedido = verificaItensDoPedido(id);
//            if (verificaItensDoPedido) {
//                boolean atuualizoEstoqueItensDoPedido = atuualizoEstoqueItensDoPedido(id);
//            }
            p.setEntregue(true);
            pedidoController.update(p);
        } else {
            p.setEncaminhado(false);
            pedidoController.update(p);
        }
        atualizarJTPedido();
    }

    public boolean verificaItensDoPedido(long idPedido) {
        try {
            if (pedidoController == null) {
                pedidoController = new PedidoController();
            }
            if (itemPedidoController == null) {
                itemPedidoController = new ItemPedidoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return false;
        }
        Pedido p = pedidoController.find(idPedido);
        List<ItemPedido> itensPedidos = itemPedidoController.findAll();
        boolean verificaItensDoPedido = false;
        for (ItemPedido itemPedido : itensPedidos) {
            long idItem = itemPedido.getId();
            if (idPedido == idItem) {
                verificaItensDoPedido = true;
                if (!(verificaQtdeProd(itemPedido.getIdProduto(), itemPedido.getQtde()))) {
                    //mensagem q nao atende
                    JOptionPane.showMessageDialog(this, "O produto de codigo : "
                            + itemPedido.getId() + " : nao tem estoque suficiente"
                            + "\n O pedido nao pode ser atendido!",
                            "System Mack",
                            JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            }
        }
        return verificaItensDoPedido;
    }

    public boolean atuualizoEstoqueItensDoPedido(long idPedido) {
        try {
            if (pedidoController == null) {
                pedidoController = new PedidoController();
            }
            if (itemPedidoController == null) {
                itemPedidoController = new ItemPedidoController();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor...");
            return false;
        }
        Pedido p = pedidoController.find(idPedido);
        List<ItemPedido> itensPedidos = itemPedidoController.findAll();
        boolean atuualizoEstoqueItensDoPedido = false;
        for (ItemPedido itemPedido : itensPedidos) {
            long idItem = itemPedido.getId();
            if (idPedido == idItem) {
                atuualizoEstoqueItensDoPedido = true;
                atualizaEstoque(itemPedido.getIdProduto(), itemPedido.getQtde());
                //mensagem q nao atende
            }
        }
        return true;
    }

    public boolean verificaQtdeProd(long id, long qtde) {
        boolean isSuficiente = false;
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
            return isSuficiente;
        }

        Produto p = produtoController.find(id);
        List<Estoque> estoques = estoqueController.csPorIdProduto(id);

        long idFilial = 0;

        String nomeFilial = parent.getSFilial();
        List<Filial> filiais = filialController.findAll();
        for (Filial filial : filiais) {
            if (filial.getNome().equals(nomeFilial)) {
                idFilial = filial.getId();
            }
        }

        for (Estoque estoque : estoques) {
            long idF = estoque.getIdFilial();
            if (idFilial == idF) {
                isSuficiente = (qtde <= estoque.getQtde());
                return isSuficiente;
            }
        }
        return isSuficiente;
    }

    public void atualizaEstoque(long idP, long qtde) {
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

        Produto p = produtoController.find(idP);
        List<Estoque> estoques = estoqueController.csPorIdProduto(idP);

        long idFilial = 0;

        String nomeFilial = parent.getSFilial();
        List<Filial> filiais = filialController.findAll();
        for (Filial filial : filiais) {
            if (filial.getNome().equals(nomeFilial)) {
                idFilial = filial.getId();
            }
        }

        for (Estoque estoque : estoques) {
            long idF = estoque.getIdFilial();
            if (idFilial == idF) {
                estoque.setQtde(estoque.getQtde() - qtde);
                estoqueController.update(estoque);
                return;
            }
        }
        return;
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
        jTPedido = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAPedido = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(490, 400));
        setRequestFocusEnabled(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 280));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id do pedido", "id do usuário"
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
        jTPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPedido);

        jLabel8.setText("Pedidos pendentes:");

        jTAPedido.setColumns(20);
        jTAPedido.setRows(5);
        jScrollPane2.setViewportView(jTAPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jTPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPedidoMouseClicked
        // TODO add your handling code here:
        int linha = jTPedido.getSelectedRow();
        long id = 0;
        if (!(jTPedido.getValueAt(linha, 0) == null)) {
            id = Long.parseLong(jTPedido.getValueAt(linha, 0).toString());
        }
        //procura e exibe o produto
        encaminhaPedido(id);

    }//GEN-LAST:event_jTPedidoMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
    }//GEN-LAST:event_jScrollPane1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAPedido;
    private javax.swing.JTable jTPedido;
    // End of variables declaration//GEN-END:variables
}
