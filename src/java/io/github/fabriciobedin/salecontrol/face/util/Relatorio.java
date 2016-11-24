/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.face.util;

import io.github.fabriciobedin.salecontrol.face.util.ConnFactory;
import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Jeangrei
 */
public class Relatorio {

    private ConnFactory con = new ConnFactory();

    //executa o relatorio através de uma Connection
    public void executarRelatorio(String caminhoRelatorio, Map<String, Object> parametros) {
        con.conectar();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        //pega o caminho do arquivo .jasper da aplicação
        InputStream reportStream = context.getExternalContext().getResourceAsStream(caminhoRelatorio);

        //envia a resposta com o MIME Type
        //   if (tipoFormatoRelatorio.equals(TipoFormatoRelatorio.ACROBAT_PDF)) {
        response.setContentType("application/pdf");
        //    } else if (tipoFormatoRelatorio.equals(TipoFormatoRelatorio.PAGINA_HTML)) {
        //        response.setContentType("application/html");
        //    }
        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();

            //envia parametros para o relatorio
            if (parametros == null) {
                parametros = new HashMap<String, Object>();
            }

            //envia para o navegador o PDF gerado
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parametros, con.getCon());
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (JRException e) {
            e.printStackTrace();
            con.fechar();
        } catch (IOException e) {
            e.printStackTrace();
            con.fechar();
        } finally {
            context.responseComplete();
            con.fechar();
        }
    }

}
