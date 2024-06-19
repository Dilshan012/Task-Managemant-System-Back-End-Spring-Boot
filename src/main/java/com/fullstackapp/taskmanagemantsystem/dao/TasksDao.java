package com.fullstackapp.taskmanagemantsystem.dao;

import com.fullstackapp.taskmanagemantsystem.mappers.TaskRowMapper;
import com.fullstackapp.taskmanagemantsystem.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Task> getTasks() {
        String query = "SELECT id, title, description, status FROM tasks";
        return jdbcTemplate.query(query, new TaskRowMapper());
    }

    public List<Task> getCompletedTasks() {
        String query = "SELECT id, title, description, status FROM tasks";
        return jdbcTemplate.query(query, new TaskRowMapper());
    }
    public Task getTaskById(int taskId) {
        String query = "SELECT id, title, description, status " +
                "FROM tasks " +
                "WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{taskId}, new TaskRowMapper());
    }
    public boolean updateTask(Task task) {
        String updateSQL = "UPDATE tasks SET title = ?, description = ?, status = ? WHERE id = ?";

        int result = jdbcTemplate.update(updateSQL,
                task.getTitle(), task.getDescription(), task.getStatus(), task.getId());

        return result > 0;
    }
    public boolean addTask(Task task) {
        String insertSQL = "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(insertSQL, task.getTitle(), task.getDescription(),
                task.getStatus());
        System.out.println("Number of records inserted: " + result);
        return result > 0;
    }
    public boolean deleteTask(int taskId) {
        String deleteSQL = "DELETE FROM tasks WHERE id = ?";
        int result = jdbcTemplate.update(deleteSQL, taskId);
        System.out.println("Number of records deleted: " + result);
        return result > 0;
    }

    public boolean completeTask(int taskId) {
        String updateSQL = "UPDATE tasks SET completed = 1 WHERE id = ?";
        int result = jdbcTemplate.update(updateSQL, taskId);
        return result > 0;
    }


}
