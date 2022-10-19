package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T,id_T> {

    T add (T item);

    T get (id_T id);

    void remove (T item);

    //    List<T> findBy(Predicate<T> predicate);

//    int size();

}
