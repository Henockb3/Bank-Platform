package bankplatform.dao;

import bankplatform.dto.User;

import java.util.List;

public interface UserDao {
    User createUser();
    User getUserByEmail(String email);
    User updateUser(User user);
    List<User> getUserList();
    User removeUser();

}
