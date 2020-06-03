package dfq.dao;

import dfq.daomain.Cotton;

import java.util.List;
import java.util.Map;

public interface CottonDao {
    public List<Cotton> findAll();
    void add(Cotton cotton);
    void delete(int id);
    Cotton findById(int id);
    void update(Cotton cotton);
    int findTotalCount(Map<String,String[]> condition);
    List<Cotton> findByPage(int start,int rows,Map<String,String[]> condition);

}
