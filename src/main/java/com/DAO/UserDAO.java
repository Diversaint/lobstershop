package com.DAO;

import com.model.User;

public class UserDAO implements IDAO<User> {
    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User read(User user) {
        return null;
    }

    @Override
    public User update(User user, User newT) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
