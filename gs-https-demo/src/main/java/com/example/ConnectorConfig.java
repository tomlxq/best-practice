package com.example;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/12
 */
@Configuration
public class ConnectorConfig {
    @Bean
    public TomcatServletWebServerFactory containerFactory() {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(8443);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("https");
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        /*
        TomcatServletWebServerFactory tomcat= new TomcatServletWebServerFactory() {
            @Override
            protected void customizeConnector(Connector connector) {
                int maxSize = 50000000;
                super.customizeConnector(connector);
                connector.setMaxPostSize(maxSize);
                connector.setMaxSavePostSize(maxSize);
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {

                    ((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
                    logger.info("Set MaxSwallowSize "+ maxSize);
                }
            }
        };
        tomcat.addAdditionalTomcatConnectors(getHttpConnector());*/
        return tomcat;
    }

    private Connector getHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }
}
