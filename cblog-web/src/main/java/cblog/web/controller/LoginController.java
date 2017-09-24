package cblog.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chenchicheng on 17-9-23.
 */
@Controller
public class LoginController {
    /**
     * 跳转到登录页
     */
    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public String view() {
        return "/default/login";
    }
}
