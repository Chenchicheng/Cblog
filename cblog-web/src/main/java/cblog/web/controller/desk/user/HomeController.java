package cblog.web.controller.desk.user;

import cblog.core.data.User;
import cblog.core.data.UserProfile;
import cblog.core.persist.service.UserService;
import cblog.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by asus on 17-10-14.
 */
@Controller
public class HomeController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping( value = "/home")
    public String home(ModelMap model) {
        initUser(model);
        return "/default/home/feeds";
    }
    private void initUser(ModelMap model) {
        UserProfile up = getSubject().getProfile();
        User user = userService.getUserById(up.getId());
        model.put("user", user);
    }
}
