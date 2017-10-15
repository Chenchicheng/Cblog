package cblog.core.persist.dao.impl;

import cblog.annotation.Repository;
import cblog.core.persist.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenchicheng on 17-9-20.
 *
 * 持久层基类，通过泛型指定实体类
 * @param <T> 实体类
 */
public class  BaseDaoImpl<T> extends  GenericDaoImpl implements BaseDao<T> {


    /**
     * 实体类型
     */
    protected Class<T> entityClass;

    /**
     * 自动提取entityClass
     */
    @PostConstruct
    public void init() throws Exception {
        Repository repository = this.getClass().getAnnotation(Repository.class);
        Assert.notNull(repository, this.getClass() + "必须使用" + Repository.class + "注解！");
        Assert.notNull(repository.entity(), this.getClass() + "的 @Repository注解的 entity 不能为空");

        this.entityClass = (Class<T>) repository.entity();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public T get(Serializable id) {
        return get(entityClass,id);
    }

    @Override
    public void deleteById(Serializable id) {
        deleteById(entityClass, id);
    }

    @Override
    public void deleteAll(Collection<Serializable> ids) {
        Assert.notNull(ids, "ids不能为空");
        for(Serializable id : ids) {
            deleteById(id);
        }
    }

    /**
     *创建Criteria查询对象
     * @return
     */
    protected Criteria createCriteria() {
        return createCriteria(entityClass);
    }

    @Override
    public List<T> list() {
        return createCriteria().list();
    }
    /**
     * 根据Criterion条件创建Criteria.
     * 与find()函数可进行更加灵活的操作.
     *
     * @param criterions 数量可变的Criterion.
     * @return Criteria
     */
    protected Criteria createCriteria(final Criterion... criterions) {
        Criteria criteria = session().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }
    /**
     * 按Criteria查询对象列表.
     *
     * @param criterions 数量可变的Criterion.
     * @return 持久队列集合
     */
    @SuppressWarnings("unchecked")
    protected List<T> find(final Criterion... criterions) {
        return createCriteria(criterions).list();
    }

    /**
     * 按属性查找对象列表, 匹配方式为相等.
     *
     * @param propertyName 键
     * @param value 值
     * @return 持久队列集合
     */
    protected List<T> findBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return find(criterion);
    }
    /**
     * 按属性查找唯一对象, 匹配方式为相等.
     *
     * @param propertyName 键
     * @param value 值
     * @return 实体对象
     */
    @SuppressWarnings("unchecked")
    protected T findUniqueBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return (T) createCriteria(criterion).uniqueResult();
    }

}
