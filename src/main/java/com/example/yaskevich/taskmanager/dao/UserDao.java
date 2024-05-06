package com.example.yaskevich.taskmanager.dao;

import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.entity.User;
import com.example.yaskevich.taskmanager.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, User>{
//    private static final

    @Override
    public List<User> findAll() {
//        try (var connection = ConnectionManager.get();
//             var prepareStatement = connection.prepareStatement(FIND_ALL)) {
//            var resultSet = prepareStatement.executeQuery();
//            List<User> users = new ArrayList<>();
//            while (resultSet.next())
//                users.add(buildUser(resultSet));
//    } catch (SQLException e) {
//            throw new RuntimeException(e);

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

//    private User buildUser(ResultSet resultSet) {
//        return new User(resultSet.getObject("username",Long.class),)
//        ("password",Long.class);
//    }

