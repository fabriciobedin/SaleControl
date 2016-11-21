/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.face.util;

import io.github.fabriciobedin.salecontrol.entity.Usuario;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabricio
 */
public class UtilSession {
    
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    
    /**
     * Método que retorna o código do usuario logado
     * @return 
     */
    public Integer getUsuarioCodigoLogado(){
        return (Integer) session.getAttribute("logado");
    }
    
    /**
     * Método que monta um objeto usuario e insere o código do usuario logado
     * @return 
     */
    public Usuario getUsuarioLogado(){
        Usuario user = new Usuario();
        user.setUsrCodigo(getUsuarioCodigoLogado());
        return user;    
    }
    
    
}
