package dfq.service.impl;

import dfq.dao.Cotton_NewsDao;
import dfq.dao.impl.Cotton_NewDaoImpl;
import dfq.daomain.Cotton_News;
import dfq.service.Cotton_NewService;

import java.util.List;

public class Cotton_NewServiceImpl implements Cotton_NewService {
    Cotton_NewsDao cnd = new Cotton_NewDaoImpl();

    @Override
    public List<Cotton_News> findAll() {
        return cnd.findAll();
    }

    @Override
    public void update(Cotton_News cn) {
        cnd.update(cn);
    }

    @Override
    public Cotton_News findCotton_NewsById(String id) {
        return cnd.findById(Integer.parseInt(id));
    }
}
