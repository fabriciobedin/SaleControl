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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByFrnCodigo", query = "SELECT f FROM Fornecedor f WHERE f.frnCodigo = :frnCodigo"),
    @NamedQuery(name = "Fornecedor.findByFrnNome", query = "SELECT f FROM Fornecedor f WHERE f.frnNome = :frnNome"),
    @NamedQuery(name = "Fornecedor.findByFrnCategoria", query = "SELECT f FROM Fornecedor f WHERE f.frnCategoria = :frnCategoria"),
    @NamedQuery(name = "Fornecedor.findByFrnRazaoSocial", query = "SELECT f FROM Fornecedor f WHERE f.frnRazaoSocial = :frnRazaoSocial"),
    @NamedQuery(name = "Fornecedor.findByFrnCnpj", query = "SELECT f FROM Fornecedor f WHERE f.frnCnpj = :frnCnpj"),
    @NamedQuery(name = "Fornecedor.findByFrnTelefone", query = "SELECT f FROM Fornecedor f WHERE f.frnTelefone = :frnTelefone"),
    @NamedQuery(name = "Fornecedor.findByFrnEmail", query = "SELECT f FROM Fornecedor f WHERE f.frnEmail = :frnEmail"),
    @NamedQuery(name = "Fornecedor.findByFrnSite", query = "SELECT f FROM Fornecedor f WHERE f.frnSite = :frnSite"),
    @NamedQuery(name = "Fornecedor.findByFrnEndereco", query = "SELECT f FROM Fornecedor f WHERE f.frnEndereco = :frnEndereco"),
    @NamedQuery(name = "Fornecedor.findByFrnBloqueado", query = "SELECT f FROM Fornecedor f WHERE f.frnBloqueado = :frnBloqueado")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "frn_codigo")
    private Integer frnCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "frn_nome")
    private String frnNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_categoria")
    private String frnCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_razao_social")
    private String frnRazaoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_cnpj")
    private String frnCnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_telefone")
    private String frnTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_email")
    private String frnEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_site")
    private String frnSite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "frn_endereco")
    private String frnEndereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frn_bloqueado")
    private boolean frnBloqueado;
    @OneToMany(mappedBy = "frnCodigo")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "cid_codigo", referencedColumnName = "cid_codigo")
    @ManyToOne(optional = false)
    private Cidade cidCodigo;

    public Fornecedor() {
    }

    public Fornecedor(Integer frnCodigo) {
        this.frnCodigo = frnCodigo;
    }

    public Fornecedor(Integer frnCodigo, String frnNome, String frnCategoria, String frnRazaoSocial, String frnCnpj, String frnTelefone, String frnEmail, String frnSite, String frnEndereco, boolean frnBloqueado) {
        this.frnCodigo = frnCodigo;
        this.frnNome = frnNome;
        this.frnCategoria = frnCategoria;
        this.frnRazaoSocial = frnRazaoSocial;
        this.frnCnpj = frnCnpj;
        this.frnTelefone = frnTelefone;
        this.frnEmail = frnEmail;
        this.frnSite = frnSite;
        this.frnEndereco = frnEndereco;
        this.frnBloqueado = frnBloqueado;
    }

    public Integer getFrnCodigo() {
        return frnCodigo;
    }

    public void setFrnCodigo(Integer frnCodigo) {
        this.frnCodigo = frnCodigo;
    }

    public String getFrnNome() {
        return frnNome;
    }

    public void setFrnNome(String frnNome) {
        this.frnNome = frnNome;
    }

    public String getFrnCategoria() {
        return frnCategoria;
    }

    public void setFrnCategoria(String frnCategoria) {
        this.frnCategoria = frnCategoria;
    }

    public String getFrnRazaoSocial() {
        return frnRazaoSocial;
    }

    public void setFrnRazaoSocial(String frnRazaoSocial) {
        this.frnRazaoSocial = frnRazaoSocial;
    }

    public String getFrnCnpj() {
        return frnCnpj;
    }

    public void setFrnCnpj(String frnCnpj) {
        this.frnCnpj = frnCnpj;
    }

    public String getFrnTelefone() {
        return frnTelefone;
    }

    public void setFrnTelefone(String frnTelefone) {
        this.frnTelefone = frnTelefone;
    }

    public String getFrnEmail() {
        return frnEmail;
    }

    public void setFrnEmail(String frnEmail) {
        this.frnEmail = frnEmail;
    }

    public String getFrnSite() {
        return frnSite;
    }

    public void setFrnSite(String frnSite) {
        this.frnSite = frnSite;
    }

    public String getFrnEndereco() {
        return frnEndereco;
    }

    public void setFrnEndereco(String frnEndereco) {
        this.frnEndereco = frnEndereco;
    }

    public boolean getFrnBloqueado() {
        return frnBloqueado;
    }

    public void setFrnBloqueado(boolean frnBloqueado) {
        this.frnBloqueado = frnBloqueado;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public Cidade getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Cidade cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frnCodigo != null ? frnCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.frnCodigo == null && other.frnCodigo != null) || (this.frnCodigo != null && !this.frnCodigo.equals(other.frnCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return frnNome + " - " + frnRazaoSocial;
    }
    
}
