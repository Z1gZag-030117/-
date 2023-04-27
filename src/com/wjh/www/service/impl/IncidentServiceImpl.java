package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.IncidentDaoImpl;
import com.wjh.www.dao.IncidentDao;
import com.wjh.www.po.Collection;
import com.wjh.www.po.Incident;
import com.wjh.www.service.IncidentService;

import java.util.List;

/**
 * @author wjh
 */
public class IncidentServiceImpl implements IncidentService {
    private final IncidentDao incidentDao = new IncidentDaoImpl();

    @Override
    public boolean saveIncident(Incident incident) {
        return incidentDao.insertIncident(incident);
    }

    @Override
    public List<Incident> findListIncidents(Incident conditionIncident) {
        return incidentDao.listIncidents(conditionIncident);
    }

    @Override
    public List<Incident> findListCollectionIncidents(Collection conditionCollection) {
        return incidentDao.listCollectionIncidents(conditionCollection);
    }

    @Override
    public boolean removePublishIncident(Incident conditionIncident) {
        return incidentDao.deletePublishIncident(conditionIncident);
    }

    @Override
    public boolean modifyPlusOneLikeNum(Incident incident) {
        return incidentDao.updatePlusOneLikeNum(incident);
    }

    @Override
    public boolean modifyMinusOneLikeNum(Incident incident) {
        return incidentDao.updateMinusOneLikeNum(incident);
    }

    @Override
    public boolean modifyIncidentByPublisher(Incident incident, String publisher) {
        return incidentDao.updateIncidentByPublisher(incident, publisher);
    }
}
