package com.vivohackathon.letsdomaths.service;

import com.vivohackathon.letsdomaths.bean.User;
import com.vivohackathon.letsdomaths.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User getByName(String name) {
        return userDAO.findByName(name);
    }

    public User get(String name, String password) {
        return userDAO.getByNameAndPassword(name,password);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}
