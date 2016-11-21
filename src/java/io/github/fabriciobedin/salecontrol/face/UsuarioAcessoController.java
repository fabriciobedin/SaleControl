package io.github.fabriciobedin.salecontrol.face;

import io.github.fabriciobedin.salecontrol.bean.UsuarioFacade;
import io.github.fabriciobedin.salecontrol.entity.Usuario;
import io.github.fabriciobedin.salecontrol.face.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

@Named("usuarioAcessoController")
@SessionScoped
public class UsuarioAcessoController implements Serializable {

    @EJB
    private UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

    public UsuarioAcessoController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }


    public Usuario getUsuario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
        
    
    /**
     * Método utilizado para inicializar métodos ao instanciar a classe
     */
    @PostConstruct
    public void init(){
        prepareAutenticarUsuario();
    }
    
        
    /**
     * preparando para autenticação
     */
    public void prepareAutenticarUsuario(){
        selected = new Usuario();
        initializeEmbeddableKey();
    
    }
        
    
    
    public String autenticarUsuario(){
        //busca o usuario na base de dados
        Usuario usuario = ejbFacade.findUsuarioByLogin(selected.getUsrLogin());
        
        //se encontrou usuario
        if(usuario != null){
            //se a senha existe
            if(usuario.getUsrSenha() != null){
                //se a senha informada é a mesma cadastrada
                if(usuario.getUsrSenha().equals(selected.getUsrSenha())){
                    //setando o atributo "logado" na sessao, com o codigo do usuario
                    session.setAttribute("logado", usuario.getUsrCodigo());
                    return "/admin/produto/List.xhtml";
                }else{
                    JsfUtil.addErrorMessage("Usuário ou senha incorretos!");
                    //não muda de pagina
                    return null;
                }
                
            } else{
                JsfUtil.addErrorMessage(usuario.getUsrLogin()+" : Senha não cadastrada!");
                return null;
            }
        }else{
            JsfUtil.addErrorMessage("Usuário não cadastrado!");
            return null;
        }
    }
    
    
    public String logout(){
        session.invalidate();
        return "/login";
    }
    
    
    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioAcessoController controller = (UsuarioAcessoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioAcessoController");
            return controller.getUsuario(getKey(value));
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
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getUsrCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

}
