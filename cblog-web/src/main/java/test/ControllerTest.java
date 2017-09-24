package test;

import cblog.core.persist.dao.UserDao;
import cblog.core.persist.entity.UserPO;
import cblog.web.controller.admin.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenchicheng on 17-9-21.
 */
public class ControllerTest {
   @Autowired
   private UserController userController;
    @Test
    public void test() {
        userController.getUser();
    }

    @Test
    public void testDao() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        UserDao userDao = (UserDao)ctx.getBean("userDao");
        UserPO userPo = userDao.getUserById(1);
    }
}
