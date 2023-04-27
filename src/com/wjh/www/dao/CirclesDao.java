package com.wjh.www.dao;

import com.wjh.www.po.Circles;

import java.util.List;

/**
 * @author wjh
 */
public interface CirclesDao {
    /**
     * 获取circles表的所有数据
     *
     * @return 返回circles表的所有数据，已经被封装成一个List<Circles>集合
     */
    List<Circles> listCircles();

    /**
     * 删除circles表中的一条数据
     *
     * @param conditionCircle 被封装成circles对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteCircle(Circles conditionCircle);

    /**
     * 向circles表插入一条数据
     *
     * @param circles 被封装成circles对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertCircle(Circles circles);
}
