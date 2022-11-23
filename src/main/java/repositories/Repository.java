package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T> {

    T add (T item);

    T get (T item);

    void remove (T item);

    boolean update (T item1);
}
