package io.github.fabriciobedin.salecontrol.face;

import io.github.fabriciobedin.salecontrol.entity.Cidade;
import io.github.fabriciobedin.salecontrol.face.util.JsfUtil;
import io.github.fabriciobedin.salecontrol.face.util.JsfUtil.PersistAction;
import io.github.fabriciobedin.salecontrol.bean.CidadeFacade;
import io.github.fabriciobedin.salecontrol.face.util.Relatorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cidadeController")
@SessionScoped
public class CidadeController implements Serializable {

    @EJB
    private io.github.fabriciobedin.salecontrol.bean.CidadeFacade ejbFacade;
    private List<Cidade> items = null;
    private Cidade selected;

    public CidadeController() {
    }

    public Cidade getSelected() {
        return selected;
    }

    public void setSelected(Cidade selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CidadeFacade getFacade() {
        return ejbFacade;
    }

    public Cidade prepareCreate() {
        selected = new Cidade();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CidadeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CidadeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CidadeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cidade> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Cidade getCidade(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Cidade> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cidade> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Cidade.class)
    public static class CidadeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CidadeController controller = (CidadeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cidadeController");
            return controller.getCidade(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cidade) {
                Cidade o = (Cidade) object;
                return getStringKey(o.getCidCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cidade.class.getName()});
                return null;
            }
        }

    }
    
    public void executarRelatorioCidadeAll(){
        Relatorio relatorio = new Relatorio();
        //definindo o caminho do relatorio a ser executado
        String caminhoRelatorio = "/admin/relatorio/rel_cidade_all.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        //parametros.put("NomeDoParamentroNoRelatorio", "valorDoParametro");
        
        //chamar a execução do relatório
        relatorio.executarRelatorio(caminhoRelatorio, parametros);
        
    }

}
