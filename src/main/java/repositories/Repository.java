package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T,id_T> {

    T add (T item);

    T get (id_T id);

    boolean remove (T item);

}
