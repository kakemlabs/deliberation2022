/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.User;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface UserService {

    public List<User> listUsers();

    public User findUser(User user);

    public void addUser(User user);

    public void modifyUser(User user);

    public void deleteUser(User user);
}
