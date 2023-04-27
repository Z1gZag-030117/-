package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.IncidentDao;
import com.wjh.www.po.Collection;
import com.wjh.www.po.Incident;

import java.util.List;

/**
 * @author wjh
 */
public class IncidentDaoImpl implements IncidentDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Incident.class.getAnnotation(Table.class).value();

    @Override
    public boolean insertIncident(Incident incident) {
        return baseDao.insert(incident);
    }

    @Override
    public List<Incident> listIncidents(Incident conditionIncident) {
        String fields = "incident_title,incident_content,publisher,publish_time,like_num,belong_circle";
        return (List<Incident>) baseDao.select(conditionIncident, Incident.class, fields, TABLE_NAME);
    }

    @Override
    public List<Incident> listCollectionIncidents(Collection conditionCollection) {
        String sql = "SELECT collection.incident_title,collector,incident_content,publisher,publish_time,belong_circle FROM collection INNER JOIN incident ON collection.incident_title=incident.incident_title WHERE collector=?";
        List<Incident> incidentList = baseDao.executeQuery(conditionCollection, Incident.class, sql);
        return incidentList;
    }

    @Override
    public boolean deletePublishIncident(Incident conditionIncident) {
        return baseDao.delete(conditionIncident);
    }

    @Override
    public boolean updatePlusOneLikeNum(Incident incident) {
        String sql = "UPDATE incident SET like_num=(like_num+1) WHERE incident_title=?";
        return baseDao.executeUpdate(incident, sql);
    }

    @Override
    public boolean updateMinusOneLikeNum(Incident incident) {
        String sql = "UPDATE incident SET like_num=(like_num-1) WHERE incident_title=?";
        return baseDao.executeUpdate(incident, sql);
    }

    @Override
    public boolean updateIncidentByPublisher(Incident incident, String publisher) {
        return baseDao.update(incident, Thread.currentThread().getStackTrace()[1].getMethodName(), publisher);
    }
}
