package cblog.core.persist.dao.impl;

import cblog.annotation.Repository;
import cblog.core.persist.dao.MenuDao;
import cblog.core.persist.entity.MenuPO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
@Repository(entity = MenuPO.class)
public class MenuDaoImpl extends BaseDaoImpl<MenuPO> implements MenuDao{
    @Override
    public List<MenuPO> findAll() {
        Criteria c = createCriteria();
        c.add(Restrictions.eq("status", 0));
        c.addOrder(Order.desc("weight"));
        return c.list();
    }
}
