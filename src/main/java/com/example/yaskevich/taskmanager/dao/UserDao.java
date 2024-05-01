package com.example.yaskevich.taskmanager.dao;

import com.example.yaskevich.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, User>{
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User save(User entity) {
        return null;
    }
}
