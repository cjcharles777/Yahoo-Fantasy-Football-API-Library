package com.yahoo.utils.time;

import org.joda.time.DateTime;

import org.joda.time.Period;
import java.util.Date;

/**
 * Created by cedric on 11/18/14.
 */
public class TimeUtil
{
    public static boolean isDataStale(Date dateCreated, int daysOfFreshness)
    {
        DateTime datetimeRented = new DateTime(dateCreated);
        Period rentalPeriod = new Period().withDays(daysOfFreshness);
        return datetimeRented.plus(rentalPeriod).isBeforeNow();
    }
}
