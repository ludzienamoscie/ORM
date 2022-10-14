package repositories;

public interface Repository <T>{
    void add (T item);
    T get (int item);
    void findBy(T item);
    void remove (T item);
}
