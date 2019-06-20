package slymove.dao.impl;

import com.liby.slymove.dao.BaseDao;
import com.liby.slymove.dao.BoardInfoListDao;

import java.util.List;

public class BoardInfoListDaoImpl extends BaseDao implements BoardInfoListDao {
    /**
     * 查询的通用方法
     *
     * @param sql
     * @param paramsValue
     * @param clazz
     */
    @Override
    public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz) {
        return super.query(sql, paramsValue, clazz);
    }

    /**
     * 更新的通用方法
     *
     * @param sql         更新的sql语句(update/insert/delete)
     * @param paramsValue sql语句中占位符对应的值(如果没有占位符，传入null)
     */
    @Override
    public void update(String sql, Object[] paramsValue) {
        super.update(sql, paramsValue);
    }
}
