package com.example.yaskevich.taskmanager.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, T> {
    List<T> findAll();
    Optional<T> findById(K id);
    boolean delete(Integer id);
    T save(T entity);
}
