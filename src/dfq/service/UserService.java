package dfq.service;
import dfq.daomain.User;
import java.util.List;

public interface UserService {

    public List<User> findAll();
    void deleteUser(String id);
    User login(User user);
    void addUser(User user);

    void delSelectedUser(String[] ids);
}
