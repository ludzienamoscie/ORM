package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T,id_T> {

    void add (T item);

    T get (id_T id);

    List<T> findBy(Predicate<T> predicate);

    void remove (T item);

    int size();

}
