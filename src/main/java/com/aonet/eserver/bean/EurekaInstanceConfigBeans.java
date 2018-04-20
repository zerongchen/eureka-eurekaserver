package com.aonet.eserver.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("eureka.instance")
public class EurekaInstanceConfigBeans {

//        @Autowired
//        Environment ev ;

        private String appname = "UNKNOWN";

        public String getAppname() {
            return appname;
        }

        public void setAppname( String appname ) {
            this.appname = appname;
        }
}
