package com.example;

<<<<<<< HEAD
=======
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

>>>>>>> commit all
/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/16
 */
public class RestTemplateTest {
<<<<<<< HEAD
=======
    /**
     * With no SSL configured, the following test fails as expected
     */
    @Test(expected = ResourceAccessException.class)
    public void whenHttpsUrlIsConsumed_thenException() {
        String urlOverHttps
                = "https://localhost:8443/httpclient-simple/api/bars/1";
        ResponseEntity<String> response
                = new RestTemplate().exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
    }

    @Test
    public void givenAcceptingAllCertificates_whenHttpsUrlIsConsumed_thenException()
            throws GeneralSecurityException {
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        DefaultHttpClient httpClient
                = (DefaultHttpClient) requestFactory.getHttpClient();
        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLSocketFactory sf = new SSLSocketFactory(
                acceptingTrustStrategy, ALLOW_ALL_HOSTNAME_VERIFIER);
        httpClient.getConnectionManager().getSchemeRegistry()
                .register(new Scheme("https", 8443, sf));

        String urlOverHttps
                = "https://localhost:8443/httpclient-simple/api/bars/1";
        ResponseEntity<String> response = new RestTemplate(requestFactory).
                exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
    }

    /**
     * The Spring RestTemplate with SSL (HttpClient 4.4)
     * @throws ClientProtocolException
     * @throws IOException
     */
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
        String urlOverHttps
                = "https://localhost:8443/httpclient-simple/api/bars/1";
        ResponseEntity<String> response
                = new RestTemplate(requestFactory).exchange(
                urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
    }
>>>>>>> commit all
}
