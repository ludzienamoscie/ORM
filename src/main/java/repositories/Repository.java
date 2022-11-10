package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T,id_T> {

    T add (T item);

    T get (T item);

    void remove (T item);

    void update (T item1, T item2);
}
