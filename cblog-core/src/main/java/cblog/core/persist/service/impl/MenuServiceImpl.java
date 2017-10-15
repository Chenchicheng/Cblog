package cblog.core.persist.service.impl;

import cblog.core.data.Menu;
import cblog.core.persist.dao.MenuDao;
import cblog.core.persist.entity.MenuPO;
import cblog.core.persist.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> findAll() {
        List<MenuPO> list = menuDao.findAll();
        List<Menu> list2 = new ArrayList<>();
        if(list != null) {
            for(MenuPO po: list) {
                Menu p = new Menu();
                BeanUtils.copyProperties(po, p);
                list2.add(p);
            }
        }
        return list2;
    }
}
