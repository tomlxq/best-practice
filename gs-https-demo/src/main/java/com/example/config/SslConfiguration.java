package com.example.config;

import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/20
 */
@Configuration
public class SslConfiguration {
    /*@Value("${http.client.ssl.trust-store}")
    private Resource keyStore;
    @Value("${http.client.ssl.trust-store-password}")
    private String keyStorePassword;


    @Value("${http.client.ssl.trust-store}")
    private Resource trustStore;
    @Bean
    RestTemplate restTemplate() throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadKeyMaterial(
                keyStore.getFile(),
                keyStorePassword.toCharArray(),
                keyStorePassword.toCharArray())

                .loadTrustMaterial(
                        keyStore.getURL(),
                        keyStorePassword.toCharArray()
                ).build();
        SSLConnectionSocketFactory socketFactory =
                new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }*/
}