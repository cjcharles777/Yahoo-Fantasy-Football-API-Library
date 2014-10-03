package com.yahoo.objects.api;

/**
 * Created by cedric on 10/3/14.
 */
public class YahooApiInfo
{
    private String apiKey;
    private String apiSecret;

    public YahooApiInfo(String apiKey, String apiSecret)
    {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
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
}
