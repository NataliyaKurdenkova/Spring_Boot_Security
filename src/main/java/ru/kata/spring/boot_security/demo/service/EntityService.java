package ru.kata.spring.boot_security.demo.service;

import java.util.List;
import java.util.Optional;

public interface EntityService<E> {
    void save(E entity);
    void delete(long id);
    void update(E entity);
    List<E> findAll();
    Optional<E> findById(long id);
    Optional<E> findByName(String name);

}
