package com.example.yaskevich.taskmanager.mapper;

public interface Mapper<F,T> {
    T mapFrom(F object);
}
