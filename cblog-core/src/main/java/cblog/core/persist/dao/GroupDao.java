package cblog.core.persist.dao;

import cblog.core.persist.entity.GroupPO;

import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
public interface GroupDao {
    List<GroupPO> findAll();
}
