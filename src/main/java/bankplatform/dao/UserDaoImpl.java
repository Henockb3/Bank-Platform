package bankplatform.dao;

import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbc;//commetn

    public static final class userMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getInt("userId"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }

    @Override
    public User createUser(User user) {
       final String INSERT_USER = "INSERT INTO user(firstName,lastName,email,password)" +
               "VALUES(?,?,?,?)";
       jdbc.update(INSERT_USER,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
       int newId = jdbc.queryForObject("SELECT MAX(userId) FROM user", Integer.class);
       user.setUserId(newId);
       return user;
    }

    @Override
    public User getUserByEmail(String email) {
    try{
        final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE userId = ?";
        User user=jdbc.queryForObject(SELECT_USER_BY_EMAIL,new userMapper());
        return user;
    }catch(DataAccessException ex) {
        return null;
    }
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        final String SELECT_USERS = "SELECT * FROM  user";
        return jdbc.query(SELECT_USERS, new userMapper());
    }

    @Override
    public User removeUser() {
    return null;
    }
}
