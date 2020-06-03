package dfq.dao.impl;

import dfq.dao.Cotton_NewsDao;

import dfq.daomain.Cotton_News;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Cotton_NewDaoImpl implements Cotton_NewsDao {
    private JdbcTemplate template2 = new JdbcTemplate(dfq.util.JDBCUtils.getDataSource());
    @Override
    public List<Cotton_News> findAll() {
        String sql = "select * from cotton_news";
        List<Cotton_News> cns = template2.query(sql, new BeanPropertyRowMapper<Cotton_News>(Cotton_News.class));
        return cns;
    }
    @Override
    public void update(Cotton_News cn) {
        String sql = "update cotton_news set province = ? , city = ? , town = ? , village = ? ,breed = ? , density = ? , investigator = ? , tabledate = ? , xiaoqu = ?";
        template2.update(sql,cn.getProvince(),cn.getCity(),cn.getTown(),cn.getVillage(),cn.getBreed(),cn.getDensity(),cn.getInvestigator(),cn.getTabledate(),cn.getXiaoqu());

    }
    @Override
    public Cotton_News findById(int id) {
        String sql = "select * from cotton_news where id = ?";
        return template2.queryForObject(sql, new BeanPropertyRowMapper<Cotton_News>(Cotton_News.class), id);
    }
}
