package com.leoli.md_server.model.repository;

public interface MdRepository<T> {
    void save(T t);
    T findById(String id);
}
