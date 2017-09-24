package cblog.core.persist.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenchicheng on 17-9-20.
 * 指定泛型的数据访问接口
 * @param <T> 实体类
 */
public interface BaseDao<T> extends GenericDao {

    /**
     * 根据id返回实体对象
     * @param id
     * @return
     */
    T get(Serializable id);

    /**
     * 根据id删除数据对象
     * @param id
     */
    void deleteById(Serializable id);

    /**
     * 根据id列表删除数据对象
     * @param ids
     */
    void deleteAll(Collection<Serializable> ids);

    /**
     * 查询全部数据
     * @return  结果列表
     */
    List<T> list();

}
