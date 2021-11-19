package bankplatform.dao;

import bankplatform.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbc;
public static final class

    @Override
    public User createUser(User user) {
       final String INSERT_USER = "INSERT INTO user(userId,firstName,lastName,email,password)" +
               "VALUES(?,?,?,?)";
       jdbc.update(INSERT_USER,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
       int newId = jdbc.queryForObject("SELECT MAX(roundId) FROM round", Integer.class);

    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User removeUser() {
        return null;
    }
}
