/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.utils.oauth;


import com.yahoo.dao.interfaces.OAuthDAO;
import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.oauth.OAuthToken;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.YahooApi;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */

@Repository("oauthConnection")
public class OAuthConnection 
{
    private OAuthService service;
    private Token requestToken ;
    private Verifier verifier;
    private Token accessToken;
    private String oauthSessionHandle;
    private String apiKey;
    private String apiSecret;
    private OAuthToken oAuthToken;
    boolean authorized = false;




    @Autowired
    private OAuthDAO oauthDAOImpl;
    
    public OAuthConnection()
    {

    }
  //  public OAuthConnection(YahooApiInfo info, OAuthToken oAuthToken)
  //  {
 //       initService(info);
  //      this.oAuthToken = oAuthToken;
 //       accessToken = new Token (oAuthToken.getToken(),oAuthToken.getSecret());
  //      verifier = new Verifier(oAuthToken.getVerifier());
  //      oauthSessionHandle = oAuthToken.getSessionHandle();
   //     authorized = true;
   // }

    public void initService(YahooApiInfo info)
    {
        //this.info = info;
        service = new ServiceBuilder()
                .provider(YahooApi.class)
                .apiKey(info.getApiKey())
                .apiSecret(info.getApiSecret())
                .build();
    }
    public void initService(YahooApiInfo info, String callBackUrl)
    {
        //this.info = info;
        service = new ServiceBuilder()
                .provider(YahooApi.class)
                .apiKey(info.getApiKey())
                .apiSecret(info.getApiSecret())
                .callback(callBackUrl)
                .build();
    }
    public boolean connect()
    {

        List<OAuthToken> prevList = oauthDAOImpl.getAllOAuth();
        if(prevList == null || prevList.isEmpty())
        {
            return false;

        }
        else
        {
            accessToken = new Token (prevList.get(0).getToken(),prevList.get(0).getSecret());
            verifier = new Verifier(prevList.get(0).getVerifier());
            oauthSessionHandle = prevList.get(0).getSessionHandle();
            authorized = true;
            return true;

        }
    }


    public String retrieveAuthorizationUrl()
    {
            System.out.println("=== Yahoo's OAuth Workflow ===");
            System.out.println();
            System.out.println("Fetching the Request Token...");
            requestToken = service.getRequestToken();
            System.out.println("Got the Request Token!");
            System.out.println();
            String authUrl = service.getAuthorizationUrl(requestToken);
            System.out.println(authUrl);
            return authUrl;
           // retrieveAccessToken(in.nextLine());
    }
    public boolean retrieveAccessToken(String token)
    {
        verifier = new Verifier(token);
            // Trade the Request Token and Verfier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
         try
         {
            accessToken = service.getAccessToken(requestToken, verifier);
            String fullResponse = accessToken.getRawResponse();
            System.out.println("[Raw Response] : " + fullResponse);


            // Gather the indices of the session handle
            int startIndex = fullResponse.indexOf("&oauth_session_handle=");
            int endIndex = fullResponse.indexOf("&oauth_authorization_expires_in", startIndex);

            oauthSessionHandle = fullResponse.substring(startIndex + 22, endIndex);
            System.out.println("[Session handle] :" + oauthSessionHandle);
        
            OAuthToken temp = new OAuthToken();
            temp.setVerifier(verifier.getValue());
            temp.setToken(accessToken.getToken());
            temp.setSecret(accessToken.getSecret());
            temp.setSessionHandle(oauthSessionHandle);
            oauthDAOImpl.saveOAuthToken(temp);
            authorized = true;
            return true;
         }
         catch(OAuthException E)
         {
             return false;
         }
    }
    
    public String requestData(String url, Verb v)
    {
        OAuthRequest request = new OAuthRequest(v, url);
        service.signRequest(accessToken, request); // the access token from step 4
        Response response = (Response) request.send();  
        if(!response.isSuccessful())
        {
            refreshToken();
            request = new OAuthRequest(v, url);
            service.signRequest(accessToken, request); // the access token from step 4
            response = (Response) request.send();  
        }
        return response.getBody();
    }
    
    public void refreshToken()
    {
         List<OAuthToken> prevList = oauthDAOImpl.getAllOAuth();
         String tempSessionHandle = prevList.get(0).getSessionHandle();
         
         connect();
         OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.login.yahoo.com/oauth/v2/get_token");
         request.addOAuthParameter("oauth_session_handle",oauthSessionHandle );
         service.signRequest(accessToken, request);
         Response response = request.send();
        try 
        {
            accessToken = YahooApi.class.newInstance().getAccessTokenExtractor().extract(response.getBody());
        } catch (InstantiationException ex) {
            Logger.getLogger(OAuthConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OAuthConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         accessToken = service.getAccessToken(accessToken, verifier);
         oauthDAOImpl.deleteOAuthToken(prevList.get(0));
         OAuthToken temp = new OAuthToken();
         temp.setVerifier(verifier.getValue());
         temp.setToken(accessToken.getToken());
         temp.setSecret(accessToken.getSecret());
         temp.setSessionHandle(oauthSessionHandle);
         oAuthToken = temp;
         
    }
      
    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }

    public String getOauthSessionHandle() {
        return oauthSessionHandle;
    }

    public void setOauthSessionHandle(String oauthSessionHandle) {
        this.oauthSessionHandle = oauthSessionHandle;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public OAuthToken getoAuthToken() {
        return oAuthToken;
    }

    public void setoAuthToken(OAuthToken oAuthToken) {
        this.oAuthToken = oAuthToken;
    }
}
