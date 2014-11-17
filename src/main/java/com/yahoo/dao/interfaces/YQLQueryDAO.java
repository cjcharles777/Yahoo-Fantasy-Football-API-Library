package com.yahoo.dao.interfaces;

import com.yahoo.objects.query.YQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cedric on 11/17/14.
 */


@Repository("yqlQueryDAO")
public interface YQLQueryDAO
{
    public void saveQuery(YQLQuery query);
    public void saveQueries(List<YQLQuery> listN);
    public List<YQLQuery> getQueries();
    public YQLQuery getQueryById(String queryId);
    public List<YQLQuery> retrieveQuerybyExample(YQLQuery query);
    public void deleteQuery(YQLQuery bw);
    public void clearQueries();
}
