package com.yahoo.dao.interfaces;

import com.yahoo.objects.oauth.OAuthToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cedric on 11/18/14.
 */

@Repository("oAuthDAO")
@Transactional
public interface OAuthDAO
{
    public void saveOAuthToken(OAuthToken oat);
    public OAuthToken getOAuthTokenById(int id);
    public void deleteOAuthToken(OAuthToken oat);
    public List<OAuthToken> getAllOAuth();
}

