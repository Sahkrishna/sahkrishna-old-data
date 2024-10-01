package com.practice.ems.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiMessage {
    private String message;
    private boolean success;
}
