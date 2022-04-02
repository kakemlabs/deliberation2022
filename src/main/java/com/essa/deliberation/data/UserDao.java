/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.User;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface UserDao {
    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User findUserById(int idUser);

    List<User> findAllUser();

    long countUser();
}
