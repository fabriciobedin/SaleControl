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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPrdCodigo", query = "SELECT p FROM Produto p WHERE p.prdCodigo = :prdCodigo"),
    @NamedQuery(name = "Produto.findByPrdDescricao", query = "SELECT p FROM Produto p WHERE p.prdDescricao = :prdDescricao"),
    @NamedQuery(name = "Produto.findByPrdTamanho", query = "SELECT p FROM Produto p WHERE p.prdTamanho = :prdTamanho"),
    @NamedQuery(name = "Produto.findByPrdValorUnitario", query = "SELECT p FROM Produto p WHERE p.prdValorUnitario = :prdValorUnitario"),
    @NamedQuery(name = "Produto.findByPrdQuantidadeEstoque", query = "SELECT p FROM Produto p WHERE p.prdQuantidadeEstoque = :prdQuantidadeEstoque"),
    @NamedQuery(name = "Produto.findByPrdAtivo", query = "SELECT p FROM Produto p WHERE p.prdAtivo = :prdAtivo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prd_codigo")
    private Integer prdCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prd_descricao")
    private String prdDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prd_tamanho")
    private String prdTamanho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_valor_unitario")
    private BigDecimal prdValorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_quantidade_estoque")
    private int prdQuantidadeEstoque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_ativo")
    private boolean prdAtivo;
    @JoinColumn(name = "frn_codigo", referencedColumnName = "frn_codigo")
    @ManyToOne(optional = false)
    private Fornecedor frnCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdCodigo")
    private Collection<Compraproduto> compraprodutoCollection;

    public Produto() {
    }

    public Produto(Integer prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public Produto(Integer prdCodigo, String prdDescricao, String prdTamanho, BigDecimal prdValorUnitario, int prdQuantidadeEstoque, boolean prdAtivo) {
        this.prdCodigo = prdCodigo;
        this.prdDescricao = prdDescricao;
        this.prdTamanho = prdTamanho;
        this.prdValorUnitario = prdValorUnitario;
        this.prdQuantidadeEstoque = prdQuantidadeEstoque;
        this.prdAtivo = prdAtivo;
    }

    public Integer getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(Integer prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public String getPrdDescricao() {
        return prdDescricao;
    }

    public void setPrdDescricao(String prdDescricao) {
        this.prdDescricao = prdDescricao;
    }

    public String getPrdTamanho() {
        return prdTamanho;
    }

    public void setPrdTamanho(String prdTamanho) {
        this.prdTamanho = prdTamanho;
    }

    public BigDecimal getPrdValorUnitario() {
        return prdValorUnitario;
    }

    public void setPrdValorUnitario(BigDecimal prdValorUnitario) {
        this.prdValorUnitario = prdValorUnitario;
    }

    public int getPrdQuantidadeEstoque() {
        return prdQuantidadeEstoque;
    }

    public void setPrdQuantidadeEstoque(int prdQuantidadeEstoque) {
        this.prdQuantidadeEstoque = prdQuantidadeEstoque;
    }

    public boolean getPrdAtivo() {
        return prdAtivo;
    }

    public void setPrdAtivo(boolean prdAtivo) {
        this.prdAtivo = prdAtivo;
    }

    public Fornecedor getFrnCodigo() {
        return frnCodigo;
    }

    public void setFrnCodigo(Fornecedor frnCodigo) {
        this.frnCodigo = frnCodigo;
    }

    @XmlTransient
    public Collection<Compraproduto> getCompraprodutoCollection() {
        return compraprodutoCollection;
    }

    public void setCompraprodutoCollection(Collection<Compraproduto> compraprodutoCollection) {
        this.compraprodutoCollection = compraprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdCodigo != null ? prdCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.prdCodigo == null && other.prdCodigo != null) || (this.prdCodigo != null && !this.prdCodigo.equals(other.prdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.fabriciobedin.salecontrol.entity.Produto[ prdCodigo=" + prdCodigo + " ]";
    }
    
}
