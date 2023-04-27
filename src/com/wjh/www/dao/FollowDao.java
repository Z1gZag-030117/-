package com.wjh.www.dao;

import com.wjh.www.po.Follow;

/**
 * @author wjh
 */
public interface FollowDao {
    /**
     * 查询是否存在指定的一个对象
     *
     * @param conditionFollow 被封装成follow对象where条件
     * @return 返回布尔值（true存在）
     */
    boolean getIsExistFollower(Follow conditionFollow);

    /**
     * 向follow表中添加一条数据
     *
     * @param follow 被封装成follow对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertFollower(Follow follow);

    /**
     * 删除follow表中的一条数据
     *
     * @param conditionFollow 被封装成follow对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteFollower(Follow conditionFollow);

    /**
     * 更新follow表中的一条数据
     *
     * @param follow   被封装成follow对象的一条新数据
     * @param follower where条件，根据follower来更新
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateFollowerByFollower(Follow follow, String follower);
}
