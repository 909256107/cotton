package dfq.service;
import dfq.daomain.Cotton_News;

import java.util.List;

public interface Cotton_NewService {
    public List<Cotton_News> findAll();
    void update(Cotton_News cn);
    Cotton_News findCotton_NewsById(String id);
}
