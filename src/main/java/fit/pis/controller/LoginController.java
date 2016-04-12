package fit.pis.controller;

import fit.pis.domain.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController {

    public User.UserRole getRole() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (externalContext.isUserInRole("ADMIN")) return User.UserRole.ADMIN;
        if (externalContext.isUserInRole("MANAGER")) return User.UserRole.MANAGER;
        if (externalContext.isUserInRole("PHARMACIST")) return User.UserRole.PHARMACIST;
        return null;
    }

    public String getUsername() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }

    public void logout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath());
    }

}
