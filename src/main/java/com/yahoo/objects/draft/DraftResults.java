/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.draft;

import java.util.List;

/**
 *
 * @author cedric
 */
public class DraftResults 
{
    
  String count;
  List<DraftPick> draft_result;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<DraftPick> getDraft_result() {
        return draft_result;
    }

    public void setDraft_result(List<DraftPick> draft_result) {
        this.draft_result = draft_result;
    }
  
  
  
    
}
