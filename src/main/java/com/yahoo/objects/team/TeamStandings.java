/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.team;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 *
 * @author cedric
 */
public class TeamStandings 
{
  private String rank;
  private TeamOutcome outcome_totals;
  private TeamStreak streak;
  private String points_for;
  private String points_against;

  private TeamDivisionalStandingsList divisional_outcome_totals;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public TeamOutcome getOutcome_totals() {
        return outcome_totals;
    }

    public void setOutcome_totals(TeamOutcome outcome_totals) {
        this.outcome_totals = outcome_totals;
    }

    public TeamStreak getStreak() {
        return streak;
    }

    public void setStreak(TeamStreak streak) {
        this.streak = streak;
    }

    public String getPoints_for() {
        return points_for;
    }

    public void setPoints_for(String points_for) {
        this.points_for = points_for;
    }

    public String getPoints_against() {
        return points_against;
    }

    public void setPoints_against(String points_against) {
        this.points_against = points_against;
    }

    public TeamDivisionalStandingsList getDivisional_outcome_totals() {
        return divisional_outcome_totals;
    }

    public void setDivisional_outcome_totals(TeamDivisionalStandingsList divisional_outcome_totals) {
        this.divisional_outcome_totals = divisional_outcome_totals;
    }


    public static class TeamOutcome {
        private String wins;
        private String losses;
        private String ties;
        private String percentage;

        public String getWins() {
            return wins;
        }

        public void setWins(String wins) {
            this.wins = wins;
        }

        public String getLosses() {
            return losses;
        }

        public void setLosses(String loses) {
            this.losses = loses;
        }

        public String getTies() {
            return ties;
        }

        public void setTies(String ties) {
            this.ties = ties;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }
         
        

    }

    public static class TeamStreak 
    {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        

    }
}
