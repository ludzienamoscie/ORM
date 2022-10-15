package repositories;

import jakarta.transaction.Transactional;

public interface Repository <T,id_T> {

    void add (T item);

    T get (id_T id);

    // przekazac trzeba predykat
    void findBy(T item);

    void remove (T item);

}
