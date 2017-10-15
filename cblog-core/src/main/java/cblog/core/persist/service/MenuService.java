package cblog.core.persist.service;

import cblog.core.data.Menu;

import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
public interface MenuService {
    List<Menu> findAll();
}
