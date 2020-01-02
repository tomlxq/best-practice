package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.net.URI;
import java.security.KeyStore;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHttps {
    @Test(expected = SSLPeerUnverifiedException.class)
    public void whenHttpsUrlIsConsumed_thenException()
            throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlOverHttps=WELCOME_URL;
        HttpGet getMethod = new HttpGet(urlOverHttps);

        HttpResponse response = httpClient.execute(getMethod);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }


    @Value("${trust.store}")
    private String trustStore;
    @Value("${trust.store.password}")
    private String trustStorePassword;
    private static final String WELCOME_URL = "https://www.tom.com:8443";

    RestTemplate restTemplate() throws Exception {
        System.out.println(trustStore);
        // keyStoreType is either "JKS" or "PKCS12"
        KeyStore keyStore = KeyStore.getInstance(null);
        keyStore.load(null, trustStorePassword.toCharArray());
        System.out.println(trustStorePassword);
        URI uri = URI.create(WELCOME_URL);
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(uri.toURL(), trustStorePassword.toCharArray())
                .build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    @Test
    public void whenGETanHTTPSResource_thenCorrectResponse() throws Exception {
        ResponseEntity<String> response =
                restTemplate().getForEntity(WELCOME_URL, String.class, Collections.emptyMap());

        assertEquals("<h1>Welcome to Secured Site</h1>", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
