//package com.example.test2;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.ajp.AbstractAjpProtocol;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Value;
//
//@Configuration
//public class ContainerConfig {
//
//    @Value("${tomcat.ajp.protocol}")
//    private String ajpProtocol;
//
//    @Value("${tomcat.ajp.port}")
//    private int ajpPort;
//
//    @Value("${tomcat.ajp.redirectport}")
//    private int redirectPort;
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//
//        tomcat.addAdditionalTomcatConnectors(createAjpConnector());
//
//        return tomcat;
//
//    }
//
//
//
//    private Connector createAjpConnector() {
//
//        Connector ajpConnector = new Connector(ajpProtocol);
//
//        ajpConnector.setPort(ajpPort);
//
//        ajpConnector.setSecure(false); ajpConnector.setAllowTrace(false);
//
//        ajpConnector.setScheme("http");
//
//        ajpConnector.setRedirectPort(redirectPort);
//
//        ((AbstractAjpProtocol<?>) ajpConnector.getProtocolHandler()).setSecretRequired(false);
//
//        return ajpConnector;
//
//    }
//
//}
