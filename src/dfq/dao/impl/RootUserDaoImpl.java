package dfq.dao.impl;

import dfq.dao.RootUserDao;
import dfq.daomain.RootUser;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RootUserDaoImpl implements RootUserDao {
    private JdbcTemplate template = new JdbcTemplate(dfq.util.JDBCUtils.getDataSource());
    @Override
    public RootUser findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from rootuser where username = ? and password = ?";
            RootUser rootuser = template.queryForObject(sql, new BeanPropertyRowMapper<RootUser>(RootUser.class), username, password);
            return rootuser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void add(RootUser rootUser) {
        String sql = "insert into rootuser (username,password,name) values(?,?,?)";
        template.update(sql,rootUser.getUsername(),rootUser.getPassword(),rootUser.getName());
    }
}
