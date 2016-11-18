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
@Table(name = "uf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u"),
    @NamedQuery(name = "Uf.findByUfCodigo", query = "SELECT u FROM Uf u WHERE u.ufCodigo = :ufCodigo"),
    @NamedQuery(name = "Uf.findByUfDescricao", query = "SELECT u FROM Uf u WHERE u.ufDescricao = :ufDescricao"),
    @NamedQuery(name = "Uf.findByUfSigla", query = "SELECT u FROM Uf u WHERE u.ufSigla = :ufSigla")})
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uf_codigo")
    private Integer ufCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uf_descricao")
    private String ufDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "uf_sigla")
    private String ufSigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ufCodigo")
    private Collection<Cidade> cidadeCollection;

    public Uf() {
    }

    public Uf(Integer ufCodigo) {
        this.ufCodigo = ufCodigo;
    }

    public Uf(Integer ufCodigo, String ufDescricao, String ufSigla) {
        this.ufCodigo = ufCodigo;
        this.ufDescricao = ufDescricao;
        this.ufSigla = ufSigla;
    }

    public Integer getUfCodigo() {
        return ufCodigo;
    }

    public void setUfCodigo(Integer ufCodigo) {
        this.ufCodigo = ufCodigo;
    }

    public String getUfDescricao() {
        return ufDescricao;
    }

    public void setUfDescricao(String ufDescricao) {
        this.ufDescricao = ufDescricao;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    @XmlTransient
    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ufCodigo != null ? ufCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.ufCodigo == null && other.ufCodigo != null) || (this.ufCodigo != null && !this.ufCodigo.equals(other.ufCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.fabriciobedin.salecontrol.entity.Uf[ ufCodigo=" + ufCodigo + " ]";
    }
    
}
