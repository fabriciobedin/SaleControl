/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.face.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabricio
 */
public class Util {
    
    public final String FORMATO_RETORNO_DATAHORA = "dd/MM/yyyy HH:mm";
    
    public final String FORMATO_RETORNO_DATA = "dd/MM/yyyy";
    
    public Timestamp buscarDataHora(){
        return new Timestamp(System.currentTimeMillis());
    }
    
    public String formatarData (Date data, String formatoRetorno){
        SimpleDateFormat formatar = new SimpleDateFormat(formatoRetorno);
        String dataFormatada = formatar.format(data);
        return dataFormatada;
    }
    
    
    public Calendar buscarDataAPartirDataAtual(Integer quantDias){
        //buscando data atual
        Calendar data = Calendar.getInstance();
        data.add(Calendar.DATE, quantDias);
        return data;
    }
    
    /**
     * Identifica o endereço IP remoto
     * @return 
     */
    public String getMeuIP(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return request.getRemoteAddr();
    }
}
