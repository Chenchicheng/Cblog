package cblog.web.controller.admin;


import cblog.core.data.User;
import cblog.core.persist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenchicheng on 17-9-19.
 */
@Controller
@RequestMapping(value = "/test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public User getUser() {
       return userService.getUserById(2);
    }
}
