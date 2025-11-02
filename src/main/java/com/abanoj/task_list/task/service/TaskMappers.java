package com.abanoj.task_list.task.service;

import com.abanoj.task_list.task.entities.Task;
import com.abanoj.task_list.task.entities.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMappers {
    public TaskDto toDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getTaskStatus(),
                task.getTaskPriority()
        );
    }

    public Task toTask(TaskDto taskDto){
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.status(),
                taskDto.priority(),
                null,
                null,
                null
        );
    }
}
