package com.example;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/13
 */
public class RestClientLiveManualTest {

    //@Test(expected = SSLPeerUnverifiedException.class)
    public void whenHttpsUrlIsConsumed_thenException()
            throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlOverHttps
                = "https://localhost:8082/httpclient-simple";
        HttpGet getMethod = new HttpGet(urlOverHttps);

        HttpResponse response = httpClient.execute(getMethod);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }
}