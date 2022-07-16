package util;

import dto.UserDto;
import model.User;

public class UserUtil {

    private UserUtil() {
    }

    public static User toUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

}
