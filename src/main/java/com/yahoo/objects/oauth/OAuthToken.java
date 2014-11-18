/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.oauth;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author DMDD
 */

@Entity
@Table(name = "OAuthToken")
public class OAuthToken implements Serializable
{
    private int id;
    private String token;
    private String verifier;
    private String secret;
    private String sessionHandle;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "ID", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "TOKEN", length=1000, nullable=false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "VERIFIER", length=300, nullable=false)
    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    @Column(name = "SECRET", length=300, nullable=false)
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Column(name = "SESSIONHANDLE", length=500, nullable=false)
    public String getSessionHandle() {
        return sessionHandle;
    }


    public void setSessionHandle(String sessionHandle) {
        this.sessionHandle = sessionHandle;
    }

    
}
