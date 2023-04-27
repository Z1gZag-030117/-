package com.wjh.www.dao;

import com.wjh.www.po.Collection;
import com.wjh.www.po.Incident;

import java.util.List;

public interface IncidentDao {
    /**
     * 向incident表插入一条数据
     *
     * @param incident 被封装成incident对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertIncident(Incident incident);

    /**
     * 查询incident表中的多条数据
     *
     * @param conditionIncident 被封装成incident对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    List<Incident> listIncidents(Incident conditionIncident);

    /**
     * 查询incident表中的多条数据（被收藏的瓜）
     *
     * @param conditionCollection 被封装成collection对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    List<Incident> listCollectionIncidents(Collection conditionCollection);

    /**
     * 删除incident表中的一条数据
     *
     * @param conditionIncident 被封装成incident对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deletePublishIncident(Incident conditionIncident);

    /**
     * 使incident表中某一行的like字段值加1
     *
     * @param incident 被封装成incident对象的新数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updatePlusOneLikeNum(Incident incident);

    /**
     * 使incident表中某一行的like字段值减1
     *
     * @param incident 被封装成incident对象的新数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateMinusOneLikeNum(Incident incident);

    /**
     * 更新incident表中的一条数据
     *
     * @param incident  被封装成incident对象的一条新数据
     * @param publisher where条件，通过publisher来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateIncidentByPublisher(Incident incident, String publisher);
}
