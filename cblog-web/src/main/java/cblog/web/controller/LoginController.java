package cblog.web.controller;


import cblog.core.data.User;
import cblog.core.persist.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chenchicheng on 17-9-23.
 */
@Controller
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;
    /**
     * 跳转到登录页
     */
    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public String view() {
        return "/default/login";
    }
    /**
     * 提交登录
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password,@RequestParam(value = "rememberMe",defaultValue = "0") int rememberMe, ModelMap model) {

        String ret = "/default/login";
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return ret;
        }
        AuthenticationToken token = createToken(username, password);
        if(token == null) {
            model.put("message", "用户名或密码有误");
            return ret;
        }
        if(rememberMe == 1){
            ((UsernamePasswordToken)token).setRememberMe(true);
        }
        try {
            SecurityUtils.getSubject().login(token);
            ret = "redirect:/home";
        }catch (AuthenticationException e){
            if(e instanceof UnknownAccountException){
                model.put("message", "用户不存在");
            }else if(e instanceof LockedAccountException){
                model.put("message", "用户被禁用");
            }else {
                model.put("message", "用户认证失败");
            }
        }

        return ret;
    }

}
