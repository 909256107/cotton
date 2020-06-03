package dfq.service.impl;

import dfq.dao.UserDao;
import dfq.dao.impl.UserDaoImpl;
import dfq.daomain.User;
import dfq.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids!=null&&ids.length>0){
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
