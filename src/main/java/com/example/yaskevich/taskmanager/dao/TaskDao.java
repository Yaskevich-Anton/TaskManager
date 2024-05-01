package com.example.yaskevich.taskmanager.dao;

import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDao implements Dao<Long, Task> {
    public static final TaskDao INSTANCE = new TaskDao();
    private static final String FIND_ALL = """
    SELECT *
    FROM TABLE (tasks)
        """;
    private TaskDao(){

    }
public static TaskDao getInstance(){
        return INSTANCE;
}
    @Override
    public List<Task> findAll() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = prepareStatement.executeQuery();
            List<Task> tasks = new ArrayList<>();
            while (resultSet.next())
                tasks.add(buildTask(resultSet));

            return tasks;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Task entity) {

    }

    @Override
    public Task save(Task entity) {
        return null;
    }
    private Task buildTask(ResultSet resultSet) throws SQLException {
        return null;
//return new Task(
//        resultSet.getObject("id",Long.class),
//        Status.valueOf(resultSet.getObject("status",String.class)))
    }
}
