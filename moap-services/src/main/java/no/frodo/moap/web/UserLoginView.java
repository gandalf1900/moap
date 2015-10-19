package no.frodo.moap.web;

import no.frodo.moap.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Bean holding user login/logout information
 */

@Named
@SessionScoped
public class UserLoginView implements Serializable {

    private String userName;
    private String password;
    private boolean loggedIn;

    @Inject
    UserService userService;

    //validate login
    public String validateUsernamePassword() throws IOException {
        boolean valid = userService.validate(userName, password);
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (valid) {
            ExternalContext ec = facesContext.getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(true);

            session.setAttribute("username", userName);

            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "User logged in correctly", null);
            facesContext.addMessage(null, m);
            loggedIn=true;
            return "admin";
        } else {

            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect Username and Password", null);
            facesContext.addMessage(null, m);
            return "login";
        }
    }

    public String logout() throws ServletException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ec = facesContext.getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(true);
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        request.logout();
        session.invalidate();
        return "logoutSuccess";
    }

    public String getUserName() {
        return userName; }
    public void setUserName(String newValue) {
        userName = newValue; }
    public String getPassword() {
        return password; }
    public void setPassword(String newValue) {
        password = newValue; }
    public boolean getLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


}
