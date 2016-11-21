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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliCodigo", query = "SELECT c FROM Cliente c WHERE c.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "Cliente.findByCliNome", query = "SELECT c FROM Cliente c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "Cliente.findByCliCpf", query = "SELECT c FROM Cliente c WHERE c.cliCpf = :cliCpf"),
    @NamedQuery(name = "Cliente.findByCliTelefone", query = "SELECT c FROM Cliente c WHERE c.cliTelefone = :cliTelefone"),
    @NamedQuery(name = "Cliente.findByCliEmail", query = "SELECT c FROM Cliente c WHERE c.cliEmail = :cliEmail"),
    @NamedQuery(name = "Cliente.findByCliEndereco", query = "SELECT c FROM Cliente c WHERE c.cliEndereco = :cliEndereco"),
    @NamedQuery(name = "Cliente.findByCliBloqueado", query = "SELECT c FROM Cliente c WHERE c.cliBloqueado = :cliBloqueado")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cli_nome")
    private String cliNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cli_cpf")
    private String cliCpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cli_telefone")
    private String cliTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cli_email")
    private String cliEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cli_endereco")
    private String cliEndereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_bloqueado")
    private boolean cliBloqueado;
    @JoinColumn(name = "cid_codigo", referencedColumnName = "cid_codigo")
    @ManyToOne(optional = false)
    private Cidade cidCodigo;
    @OneToMany(mappedBy = "cliCodigo")
    private Collection<Compra> compraCollection;

    public Cliente() {
    }

    public Cliente(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Cliente(Integer cliCodigo, String cliNome, String cliCpf, String cliTelefone, String cliEmail, String cliEndereco, boolean cliBloqueado) {
        this.cliCodigo = cliCodigo;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliTelefone = cliTelefone;
        this.cliEmail = cliEmail;
        this.cliEndereco = cliEndereco;
        this.cliBloqueado = cliBloqueado;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    public boolean getCliBloqueado() {
        return cliBloqueado;
    }

    public void setCliBloqueado(boolean cliBloqueado) {
        this.cliBloqueado = cliBloqueado;
    }

    public Cidade getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Cidade cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cliNome + " - " + cliCpf;
    }
    
}
