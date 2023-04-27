package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.FollowDao;
import com.wjh.www.po.Follow;

import java.util.List;

/**
 * @author wjh
 */
public class FollowDaoImpl implements FollowDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Follow.class.getAnnotation(Table.class).value();

    @Override
    public boolean getIsExistFollower(Follow conditionFollow) {
        String fields = "incident_title";
        List<Follow> followList = baseDao.select(conditionFollow, Follow.class, fields, TABLE_NAME);
        return followList.size() > 0;
    }

    @Override
    public boolean insertFollower(Follow follow) {
        return baseDao.insert(follow);
    }

    @Override
    public boolean deleteFollower(Follow conditionFollow) {
        return baseDao.delete(conditionFollow);
    }

    @Override
    public boolean updateFollowerByFollower(Follow follow, String follower) {
        return baseDao.update(follow, Thread.currentThread().getStackTrace()[1].getMethodName(), follower);
    }


}
