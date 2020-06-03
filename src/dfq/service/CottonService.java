package dfq.service;

import dfq.daomain.Cotton;
import dfq.daomain.PageBean;

import java.util.List;
import java.util.Map;

public interface CottonService {
    public List<Cotton> findAll();
    void addCotton(Cotton cotton);
    void deleteCotton(String id);
    Cotton findCottonById(String id);
    void updateCotton(Cotton cotton);
    void deleSelectedCotton(String[] ids);

    PageBean<Cotton> findCottonByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
