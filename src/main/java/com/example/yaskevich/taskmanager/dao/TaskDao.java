package com.example.yaskevich.taskmanager.dao;

import com.example.yaskevich.taskmanager.entity.Status;
import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDao implements Dao<Long, Task> {
    public static final TaskDao INSTANCE = new TaskDao();
    private static final String FIND_ALL = """
            SELECT *
            FROM task_manager.tasks
                """;
    private static final String FIND_BY_ID = """
            SELECT id
            FROM task_manager.tasks
            WHERE id = ?
            """;

    private TaskDao() {

    }

    public static TaskDao getInstance() {
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

        List<Task> result = new ArrayList<>();
        try {
            var connection = ConnectionManager.get();
            var preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getObject("tasks", Task.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
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

        return new Task(resultSet.getObject("id", Long.class),
                resultSet.getObject("taskName", String.class),
                resultSet.getObject("deadLine", LocalDateTime.class),
                Status.valueOf(resultSet.getObject("status", String.class)));

    }
}
