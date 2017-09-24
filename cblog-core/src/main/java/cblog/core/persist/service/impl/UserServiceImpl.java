package cblog.core.persist.service.impl;

import cblog.core.data.User;
import cblog.core.persist.dao.UserDao;
import cblog.core.persist.entity.UserPO;
import cblog.core.persist.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by chenchicheng on 17-9-20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(long id) {
        UserPO userPO = userDao.getUserById(id);
        User user = new User();
        if(userPO != null) {
             BeanUtils.copyProperties(userPO, user);
        }
        return user;
    }
    @Override
    public User getUser() {

        User u = new User();
        u.setUsername("chenchicheng");
        return u;
    }
}
