package dfq.service.impl;

import dfq.dao.CottonDao;
import dfq.dao.impl.CottonDaoImpl;
import dfq.daomain.Cotton;
import dfq.daomain.PageBean;
import dfq.service.CottonService;

import java.util.List;
import java.util.Map;

public class CottonServiceImpl implements CottonService {
    private CottonDao c = new CottonDaoImpl();
    @Override
    public List<Cotton> findAll() {
        return  c.findAll();
    }

    @Override
    public void addCotton(Cotton cotton) {
        c.add(cotton);
    }

    @Override
    public void deleteCotton(String id) {
        c.delete(Integer.parseInt(id));
    }

    @Override
    public Cotton findCottonById(String id) {
        return c.findById(Integer.parseInt(id));
    }

    @Override
    public void updateCotton(Cotton cotton) {
        c.update(cotton);
    }

    @Override
    public void deleSelectedCotton(String[] ids) {
        for (String id : ids) {
            c.delete(Integer.parseInt(id));

        }
    }

    @Override
    public PageBean<Cotton> findCottonByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Cotton> pb = new PageBean<Cotton>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = c.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<Cotton> list = c.findByPage(start,rows,condition);
        pb.setList(list);
        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

}
