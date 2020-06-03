package dfq.dao.impl;
import dfq.dao.UserDao;
import dfq.daomain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(dfq.util.JDBCUtils.getDataSource());
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void add(User user) {
        String sql = "insert into user (username,password,name) values(?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName());
    }
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        //2.执行sql
        template.update(sql, id);
    }
}

