package com.abanoj.task_list.task.entities;

public record TaskDto(
        Long id,
        String title,
        TaskStatus status,
        TaskPriority priority) {
}
