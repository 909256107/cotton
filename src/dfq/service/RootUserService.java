package dfq.service;

import dfq.daomain.RootUser;

public interface RootUserService {
    RootUser login(RootUser rootUser);
    void addRootUser(RootUser rootUser);
}
