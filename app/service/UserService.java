package service;

import dto.UserDto;
import model.User;
import repository.inmemory.InMemoryUserRepository;
import util.UserUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService {

    @Inject
    private InMemoryUserRepository userRepository;

    public void save(UserDto userDto) {
        userRepository.save(UserUtil.toUser(userDto));
    }

    public User get(Integer id) {
        return userRepository.get(id);
    }
}
