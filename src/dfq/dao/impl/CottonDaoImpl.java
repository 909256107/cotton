package dfq.dao.impl;

import dfq.dao.CottonDao;
import dfq.daomain.Cotton;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CottonDaoImpl implements CottonDao {
    private JdbcTemplate template2 = new JdbcTemplate(dfq.util.JDBCUtils.getDataSource());
    @Override
    public List<Cotton> findAll() {
        String sql = "select * from cotton";
        List<Cotton> cottons = template2.query(sql, new BeanPropertyRowMapper<Cotton>(Cotton.class));
        return cottons;
    }

    @Override
    public void add(Cotton cotton) {
        String sql = "insert into cotton values(null,?,?,?,?)";
        //2.执行sql
        template2.update(sql,cotton.getProject(),cotton.getDrug(),cotton.getDate(),cotton.getDate());
    }
    @Override
    public void delete(int id) {
        String sql = "delete from cotton where id = ?";
        //2.执行sql
        template2.update(sql, id);
    }

    @Override
    public Cotton findById(int id) {
        String sql = "select * from cotton where id = ?";
        return template2.queryForObject(sql, new BeanPropertyRowMapper<Cotton>(Cotton.class), id);
    }

    @Override
    public void update(Cotton cotton) {
        String sql = "update cotton set project = ? , drug = ? , date = ? , number = ? where id = ?";
        template2.update(sql,cotton.getProject(),cotton.getDrug(),cotton.getDate(),cotton.getNumber(),cotton.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from cotton where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template2.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Cotton> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from cotton  where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);
        return template2.query(sql,new BeanPropertyRowMapper<Cotton>(Cotton.class),params.toArray());
    }
}
