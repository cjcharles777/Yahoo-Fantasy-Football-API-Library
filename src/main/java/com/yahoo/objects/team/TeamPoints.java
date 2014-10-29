package com.yahoo.objects.team;

/**
 * Created by cedric on 10/29/14.
 */
public class TeamPoints
{
    private String coverage_type;
    private String week;
    private String season;
    private String total;

    public String getCoverage_type() {
        return coverage_type;
    }

    public void setCoverage_type(String coverage_type) {
        this.coverage_type = coverage_type;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
