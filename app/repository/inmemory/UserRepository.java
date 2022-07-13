package repository.inmemory;

import model.User;

public interface UserRepository {

    void save(User user);

    User get(Long id);

}
