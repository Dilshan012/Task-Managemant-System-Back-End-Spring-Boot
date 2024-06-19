package com.fullstackapp.taskmanagemantsystem.controller;

import com.fullstackapp.taskmanagemantsystem.model.Task;
import com.fullstackapp.taskmanagemantsystem.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/getalltasks")
    public List<Task> getAllTasks() {
        return tasksService.getTasks();
    }

    @GetMapping("/gettasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return tasksService.getTaskById(id);
    }

    @PostMapping("/createtasks")
    public boolean createTask(@RequestBody Task task) {
        tasksService.addTask(task);
        return true;
    }

    @PutMapping("/updateT/{id}")
    public boolean updateTask(@PathVariable int id, @RequestBody Task task) {
        task.setId(id);
        return tasksService.updateTask(task);
    }

    @DeleteMapping("/deleteT/{id}")
    public boolean deleteTask(@PathVariable int id) {
        return tasksService.deleteTask(id);
    }

    @PostMapping("/auth/showtasks")
    public List<Task> showTasks(@RequestParam String title, @RequestParam String description, @RequestParam String status) {
        // Implement logic for showing specific tasks based on title, description, and status if needed
        // Currently returning all tasks for simplicity
        return tasksService.getTasks();
    }
}
