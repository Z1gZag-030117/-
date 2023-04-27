package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.CirclesDaoImpl;
import com.wjh.www.dao.CirclesDao;
import com.wjh.www.po.Circles;
import com.wjh.www.service.CirclesService;

import java.util.List;

/**
 * @author wjh
 */
public class CirclesServiceImpl implements CirclesService {

    private final CirclesDao circlesDao = new CirclesDaoImpl();

    @Override
    public List<Circles> findListCircles() {
        return circlesDao.listCircles();
    }

    @Override
    public boolean saveCircle(Circles circles) {
        return circlesDao.insertCircle(circles);
    }

    @Override
    public boolean removeCircle(Circles conditionCircle) {
        return circlesDao.deleteCircle(conditionCircle);
    }
}
