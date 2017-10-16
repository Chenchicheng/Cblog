package cblog.web.controller.desk;

import cblog.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus on 17-10-16.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping( value = "/index")
    public String index (ModelMap model, HttpServletRequest request) {
        String order = ServletRequestUtils.getStringParameter(request, "ord", "newest");
        model.put("ord", order);
        return "/default/index";
    }
}
