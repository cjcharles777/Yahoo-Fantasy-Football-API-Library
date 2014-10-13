/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.league;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cedric
 */
public class StatCategoriesObj
{
    public List<StatCategory> stat;

    public List<StatCategory> getStat() {
        return stat;
    }

    public void setStat(List<StatCategory> stat) {
        this.stat = stat;
    }

    public Map<String, StatCategory> getStatCategoryMap()
    {
        Map<String, StatCategory> result = new HashMap<String, StatCategory>();
        for(StatCategory tempStatCategory : stat)
        {
            result.put(tempStatCategory.getStat_id(), tempStatCategory);
        }
        return result;
    }
}
