package repositories;

import jakarta.transaction.Transactional;

import java.sql.ResultSet;
import java.util.List;
import java.util.function.Predicate;

public interface Repository <T> {

    T get(Object element);

    void add(T... elements);

    void remove(T... elements);

    void update(T... elements);

    List<T> find(Object... elements);

    List<T> getAll();

}
