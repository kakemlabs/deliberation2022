/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.User;
import com.essa.deliberation.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cheik
 */
@Named(value = "userBean")
@RequestScoped
public class UserBean {
    @Inject
    private UserService userService;

    private User selectedUser;

    List<User> users;

    public UserBean() {
        System.out.println("Starting ManagedBean UserBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        users = userService.listUsers();
        selectedUser = new User();
    }

    public void editListener(RowEditEvent event) {
        User user = (User) event.getObject();
        userService.modifyUser(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void restartSelectedUser() {
        this.selectedUser = new User();
    }

    public void addUser() {
        userService.addUser(this.selectedUser);
        //We also add it to the view (refresh the Model)
        this.users.add(this.selectedUser);
        this.selectedUser = null;
    }
    
    public void editUser() {
        userService.modifyUser(this.selectedUser);
    }

    public void deleteUser() {
        userService.deleteUser(this.selectedUser);
        //We also eliminate it from the view (refresh the Model)
        users.remove(this.selectedUser);
        this.selectedUser = null;
    }
}
