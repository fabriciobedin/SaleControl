/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.entity;

import java.io.Serializable;
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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCidCodigo", query = "SELECT c FROM Cidade c WHERE c.cidCodigo = :cidCodigo"),
    @NamedQuery(name = "Cidade.findByCidDescricao", query = "SELECT c FROM Cidade c WHERE c.cidDescricao = :cidDescricao")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid_codigo")
    private Integer cidCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cid_descricao")
    private String cidDescricao;
    @OneToMany(mappedBy = "cidCodigo")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "uf_codigo", referencedColumnName = "uf_codigo")
    @ManyToOne(optional = false)
    private Uf ufCodigo;
    @OneToMany(mappedBy = "cidCodigo")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "cidCodigo")
    private Collection<Fornecedor> fornecedorCollection;

    public Cidade() {
    }

    public Cidade(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public Cidade(Integer cidCodigo, String cidDescricao) {
        this.cidCodigo = cidCodigo;
        this.cidDescricao = cidDescricao;
    }

    public Integer getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getCidDescricao() {
        return cidDescricao;
    }

    public void setCidDescricao(String cidDescricao) {
        this.cidDescricao = cidDescricao;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Uf getUfCodigo() {
        return ufCodigo;
    }

    public void setUfCodigo(Uf ufCodigo) {
        this.ufCodigo = ufCodigo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidCodigo != null ? cidCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidCodigo == null && other.cidCodigo != null) || (this.cidCodigo != null && !this.cidCodigo.equals(other.cidCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cidDescricao;
    }
    
}
