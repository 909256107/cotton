package dfq.service.impl;

import dfq.dao.RootUserDao;
import dfq.dao.impl.RootUserDaoImpl;
import dfq.daomain.RootUser;
import dfq.service.RootUserService;

public class RootUserServiceImpl  implements RootUserService {
    private RootUserDao rdao = new RootUserDaoImpl();
    @Override
    public RootUser login(RootUser rootUser) {
        return rdao.findUserByUsernameAndPassword(rootUser.getUsername(),rootUser.getPassword());
    }

    @Override
    public void addRootUser(RootUser rootUser) {
        rdao.add(rootUser);
    }
}
