package com.wjh.www.dao;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wjh
 */
public interface BaseDao {
    /**
     * 把一个非空对象映射成为属性名集合和属性值集合
     *
     * @param obj         需要被映射的对象
     * @param fieldNames  将映射的属性名返回在这个集合中
     * @param fieldValues 将映射的属性值返回在这个集合中
     */
    void fieldMapper(Object obj, LinkedList fieldNames, LinkedList fieldValues);

    /**
     * 把被封装成对象的一行数据插入到数据库中，sql语句在该方法中构造
     *
     * @param obj 封装成对象的一行数据，需要插入的对象
     * @return 返回布尔值（true表示插入成功）
     */
    boolean insert(Object obj);

    /**
     * 把被封装成对象的一行数据从数据库中删除，sql语句在该方法中构造
     *
     * @param obj 被封装成对象的一行数据，需要被删除的对象（即where条件）
     * @return 返回布尔值（true表示删除成功）
     */
    boolean delete(Object obj);

    /**
     * 根据传入的字段的值（where约束条件）和表名，从该表中更新一条记录，sql语句在该方法中构造
     *
     * @param obj        被封装成对象的新数据
     * @param methodName 执行update操作的方法名
     * @param fieldValue 传入的字段的值（where约束条件）
     * @return 返回布尔值（true表示更新成功）
     */
    boolean update(Object obj, String methodName, String fieldValue);

    /**
     * 通过传入的字段集（fields）、表名来查询数据库中的数据
     *
     * @param obj       被封装成对象的where约束条件
     * @param clazz     List集合泛型的具体类型
     * @param fields    传入的字段集，即要查询的字段
     * @param tableName 数据库表名
     * @return 返回List集合
     */
    List select(Object obj, Class clazz, String fields, String tableName);

    /**
     * 封装增、删、改操作的方法
     *
     * @param obj 传入的对象，用于设置占位符“？”
     * @param sql 传入的sql语句
     * @return 返回布尔值（返回true表示操作成功）
     */
    boolean executeUpdate(Object obj, String sql);

    /**
     * 封装查操作的方法
     *
     * @param obj   传入的对象，用于设置占位符“？”
     * @param clazz 返回的List集合的具体类型
     * @param sql   传入的sql语句
     * @return 返回List集合
     */
    List executeQuery(Object obj, Class clazz, String sql);

    /**
     * 设置占位符的通用方法
     *
     * @param obj 用于设置占位符的对象
     * @param ps  PreparedStatement对象
     */
    void setParams(Object obj, PreparedStatement ps);
}
