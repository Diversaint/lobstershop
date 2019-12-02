package com.DAO;

public interface IDAO<T> {

    boolean create(T t);
    T read(T t);
    T update(T t, T newT);
    T delete(T t);

}
