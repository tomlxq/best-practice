package com.example;

<<<<<<< HEAD
=======
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
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
public class qqq {
<<<<<<< HEAD
=======
    String urlOverHttps
            = "https://localhost:8082/httpclient-simple";
    public class RestClientLiveManualTest {
        /**
         * The SSLPeerUnverifiedException
         * @throws ClientProtocolException
         * @throws IOException
         */
        @Test(expected = SSLPeerUnverifiedException.class)
        public void whenHttpsUrlIsConsumed_thenException()
                throws ClientProtocolException, IOException {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            String urlOverHttps
                    = "https://localhost:8082/httpclient-simple";
            HttpGet getMethod = new HttpGet(urlOverHttps);

            HttpResponse response = httpClient.execute(getMethod);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        }

        /**
         * Configure SSL – Accept All (HttpClient < 4.3)
         * @throws GeneralSecurityException
         */
        @Test
        public final void givenAcceptingAllCertificates_whenHttpsUrlIsConsumed_thenOk()
                throws GeneralSecurityException {
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            CloseableHttpClient httpClient = (CloseableHttpClient) requestFactory.getHttpClient();

            TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
            SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy, ALLOW_ALL_HOSTNAME_VERIFIER);
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 8443, sf));
            String urlOverHttps
                    = "https://localhost:8082/httpclient-simple";
            ResponseEntity<String> response = new RestTemplate(requestFactory).
                    exchange(urlOverHttps, HttpMethod.GET, null, String.class);
            assertThat(response.getStatusCode().value(), equalTo(200));
        }

        /**
         * Configure SSL – Accept All (HttpClient 4.4 and Above)
         * @throws GeneralSecurityException
         */
        @Test
        public final void givenAcceptingAllCertificates_whenHttpsUrlIsConsumed_then44Ok()
                throws GeneralSecurityException {
            TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                    NoopHostnameVerifier.INSTANCE);

            Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory> create()
                            .register("https", sslsf)
                            .register("http", new PlainConnectionSocketFactory())
                            .build();

            BasicHttpClientConnectionManager connectionManager =
                    new BasicHttpClientConnectionManager(socketFactoryRegistry);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
                    .setConnectionManager(connectionManager).build();

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory(httpClient);
            ResponseEntity<String> response = new RestTemplate(requestFactory)
                    .exchange(urlOverHttps, HttpMethod.GET, null, String.class);
            assertThat(response.getStatusCode().value(), equalTo(200));
        }
    }
>>>>>>> commit all
}
