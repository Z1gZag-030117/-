package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.CirclesDao;
import com.wjh.www.po.Circles;

import java.util.List;

public class CirclesDaoImpl implements CirclesDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Circles.class.getAnnotation(Table.class).value();

    @Override
    public List<Circles> listCircles() {
        String fields = "circle_name,create_time,circle_admin,circle_description";
        return (List<Circles>) baseDao.select(null, Circles.class, fields, TABLE_NAME);
    }

    @Override
    public boolean deleteCircle(Circles conditionCircle) {
        return baseDao.delete(conditionCircle);
    }

    @Override
    public boolean insertCircle(Circles circles) {
        return baseDao.insert(circles);
    }
}
