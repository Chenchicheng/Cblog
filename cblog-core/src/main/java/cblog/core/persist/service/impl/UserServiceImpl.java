package cblog.core.persist.service.impl;


import cblog.core.data.AccountProfile;
import cblog.core.data.User;
import cblog.core.persist.dao.UserDao;
import cblog.core.persist.entity.UserPO;
import cblog.core.persist.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Calendar;


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

    @Override
    public AccountProfile login(String username, String password) {
        UserPO po = userDao.getUserByUsername(username);
        Assert.notNull(po, "账户不存在");

        if (StringUtils.equals(po.getPassword(), password)) {
            po.setLastLogin(Calendar.getInstance().getTime());
            AccountProfile passport = new AccountProfile(po.getId(), po.getUsername());
            passport.setName(po.getName());
            passport.setEmail(po.getEmail());
            passport.setAvatar(po.getAvatar());
            passport.setLastLogin(po.getLastLogin());
            passport.setStatus(po.getStatus());
            passport.setActiveEmail(po.getActiveEmail());
            passport.setRoleId(po.getRole_id());
            return passport;
        }
       return null;
    }

    @Override
    public AccountProfile getProfileByName(String username) {
        UserPO po = userDao.getUserByUsername(username);
        AccountProfile u = null;

        Assert.notNull(po, "账户不存在");

//		Assert.state(po.getStatus() != Const.STATUS_CLOSED, "您的账户已被封禁");
        po.setLastLogin(Calendar.getInstance().getTime());
        BeanUtils.copyProperties(po, u);
        return u;
    }

    @Override
    public User getUserByname(String username) {
        UserPO userPO =  userDao.getUserByUsername(username);
        if(userPO != null) {
            User user = new User();
            BeanUtils.copyProperties(userPO, user);
            return user;
        }
        return null;
    }
}
