/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 41080130 danilo lima
 */
@Entity
public class ItemPedido implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idProduto;
    private Long qtde;
    @ManyToOne
    private Pedido pedido;

    public ItemPedido(Long idProduto, Pedido pedido) {
        this.idProduto = idProduto;
        this.pedido = pedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getQtde() {
        return qtde;
    }

    public void setQtde(Long qtde) {
        this.qtde = qtde;
    }

    
    public Pedido getPedido() {
        return pedido;
    }

    protected ItemPedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "id=" + id + ", idProduto=" + idProduto + ", qtde=" + qtde + ", pedido=" + 
                pedido.getId() + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
