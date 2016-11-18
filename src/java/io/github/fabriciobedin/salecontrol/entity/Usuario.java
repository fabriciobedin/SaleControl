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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsrCodigo", query = "SELECT u FROM Usuario u WHERE u.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "Usuario.findByUsrNome", query = "SELECT u FROM Usuario u WHERE u.usrNome = :usrNome"),
    @NamedQuery(name = "Usuario.findByUsrLogin", query = "SELECT u FROM Usuario u WHERE u.usrLogin = :usrLogin"),
    @NamedQuery(name = "Usuario.findByUsrSenha", query = "SELECT u FROM Usuario u WHERE u.usrSenha = :usrSenha"),
    @NamedQuery(name = "Usuario.findByUsrTelefone", query = "SELECT u FROM Usuario u WHERE u.usrTelefone = :usrTelefone"),
    @NamedQuery(name = "Usuario.findByUsrEmail", query = "SELECT u FROM Usuario u WHERE u.usrEmail = :usrEmail"),
    @NamedQuery(name = "Usuario.findByUsrAdm", query = "SELECT u FROM Usuario u WHERE u.usrAdm = :usrAdm")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private Integer usrCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usr_nome")
    private String usrNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_login")
    private String usrLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_senha")
    private String usrSenha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_telefone")
    private String usrTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_email")
    private String usrEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_adm")
    private boolean usrAdm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrCodigo")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "cid_codigo", referencedColumnName = "cid_codigo")
    @ManyToOne(optional = false)
    private Cidade cidCodigo;

    public Usuario() {
    }

    public Usuario(Integer usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Usuario(Integer usrCodigo, String usrNome, String usrLogin, String usrSenha, String usrTelefone, String usrEmail, boolean usrAdm) {
        this.usrCodigo = usrCodigo;
        this.usrNome = usrNome;
        this.usrLogin = usrLogin;
        this.usrSenha = usrSenha;
        this.usrTelefone = usrTelefone;
        this.usrEmail = usrEmail;
        this.usrAdm = usrAdm;
    }

    public Integer getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(Integer usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrNome() {
        return usrNome;
    }

    public void setUsrNome(String usrNome) {
        this.usrNome = usrNome;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public String getUsrSenha() {
        return usrSenha;
    }

    public void setUsrSenha(String usrSenha) {
        this.usrSenha = usrSenha;
    }

    public String getUsrTelefone() {
        return usrTelefone;
    }

    public void setUsrTelefone(String usrTelefone) {
        this.usrTelefone = usrTelefone;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public boolean getUsrAdm() {
        return usrAdm;
    }

    public void setUsrAdm(boolean usrAdm) {
        this.usrAdm = usrAdm;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
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
        hash += (usrCodigo != null ? usrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrCodigo == null && other.usrCodigo != null) || (this.usrCodigo != null && !this.usrCodigo.equals(other.usrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.fabriciobedin.salecontrol.entity.Usuario[ usrCodigo=" + usrCodigo + " ]";
    }
    
}
