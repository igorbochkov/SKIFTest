package repository.inmemory;

import exception.ElementAlreadyExistException;
import exception.ElementNotExistException;
import exception.NotSuchElementException;
import model.User;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {

    private static volatile InMemoryUserRepository instance;

    private final AtomicLong count = new AtomicLong();
    private final Map<Long, User> users = new ConcurrentHashMap<>();

    private InMemoryUserRepository() {

    }

    public static InMemoryUserRepository getInstance() {
        InMemoryUserRepository inMemoryUser = instance;
        if (inMemoryUser == null) {
            synchronized (InMemoryUserRepository.class) {
                inMemoryUser = instance;
                if (inMemoryUser == null) {
                    inMemoryUser = new InMemoryUserRepository();
                    instance = inMemoryUser;
                }
            }
        }
        return instance;
    }

    @Override
    public void save(User user) {
        if (Objects.isNull(user)) {
            throw new ElementNotExistException("User not must be null");
        }
        if (users.containsKey(user.getId())) {
            throw new ElementAlreadyExistException("User already exist");
        }

        users.put(count.getAndDecrement(), user);
    }

    @Override
    public User get(Long id) {
        User user = users.get(id);
        if (user == null) {
            throw new ElementNotExistException("Not find User wish id " + id);
        }
        return users.get(id);
    }
}
