package repositories;

public interface Repository <T>{
    void add (T item);
    void get (T item);
    void findBy(T item);
    void remove (T item);
}
