package com.yahoo.dao.implementation;

import com.yahoo.dao.interfaces.YQLQueryDAO;
import com.yahoo.objects.query.YQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cedric on 11/17/14.
 */

@Repository("yqlQueryDAO")
@Transactional
public class YQLQueryDAOImpl implements YQLQueryDAO
{
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveQuery(YQLQuery query)
    {
        hibernateTemplate.saveOrUpdate(query);
    }

    @Override
    public void saveQueries(List<YQLQuery> listN)
    {
        hibernateTemplate.saveOrUpdateAll(listN);
    }

    @Override
    public List<YQLQuery> getQueries() {
        return (List<YQLQuery>) hibernateTemplate.find("from "
                + YQLQuery.class.getName());
    }

    @Override
    public YQLQuery getQueryById(String queryId) {
        return hibernateTemplate.get(YQLQuery.class, queryId);
    }

    @Override
    public List<YQLQuery> retrieveQuerybyExample(YQLQuery query) {
        return (List<YQLQuery>) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(YQLQuery.class)
                        .add(Example.create(query)));
    }

    @Override
    public void deleteQuery(YQLQuery query) {
        hibernateTemplate.delete(query);
    }

    @Override
    public void clearQueries()
    {
        hibernateTemplate.deleteAll(hibernateTemplate.loadAll(YQLQuery.class));

    }
}
