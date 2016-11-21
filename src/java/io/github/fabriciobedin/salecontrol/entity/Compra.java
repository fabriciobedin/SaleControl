/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByCmpCodigo", query = "SELECT c FROM Compra c WHERE c.cmpCodigo = :cmpCodigo"),
    @NamedQuery(name = "Compra.findByCmpValortotal", query = "SELECT c FROM Compra c WHERE c.cmpValortotal = :cmpValortotal"),
    @NamedQuery(name = "Compra.findByCmpDatahora", query = "SELECT c FROM Compra c WHERE c.cmpDatahora = :cmpDatahora")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cmp_codigo")
    private Integer cmpCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cmp_valortotal")
    private BigDecimal cmpValortotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cmp_datahora")
    @Temporal(TemporalType.DATE)
    private Date cmpDatahora;
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
    @ManyToOne(optional = false)
    private Cliente cliCodigo;
    @JoinColumn(name = "cpr_codigo", referencedColumnName = "cpr_codigo")
    @ManyToOne(optional = false)
    private Compraproduto cprCodigo;
    @JoinColumn(name = "usr_codigo", referencedColumnName = "usr_codigo")
    @ManyToOne(optional = false)
    private Usuario usrCodigo;

    public Compra() {
    }

    public Compra(Integer cmpCodigo) {
        this.cmpCodigo = cmpCodigo;
    }

    public Compra(Integer cmpCodigo, BigDecimal cmpValortotal, Date cmpDatahora) {
        this.cmpCodigo = cmpCodigo;
        this.cmpValortotal = cmpValortotal;
        this.cmpDatahora = cmpDatahora;
    }

    public Integer getCmpCodigo() {
        return cmpCodigo;
    }

    public void setCmpCodigo(Integer cmpCodigo) {
        this.cmpCodigo = cmpCodigo;
    }

    public BigDecimal getCmpValortotal() {
        return cmpValortotal;
    }

    public void setCmpValortotal(BigDecimal cmpValortotal) {
        this.cmpValortotal = cmpValortotal;
    }

    public Date getCmpDatahora() {
        return cmpDatahora;
    }

    public void setCmpDatahora(Date cmpDatahora) {
        this.cmpDatahora = cmpDatahora;
    }

    public Cliente getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Cliente cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Compraproduto getCprCodigo() {
        return cprCodigo;
    }

    public void setCprCodigo(Compraproduto cprCodigo) {
        this.cprCodigo = cprCodigo;
    }

    public Usuario getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(Usuario usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmpCodigo != null ? cmpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.cmpCodigo == null && other.cmpCodigo != null) || (this.cmpCodigo != null && !this.cmpCodigo.equals(other.cmpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+cmpCodigo;
    }
    
}
