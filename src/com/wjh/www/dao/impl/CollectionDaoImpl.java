package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.CollectionDao;
import com.wjh.www.po.Collection;

import java.util.List;


/**
 * @author wjh
 */
public class CollectionDaoImpl implements CollectionDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Collection.class.getAnnotation(Table.class).value();

    @Override
    public boolean getIsExistCollection(Collection conditionCollection) {
        String fields = "incident_title";
        List<Collection> collectionList = baseDao.select(conditionCollection, Collection.class, fields, TABLE_NAME);
        return collectionList.size() > 0;
    }

    @Override
    public boolean insertCollectionIncident(Collection collection) {
        return baseDao.insert(collection);
    }

    @Override
    public boolean deleteCollectionIncident(Collection conditionCollection) {
        return baseDao.delete(conditionCollection);
    }

    @Override
    public boolean updateCollectionByCollector(Collection collection, String collector) {
        return baseDao.update(collection, Thread.currentThread().getStackTrace()[1].getMethodName(), collector);
    }
}
