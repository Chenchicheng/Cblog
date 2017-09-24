package cblog.core.persist.dao;


import org.hibernate.query.Query;

import java.io.Serializable;

/**
 * Created by chenchicheng on 17-9-20.
 */
public interface GenericDao extends Serializable {
    /**
     * 插入数据对象
     * @param entity
     */
    void save(Object entity);

    /**
     * 删除数据对象
     * @param entity
     */
    void delete(Object entity);

    /**
     * 更新数据对象
     * @param entity
     */
    void update(Object entity);

    /**
     * 插入或更新数据对象
     * @param entity
     */
    void saveOrUpdate(Object entity);

    /**
     * 从数据库从新读取对象
     * @param entity
     */
    void refresh(Object entity);

    /**
     * 创建query查询
     * @param queryString sql语句
     * @param values  参数列表
     * @return  Query
     */
    Query createQuery(final String queryString, final Object... values);
}
