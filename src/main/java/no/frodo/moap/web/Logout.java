package no.frodo.moap.web;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
public class Logout {

    @Inject
    private FacesContext facesContext;

    public Logout() {}

    public String logout() throws ServletException {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        request.logout();
        return "logoutSuccess";
    }



}
