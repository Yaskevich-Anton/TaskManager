package com.example.yaskevich.taskmanager.validator;

import lombok.Value;

@Value(staticConstructor = "of")
public class Error {
    String code;
    String massage;
}
