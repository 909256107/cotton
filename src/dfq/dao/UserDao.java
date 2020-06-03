package dfq.dao;

import dfq.daomain.User;


import java.util.List;

public interface UserDao {
    User findUserByUsernameAndPassword(String username, String password);
    void add(User user);
    public List<User> findAll();
    void delete(int id);
}
