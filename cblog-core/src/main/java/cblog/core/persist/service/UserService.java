package cblog.core.persist.service;

import cblog.core.data.AccountProfile;
import cblog.core.data.User;

/**
 * Created by chenchicheng on 17-9-20.
 */
public interface UserService {
    User getUserById(long id);
    public User getUser();
    User getUserByname(String username);
    AccountProfile login(String username, String password);
    AccountProfile getProfileByName(String username);
}
