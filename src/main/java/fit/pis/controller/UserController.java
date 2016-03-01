package fit.pis.controller;

import fit.pis.domain.entity.User;
import fit.pis.domain.mediator.UserDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "users")
@ViewScoped
public class UserController {

    private User current;

    private static int i = 0;

    @EJB
    private UserDao dao;

    public List<User> getAll() {
        return dao.findAll();
    }

    public User getCurrent() {
        if (current == null) {
            current = getTemplate();
            i++;
        }
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public User getTemplate() {
        User user = new User();
        user.setUsername("new");
        return user;
    }

}
