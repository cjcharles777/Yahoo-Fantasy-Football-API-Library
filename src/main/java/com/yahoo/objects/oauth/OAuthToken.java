/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.oauth;


import java.io.Serializable;

/**
 *
 * @author DMDD
 */

public class OAuthToken implements Serializable
{
    private int id;
    private String token;
    private String verifier;
    private String secret;
    private String sessionHandle;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
    
    public String getSessionHandle() {
        return sessionHandle;
    }
    
    
    public void setSessionHandle(String sessionHandle) {
        this.sessionHandle = sessionHandle;
    }
    
    
    
}
