package cblog.core.persist.dao.impl;

import cblog.core.persist.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;


/**
 * Created by chenchicheng on 17-9-20.
 */
public class GenericDaoImpl implements GenericDao {

    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获得上下文的Session
     * @return Session
     */
    protected Session session() {
        return this.sessionFactory.openSession();
    }

    /**
     * 持久化实体对象
     * @param entity
     */
    @Override
    public void save(Object entity) {
        Assert.notNull(entity, "entity不能为空");
        session().save(entity).hashCode();
    }

    /**
     * 删除持久化对象
     * @param entity
     */
    @Override
    public void delete(Object entity) {
        Assert.notNull(entity, "entity不能为空");
        session().delete(entity);
    }

    /**
     * 修改持久化对象
     * @param entity
     */
    @Override
    public void update(Object entity) {
        Assert.notNull(entity, "entity不能为空");
        session().update(entity);
    }

    /**
     * 添加/修改
     * @param entity
     */
    @Override
    public void saveOrUpdate(Object entity) {
        Assert.notNull(entity, "entity不能为空");
        session().saveOrUpdate(entity);
    }

    /**
     * refresh 持久化对象
     * @param entity
     */
    @Override
    public void refresh(Object entity) {
        Assert.notNull(entity, "entity不能为空");
        session().refresh(entity);
    }

    /**
     * get查询
     * @param clazz 实体类
     * @param <E>   实体类类型
     * @param id
     * @return 实体对象
     */
     @SuppressWarnings("unchecked")
     public <E> E get(Class<E> clazz, Serializable id) {
         return (E) session().get(clazz, id);
     }

    /**
     * 根据主键删除
     * @param clazz
     * @param id
     */
    protected void deleteById(Class<?> clazz, Serializable id) {
        Session s = session();
        Object obj = s.get(clazz, id);
        if(obj != null) {
            s.delete(obj);
        }
    }

    /**
     *
     * @param queryString sql语句
     * @param values  参数列表
     * @return
     */
    @Override
    public Query createQuery(final String queryString, Object... values) {
        Assert.notNull(queryString, "hql不能为空");
        Query query = session().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i <  values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return null;

    }

    /**
     * 创建带缓存的QBC查询
     */
    protected Criteria createCriteria(Class<?> clazz) {
        return session().createCriteria(clazz).setCacheable(true);
    }

}
