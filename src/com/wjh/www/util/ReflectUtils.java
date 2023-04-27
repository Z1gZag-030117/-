
package com.wjh.www.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

/*
通过反射获取对象的全部属性和全部方法
 */

/**
 * @author wjh
 */
public class ReflectUtils {
    /**
     * 通过反射获取传进来的对象拥有的全部方法
     *
     * @param obj 传进来的对象
     * @return 返回LinkedList<Method>集合
     */
    public static LinkedList<Method> getMethods(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> clazz = obj.getClass();
        LinkedList<Method> methods = new LinkedList<>();
        for (Class<?> cla = clazz; cla != Object.class; cla = cla.getSuperclass()) {
            methods.addAll(Arrays.asList(cla.getDeclaredMethods()));
        }
        return methods;
    }

    /**
     * 通过反射获取传进来的对象拥有的所有属性（包括私有属性）
     *
     * @param obj 传进来的对象
     * @return 返回LinkedList<Field>集合
     */
    public static LinkedList<Field> getFields(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> clazz = obj.getClass();
        LinkedList<Field> fields = new LinkedList<>();
        for (Class<?> cla = clazz; cla != Object.class; cla = cla.getSuperclass()) {
            fields.addAll(Arrays.asList(cla.getDeclaredFields()));
        }
        return fields;
    }
}
