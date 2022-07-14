package repository;

public interface Repository<I, U> {

    void save(U user);

    U get(I id);

}
