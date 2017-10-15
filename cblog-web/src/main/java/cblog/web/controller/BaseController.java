package cblog.web.controller;

import cblog.core.data.AccountProfile;
import cblog.shrio.authc.AccountSubject;
import cblog.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by asus on 17-10-14.
 */
public class BaseController {
    /**
     * 获取登录信息
     */
    protected AccountSubject getSubject(){
        return (AccountSubject) SecurityUtils.getSubject();
    }

    protected void putProfile(AccountProfile profile) {
        SecurityUtils.getSubject().getSession(true).setAttribute("profile", profile);
    }

    protected AuthenticationToken createToken(String username, String password) {
        return new UsernamePasswordToken(username, MD5.md5(password));
    }


}
