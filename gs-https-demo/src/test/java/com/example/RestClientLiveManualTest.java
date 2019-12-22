package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/18
 */
public class RestClientLiveManualTest {

    @Test
    public void whenHttpsUrlIsConsumed_thenException()
            throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlOverHttps
                = "https://www.tom.com:8443/";
        HttpGet getMethod = new HttpGet(urlOverHttps);

        HttpResponse response = httpClient.execute(getMethod);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    public void givenAcceptingAllCertificatesUsing4_4_whenUsingRestTemplate_thenCorrect()
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        URI urlOverHttps = URI.create("https://www.tom.com:8443/");
        ;
        ResponseEntity<String> response
                = new RestTemplate(requestFactory).exchange(
                urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
    }
}
