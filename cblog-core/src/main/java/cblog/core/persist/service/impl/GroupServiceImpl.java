package cblog.core.persist.service.impl;

import cblog.core.data.Group;
import cblog.core.persist.dao.GroupDao;
import cblog.core.persist.entity.GroupPO;
import cblog.core.persist.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 17-10-15.
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> findAll() {
        List<GroupPO> list = groupDao.findAll();
        List<Group> list2 = new ArrayList<>();
        if(list != null) {
            for(GroupPO po: list) {
                Group p = new Group();
                BeanUtils.copyProperties(po, p);
                list2.add(p);
            }
        }
        return list2;
    }
}
