/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.bean;

import io.github.fabriciobedin.salecontrol.entity.Uf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabricio
 */
@Stateless
public class UfFacade extends AbstractFacade<Uf> {

    @PersistenceContext(unitName = "SaleControlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UfFacade() {
        super(Uf.class);
    }
    
}
