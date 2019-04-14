package com.leoli.md_server.model.service;

public interface MdService<T> {
    void save(T t);
    T findbyId(String id);
}
