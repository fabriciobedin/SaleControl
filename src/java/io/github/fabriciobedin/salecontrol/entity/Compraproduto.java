/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "compraproduto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compraproduto.findAll", query = "SELECT c FROM Compraproduto c"),
    @NamedQuery(name = "Compraproduto.findByCprCodigo", query = "SELECT c FROM Compraproduto c WHERE c.cprCodigo = :cprCodigo"),
    @NamedQuery(name = "Compraproduto.findByCprValorunitario", query = "SELECT c FROM Compraproduto c WHERE c.cprValorunitario = :cprValorunitario"),
    @NamedQuery(name = "Compraproduto.findByCprQuantidade", query = "SELECT c FROM Compraproduto c WHERE c.cprQuantidade = :cprQuantidade")})
public class Compraproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cpr_codigo")
    private Integer cprCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cpr_valorunitario")
    private BigDecimal cprValorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpr_quantidade")
    private int cprQuantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cprCodigo")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "prd_codigo", referencedColumnName = "prd_codigo")
    @ManyToOne(optional = false)
    private Produto prdCodigo;

    public Compraproduto() {
    }

    public Compraproduto(Integer cprCodigo) {
        this.cprCodigo = cprCodigo;
    }

    public Compraproduto(Integer cprCodigo, int cprQuantidade) {
        this.cprCodigo = cprCodigo;
        this.cprQuantidade = cprQuantidade;
    }

    public Integer getCprCodigo() {
        return cprCodigo;
    }

    public void setCprCodigo(Integer cprCodigo) {
        this.cprCodigo = cprCodigo;
    }

    public BigDecimal getCprValorunitario() {
        return cprValorunitario;
    }

    public void setCprValorunitario(BigDecimal cprValorunitario) {
        this.cprValorunitario = cprValorunitario;
    }

    public int getCprQuantidade() {
        return cprQuantidade;
    }

    public void setCprQuantidade(int cprQuantidade) {
        this.cprQuantidade = cprQuantidade;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Produto getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(Produto prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprCodigo != null ? cprCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compraproduto)) {
            return false;
        }
        Compraproduto other = (Compraproduto) object;
        if ((this.cprCodigo == null && other.cprCodigo != null) || (this.cprCodigo != null && !this.cprCodigo.equals(other.cprCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+cprCodigo;
    }
    
}
