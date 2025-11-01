package com.abanoj.task_list.task.service;

import com.abanoj.task_list.task.entities.Task;
import com.abanoj.task_list.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findTask(Long taskListId, Long id) {
        return taskRepository.findByTaskListIdAndId(taskListId, id);
    }

    @Override
    public List<Task> findListTask(Long taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(Long taskListId, Task task) {

        return null;
    }

    @Override
    public Task updateTask(Long taskListId, Long id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(Long taskListId, Long id) {
        taskRepository.deleteByTaskListIdAndId(taskListId, id);
    }
}
