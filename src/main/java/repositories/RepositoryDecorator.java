package repositories;

public abstract class RepositoryDecorator<T> implements Repository<T> {

    protected Repository<T> decoratedRepository;

    public RepositoryDecorator(Repository<T> repository ) {
        this.decoratedRepository = repository;
    }

}
