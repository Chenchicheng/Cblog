package cblog.core.persist.service;

import cblog.core.data.User;

/**
 * Created by chenchicheng on 17-9-20.
 */
public interface UserService {
    User getUserById(long id);
    public User getUser();
}
