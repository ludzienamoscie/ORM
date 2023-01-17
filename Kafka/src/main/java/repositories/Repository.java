package main.java.repositories;

import java.util.List;

public interface Repository <T> {

    T get(Object element);

    void add(T... elements);

    void remove(T... elements);

    void update(T... elements);

    List<T> find(Object... elements);

    List<T> getAll();

    Long size();
}
