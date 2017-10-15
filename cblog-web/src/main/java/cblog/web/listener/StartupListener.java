package cblog.web.listener;

import cblog.core.data.Group;
import cblog.core.persist.service.GroupService;
import cblog.core.persist.service.MenuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
@Component
public class StartupListener implements InitializingBean, ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    private GroupService groupService;
    @Autowired
    private MenuService menuService;

    public ServletContext getServletContext() {
        return servletContext;
    }

    private void loadConfig(){
        servletContext.setAttribute("groups", groupService.findAll());
        servletContext.setAttribute("menus", menuService.findAll());
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
         this.servletContext = servletContext;
    }

}
