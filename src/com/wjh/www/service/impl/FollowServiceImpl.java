package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.FollowDaoImpl;
import com.wjh.www.dao.FollowDao;
import com.wjh.www.po.Follow;
import com.wjh.www.service.FollowService;

public class FollowServiceImpl implements FollowService {
    private final FollowDao FollowDao = new FollowDaoImpl();

    @Override
    public boolean findIsExistFollower(Follow conditionFollow) {
        return FollowDao.getIsExistFollower(conditionFollow);
    }

    @Override
    public boolean saveFollower(Follow follow) {
        return FollowDao.insertFollower(follow);
    }

    @Override
    public boolean removeFollower(Follow conditionFollow) {
        return FollowDao.deleteFollower(conditionFollow);
    }

    @Override
    public boolean modifyFollowerByFollower(Follow follow, String follower) {
        return FollowDao.updateFollowerByFollower(follow, follower);
    }
}
