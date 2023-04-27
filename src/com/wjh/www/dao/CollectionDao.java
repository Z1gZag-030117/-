package com.wjh.www.dao;

import com.wjh.www.po.Collection;

/**
 * @author wjh
 */
public interface CollectionDao {

    boolean getIsExistCollection(Collection conditionCollection);

    /**
     * 向collection表中插入一条数据
     *
     * @param collection 被封装成collection对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertCollectionIncident(Collection collection);

    /**
     * 删除collection表中的一条数据
     *
     * @param conditionCollection 被封装成collection对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteCollectionIncident(Collection conditionCollection);

    /**
     * 更新collection表中的一条数据
     *
     * @param collection 被封装成collection对象的一条新数据
     * @param collector  where条件，通过collector属性来更新
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateCollectionByCollector(Collection collection, String collector);
}
