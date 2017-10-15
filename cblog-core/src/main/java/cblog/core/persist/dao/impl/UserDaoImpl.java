package cblog.core.persist.dao.impl;

import cblog.annotation.Repository;
import cblog.core.persist.dao.UserDao;
import cblog.core.persist.entity.UserPO;
import org.springframework.stereotype.Component;


/**
 * Created by chenchicheng on 17-9-20.
 */
@Repository( entity = UserPO.class)
public class UserDaoImpl extends BaseDaoImpl<UserPO> implements UserDao {
    @Override
    public UserPO getUserById(long id) {
        return get(id);
    }
    @Override
    public UserPO getUserByUsername(String username) {
      return findUniqueBy("username", username);
    }
}
