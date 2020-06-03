package dfq.dao;

import dfq.daomain.RootUser;

public interface RootUserDao {
    RootUser  findUserByUsernameAndPassword(String username, String password);
    void add(RootUser rootUser);

}
