/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.bean;

import io.github.fabriciobedin.salecontrol.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabricio
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SaleControlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findUsuarioByLogin(String login){
        Usuario usuario = null;
        try {
            Query query = getEntityManager().createNamedQuery("Usuario.findByUsrLogin");
            query.setParameter("usrLogin", login);
            //define a quantidade de resultados e registros como 1
            query.setMaxResults(1);
            
            if(!query.getResultList().isEmpty()){
                usuario = (Usuario) query.getSingleResult();
                
            }else{
                System.out.println("Nenhum resultado localizado para findByUserLogin");}
                    
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
        return usuario;
    }
    
}
