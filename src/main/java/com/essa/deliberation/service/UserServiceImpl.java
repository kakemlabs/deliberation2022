/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.UserDao;
import com.essa.deliberation.domain.User;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Inject
    private UserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.findAllUser();
    }

    @Override
    public User findUser(User user) {
        return userDao.findUserById(user.getId());
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    
}
