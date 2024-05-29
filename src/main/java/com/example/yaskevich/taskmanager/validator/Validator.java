package com.example.yaskevich.taskmanager.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);



}
