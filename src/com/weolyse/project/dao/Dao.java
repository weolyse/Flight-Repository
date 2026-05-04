package com.weolyse.project.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface Dao<I, E> {

    List<E> findAll();

    Optional<E> findById(I id);

    boolean delete(I id);

    E create(E entity);

    void update(E entity);

}
