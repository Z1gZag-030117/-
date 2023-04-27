package com.wjh.www.util;

/**
 * @author wjh
 */
public class StringUtils {
    /**
     * 方法名：isEmpty
     * 作用：用于判断字符串是否为空，为空返回true，否则返回false
     *
     * @param str 传入的字符串
     * @return 返回boolean值
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 用于po类对象一一对应的数据库表名
     *
     * @param obj 被传进来的po类对象
     * @return 返回字符串（表名）
     */
    public static String getTableName(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return obj.getClass().getSimpleName().toLowerCase();
        }
    }

    /**
     * 把po类中驼峰形式的属性（一一对应数据库中的字段）转化为数据库中的字段的命名形式
     *
     * @param field 传进来的po类属性
     * @return 返回数据库字段形式的字符串
     */
    public static String getDatabaseField(String field) {
        if (StringUtils.isEmpty(field)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(field);
        for (int i = 0; i < field.length(); i++) {
            if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
                sb.insert(i, "_");
                i++;
            }
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 在进行update操作的方法的名字使用where条件结尾，该方法就是为了获取数据库字段形式的where条件
     *
     * @param methodName 传进来的方法名
     * @return 返回数据库字段形式的where条件
     */
    public static String getFieldByMethodName(String methodName) {
        if (StringUtils.isEmpty(methodName)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(methodName);
        StringBuffer newSb = null;
        for (int i = 0; i < methodName.length(); i++) {
            if (sb.charAt(i) == 'B' && sb.charAt(i + 1) == 'y') {
                newSb = new StringBuffer(sb.substring(i + 2).toString());
            }
        }
        for (int i = 1; i < newSb.length(); i++) {
            if (newSb.charAt(i) >= 'A' && newSb.charAt(i) <= 'Z') {
                newSb.insert(i, "_");
                i++;
            }
        }
        return newSb.toString().toLowerCase();
    }

}
