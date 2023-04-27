package com.wjh.www.service;

import com.wjh.www.po.Circles;

import java.util.List;

/**
 * @author wjh
 */
public interface CirclesService {
    /**
     * 查询所有瓜圈
     *
     * @return 返回List<Circles>集合
     */
    List<Circles> findListCircles();

    /**
     * 添加一个瓜圈
     *
     * @param circles 被添加的瓜圈，被封装成一个circles对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveCircle(Circles circles);

    /**
     * 根据约束条件删除一个瓜圈
     *
     * @param conditionCircle 约束条件，被封装成一个circles对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removeCircle(Circles conditionCircle);
}
