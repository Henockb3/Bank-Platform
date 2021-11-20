package bankplatform.dao;

import bankplatform.dto.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);
    User getUserByEmailAndPassword(String email,String password);
    User updateUser(User user);
    List<User> getUserList();
    User removeUser();

}
