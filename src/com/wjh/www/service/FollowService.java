package com.wjh.www.service;

import com.wjh.www.po.Follow;

/**
 * @author wjh
 */
public interface FollowService {
    /**
     * 查询是否已经存在点赞记录
     *
     * @param conditionFollow 约束条件，被封装成follow对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean findIsExistFollower(Follow conditionFollow);

    /**
     * 添加一条点赞记录
     *
     * @param follow 被封装成follow对象的一条点赞数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveFollower(Follow follow);

    /**
     * 删除一条点赞记录
     *
     * @param conditionFollow 被封装成follow的约束条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removeFollower(Follow conditionFollow);

    /**
     * 修改一条点赞记录
     *
     * @param follow   被封装成follow对象的新的点赞记录
     * @param follower 约束条件，通过follower来修改记录
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyFollowerByFollower(Follow follow, String follower);

}
