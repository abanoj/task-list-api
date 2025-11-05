package com.abanoj.task_list.task.controller;

import com.abanoj.task_list.task.entities.Task;
import com.abanoj.task_list.task.entities.TaskDto;
import com.abanoj.task_list.task.service.TaskMapper;
import com.abanoj.task_list.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task-list/{task-list-id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
    @GetMapping
    public List<TaskDto> getAllTask(@PathVariable("task-list-id") Long taskListId){
        return taskService.findListTask(taskListId).stream().map(taskMapper::toDto).toList();
    }

    @GetMapping("/{task-id}")
    public Optional<TaskDto> getTask(@PathVariable("task-list-id") Long taskListId, @PathVariable("task-id") Long taskId){
        return taskService.findTask(taskListId, taskId).map(taskMapper::toDto);
    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task-list-id") Long taskListId, @RequestBody TaskDto newTaskDto){
        Task newTask = taskService.createTask(taskListId, taskMapper.toTask(newTaskDto));
        return taskMapper.toDto(newTask);
    }

    @PutMapping("/{task-id}")
    public TaskDto updateTask(@PathVariable("task-list-id") Long taskListId, @PathVariable("task-id") Long taskId, @RequestBody TaskDto taskDtoToUpdate){
        Task taskUpdated = taskService.updateTask(taskListId, taskId, taskMapper.toTask(taskDtoToUpdate));
        return taskMapper.toDto(taskUpdated);
    }

    @DeleteMapping("/{task-id}")
    public void deleteTask(@PathVariable("task-list-id") Long taskListId, @PathVariable("task-id") Long taskId){
        taskService.deleteTask(taskListId, taskId);
    }
}
