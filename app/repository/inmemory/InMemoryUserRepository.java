package repository.inmemory;

import exception.ElementNotExistException;
import model.User;
import repository.Repository;
import util.UserData;

import javax.inject.Singleton;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class InMemoryUserRepository implements Repository<Integer, User> {

    private final AtomicInteger count = new AtomicInteger();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public InMemoryUserRepository(){
        full();
    }

    @Override
    public void save(User user) {
        if (Objects.isNull(user)) {
            throw new ElementNotExistException("User not must be null");
        }
        Integer newId = count.getAndIncrement();
        user.setId(newId);
        users.put(newId, user);
    }

    @Override
    public User get(Integer id) {
        User user = users.get(id);
        if (user == null) {
            throw new ElementNotExistException("Not find User wish id " + id);
        }
        return user;
    }

    private void full() {
        UserData.getUsers().forEach(this::save);

    }
}
