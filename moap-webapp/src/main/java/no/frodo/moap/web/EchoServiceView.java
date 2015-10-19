package no.frodo.moap.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
public class EchoServiceView {

    public String echoService() throws IOException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Web service called with success", null);
        facesContext.addMessage(null, m);
        return null;
    }
}
