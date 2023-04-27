package com.wjh.www.service;

import com.wjh.www.po.Collection;

/**
 * @author wjh
 */
public interface CollectionService {
    /**
     * 查询是否存在约束条件下的瓜圈
     *
     * @param conditionCollection 约束条件，被封装成一个collection对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean findIsExistCollection(Collection conditionCollection);

    /**
     * 添加一个瓜圈
     *
     * @param collection 被封装成一个collection对象的瓜圈的数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveCollection(Collection collection);

    /**
     * 根据约束条件删除一个收藏记录
     *
     * @param conditionCollection 被封装成collection对象的约束条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removeCollectionIncident(Collection conditionCollection);

    /**
     * 修改一条收藏记录
     *
     * @param collection 新的收藏记录，被封装成collection对象
     * @param collector  约束条件，根据collector来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyCollectionByCollector(Collection collection, String collector);
}
