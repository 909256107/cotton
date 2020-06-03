package dfq.dao;



import dfq.daomain.Cotton;
import dfq.daomain.Cotton_News;

import java.util.List;

public interface Cotton_NewsDao {
    public List<Cotton_News> findAll();
    void update(Cotton_News cn);
    Cotton_News findById(int id);
}
