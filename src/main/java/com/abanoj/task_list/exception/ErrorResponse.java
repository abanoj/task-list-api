package com.abanoj.task_list.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ErrorResponse(Integer status, String message, ZonedDateTime timeStamp) {
}
