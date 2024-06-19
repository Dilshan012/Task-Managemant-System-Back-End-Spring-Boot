package com.fullstackapp.taskmanagemantsystem.service;

import com.fullstackapp.taskmanagemantsystem.dao.TasksDao;
import com.fullstackapp.taskmanagemantsystem.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksDao tasksDao;

    public TasksService() {

    }

    public boolean updateTask(Task task){
        return tasksDao.updateTask(task);
    }

    public List<Task> getTasks(){
        return tasksDao.getTasks();
    }

    public void addTask(Task task){
        tasksDao.addTask(task);
    }

    public Task getTaskById(int taskId){
        return tasksDao.getTaskById(taskId);
    }

    public boolean deleteTask(int taskId){
        return tasksDao.deleteTask(taskId);
    }
}
