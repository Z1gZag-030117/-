package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.CollectionDaoImpl;
import com.wjh.www.dao.CollectionDao;
import com.wjh.www.po.Collection;
import com.wjh.www.service.CollectionService;

/**
 * @author wjh
 */
public class CollectionServiceImpl implements CollectionService {
    private final CollectionDao collectionDao = new CollectionDaoImpl();

    @Override
    public boolean findIsExistCollection(Collection conditionCollection) {
        return collectionDao.getIsExistCollection(conditionCollection);
    }

    @Override
    public boolean saveCollection(Collection collection) {
        return collectionDao.insertCollectionIncident(collection);
    }

    @Override
    public boolean removeCollectionIncident(Collection conditionCollection) {
        return collectionDao.deleteCollectionIncident(conditionCollection);
    }

    @Override
    public boolean modifyCollectionByCollector(Collection collection, String collector) {
        return collectionDao.updateCollectionByCollector(collection, collector);
    }
}
