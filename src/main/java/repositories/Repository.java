package repositories;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T> {

//    public Repository)() {
//        initSession();
//    }

    T add (T item);

    T get (T item);

    void remove (T item);

    boolean update (T item1);
}
