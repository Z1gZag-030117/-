package com.wjh.www.service;

import com.wjh.www.po.Collection;
import com.wjh.www.po.Incident;

import java.util.List;

/**
 * @author wjh
 */
public interface IncidentService {
    /**
     * 添加一个事件
     *
     * @param incident 被封装成incident对象的事件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveIncident(Incident incident);

    /**
     * 根据约束条件查询多条事件
     *
     * @param conditionIncident 被封装成incident对象的约束条件
     * @return 返回封装了incident对象的List<Incident>集合
     */
    List<Incident> findListIncidents(Incident conditionIncident);

    /**
     * 根据约束条件查询被收藏的事件
     *
     * @param conditionCollection 约束条件，被封装成collection对象了
     * @return 返回封装了incident对象的List<Incident>集合
     */
    List<Incident> findListCollectionIncidents(Collection conditionCollection);

    /**
     * 根据约束条件删除一个事件
     *
     * @param conditionIncident 被封装成incident对象的约束条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removePublishIncident(Incident conditionIncident);

    /**
     * 点赞数加1
     *
     * @param incident 被封装了被点赞的数据的incident对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyPlusOneLikeNum(Incident incident);

    /**
     * 点赞数减去1
     *
     * @param incident 被封装了被点赞的数据的incident对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyMinusOneLikeNum(Incident incident);

    /**
     * 通过约束条件修改事件
     *
     * @param incident  新的数据，被封装成一个incident对象
     * @param publisher 约束条件，根据publisher来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyIncidentByPublisher(Incident incident, String publisher);
}
