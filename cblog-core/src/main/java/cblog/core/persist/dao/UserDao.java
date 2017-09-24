package cblog.core.persist.dao;

import cblog.core.persist.entity.UserPO;

import java.util.List;

/**
 * Created by chenchicheng on 17-9-20.
 */
public interface UserDao {
    UserPO getUserById(long id);
}
