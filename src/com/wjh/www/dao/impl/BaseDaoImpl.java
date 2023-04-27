package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

import static com.wjh.www.util.ReflectUtils.getFields;
import static com.wjh.www.util.ReflectUtils.getMethods;
import static com.wjh.www.view.Main.connectionPool;


/**
 * @author wjh
 */
public class BaseDaoImpl implements BaseDao {

    @Override
    public void fieldMapper(Object obj, LinkedList fieldNames, LinkedList fieldValues) {
        if (obj == null) {
            return;
        }
        /*
         * 取出包括父类在内的所有方法和属性
         */
        LinkedList<Method> methods = getMethods(obj);
        LinkedList<Field> fields = getFields(obj);
        System.out.println("fields的长度："+fields.size());
        for (Field field : fields) {
            /*
             * 取出每个属性的值
             */
            for (Method method : methods) {
                /*
                如果方法是get开头，就使用invoke方法来调用该对象的getXXX()方法来获取对应属性并赋值给value
                 */
                if (method.getName().startsWith("get") && method.getName().substring(3).equalsIgnoreCase(field.getName())) {
                    Object value = null;
                    try {
                        value = method.invoke(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    /**
                     * 只添加不为null值的字段
                     */
                    if (value != null) {
                        /*
                          取出该属性的名称和对应的值，映射成数据库字段名和值，填充进fieldNames和fieldValues链表
                         */
                        fieldNames.add(field.getAnnotation(Column.class).value());
                        fieldValues.add(value);
                    }
                }
            }
        }
    }

    @Override
    public boolean insert(Object obj) {
        if (obj == null) {
            return false;
        }
        /*
        把传入的对象的非空的字段值映射成数据库表的字段和值
         */
        LinkedList<Object> fieldNames = new LinkedList<>();
        LinkedList<Object> fieldValues = new LinkedList<>();
        fieldMapper(obj, fieldNames, fieldValues);
        /*
        组建sql语句
         */
        StringBuilder sql = new StringBuilder("INSERT INTO " + obj.getClass().getAnnotation(Table.class).value() + "(");
        for (Object fieldName : fieldNames) {
            sql.append(fieldName.toString() + ",");
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" VALUES(");
        for (int i = 0; i < fieldNames.size(); i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');
        System.out.println(sql);
        return executeUpdate(obj, sql.toString());
    }

    @Override
    public boolean delete(Object obj) {
        if (obj == null) {
            return false;
        }
         /*
        把传入的对象的非空的字段值映射成数据库表的字段和值
         */
        LinkedList<Object> fieldNames = new LinkedList<>();
        LinkedList<Object> fieldValues = new LinkedList<>();
        fieldMapper(obj, fieldNames, fieldValues);
        /*
        组建sql语句
         */
        StringBuilder sql = new StringBuilder("DELETE FROM " + obj.getClass().getAnnotation(Table.class).value() + " WHERE ");
        for (Object fieldName : fieldNames) {
            sql.append(fieldName.toString() + " = ? AND ");
        }
        System.out.println(sql.substring(0, sql.length() - 4).toString());
        return executeUpdate(obj, sql.substring(0, sql.length() - 4).toString());
    }

    @Override
    public boolean update(Object obj, String methodName, String fieldValue) {
        if (obj == null) {
            return false;
        }
         /*
        把传入的对象的非空的字段值映射成数据库表的字段和值
         */
        LinkedList<Object> newFieldNames = new LinkedList<>();
        LinkedList<Object> newFieldValues = new LinkedList<>();
        fieldMapper(obj, newFieldNames, newFieldValues);
        /*
        组建sql语句
         */
        StringBuilder sql = new StringBuilder("UPDATE " + obj.getClass().getAnnotation(Table.class).value() + " SET ");
        for (Object newFieldName : newFieldNames) {
            sql.append(newFieldName.toString() + " = ?,");
        }
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("WHERE " + StringUtils.getFieldByMethodName(methodName) + "= '" + fieldValue + "'");
        System.out.println(sql);
        return executeUpdate(obj, sql.toString());
    }

    @Override
    public List select(Object obj, Class clazz, String fields, String tableName) {
        StringBuilder sql;
        if (obj == null) {
            /*
            如果传入的obj为null，也就是没有where条件的约束，就组建查询该表所有数据的sql
             */
            sql = new StringBuilder("SELECT " + fields + " FROM " + tableName);
            System.out.println("sql...是：" + sql.toString());
            /*
            返回查询的结果集（List集合）
             */
            return executeQuery(obj, clazz, sql.toString());
        } else {
             /*
               把传入的对象的非空的字段值映射成数据库表的字段和值
            */
            LinkedList<Object> fieldNames = new LinkedList<>();
            LinkedList<Object> fieldValues = new LinkedList<>();
            fieldMapper(obj, fieldNames, fieldValues);
            /*
            组建sql语句（带where条件的）
             */
            sql = new StringBuilder("SELECT " + fields + " FROM " + tableName + " WHERE ");
            for (Object fieldName : fieldNames) {
                sql.append(fieldName.toString() + " = ? AND ");
            }
            System.out.println("sql是：" + sql.substring(0, sql.length() - 4).toString());
        }
        return executeQuery(obj, clazz, sql.substring(0, sql.length() - 4).toString());
    }

    @Override
    public boolean executeUpdate(Object obj, String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            /*
           获取数据库连接（从连接池中取出即可）
           */
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(sql);
            /*
            设置占位符
             */
            if (obj != null) {
                setParams(obj, ps);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.returnConnection(conn);
        }
        return false;
    }

    @Override
    public List executeQuery(Object obj, Class clazz, String sql) {
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        LinkedList list = new LinkedList<>();
        try {
            /*
            获取数据库连接(从连接池中取出即可)
           */
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(sql);
            /*
            设置占位符
             */
            if (obj != null) {
                setParams(obj, ps);
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            /*
            找出returnObj（被返回的一个对象）的setXXX方法
             */
            LinkedList<Method> methods = getMethods(clazz.newInstance());
            /*
            获取查询到数据的总行数
             */
            int colCount = md.getColumnCount();
            /*
            定义用于存放setXXX方法的数组
             */
            String[] setters = new String[colCount + 1];
            /*
            存放查到的字段名的数组
             */
            String[] columns = new String[colCount + 1];
            for (int i = 0; i < colCount; i++) {
                columns[i] = md.getColumnLabel(i + 1);
                /*
                 取得字段名并映射为setter方法名，忽略大小写,存在setters数组中
                 */
                String[] split = md.getColumnLabel(i + 1).split("_");
                StringBuilder setter = new StringBuilder("set");
                for (String s : split) {
                    setter.append(s);
                }
                setters[i] = setter.toString();
            }

            while (rs.next()) {
                /*
                被返回的一个对象
                 */
                Object returnObj = clazz.newInstance();
                for (int i = 0; i < colCount; i++) {
                   /*
                   遍历该对象用于的所有方法
                    */
                    for (Method method : methods) {
                        /*
                        找出returnObj中和setters数组中的方法名匹配（忽略大小写）的setXXX方法，然后调用该setXXX方法给returnObj对应的属性赋值（数据库中字段的值）
                         */
                        if (method.getName().equalsIgnoreCase(setters[i])) {
                            /*
                            调用setXXX方法给该returnObj的和查到的字段对应的属性赋值
                             */
                            method.invoke(returnObj, rs.getObject(columns[i]));
                        }
                    }
                }
                /*
                把被返回的一个对象装进List集合
                 */
                list.add(returnObj);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            connectionPool.returnConnection(conn);
        }
        return list;
    }

    @Override
    public void setParams(Object obj, PreparedStatement ps) {
        /*
        把传入的对象的非空的字段值映射成数据库表的字段和值
         */
        LinkedList fieldNames = new LinkedList();
        LinkedList fieldValues = new LinkedList();
        fieldMapper(obj, fieldNames, fieldValues);
        Object[] params = fieldValues.toArray();
        for (int i = 0; i < params.length; i++) {
            try {
                ps.setObject(i + 1, params[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
