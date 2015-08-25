package com.yahoo.dao.implementation;

import com.yahoo.dao.interfaces.OAuthDAO;
import com.yahoo.objects.oauth.OAuthToken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cedric on 11/18/14.
 */
@Repository("oAuthDAO")
public class OAuthDAOImpl implements OAuthDAO {


    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Transactional(readOnly = false)
    public void saveOAuthToken(OAuthToken oat) {
        hibernateTemplate.saveOrUpdate(oat);
    }

    public OAuthToken getOAuthTokenById(int id) {
        return hibernateTemplate.get(OAuthToken.class, id);
    }

    @Transactional(readOnly = false)
    public void deleteOAuthToken(OAuthToken oat) {
        hibernateTemplate.delete(oat);
    }

    @SuppressWarnings("unchecked")
    public List<OAuthToken> getAllOAuth()
    {
        return (List<OAuthToken>) hibernateTemplate.find("from "
                + OAuthToken.class.getName());
    }
}
