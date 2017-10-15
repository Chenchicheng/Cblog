package cblog.core.persist.dao;

import cblog.core.persist.entity.MenuPO;

import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
public interface MenuDao {
    List<MenuPO> findAll();
}
