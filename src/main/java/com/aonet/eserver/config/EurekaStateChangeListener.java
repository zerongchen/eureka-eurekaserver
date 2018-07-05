package com.aonet.eserver.config;

import com.aonet.eserver.bean.EurekaInstanceConfigBeans;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EurekaInstanceConfigBeans beans;

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(appName);
        System.out.println(serverId);
        logger.info(appName);
        logger.info(serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);
        logger.info(""+instanceInfo);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {

    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        logger.info("++++++++++++++++++++++++++"+event+"==="+beans.getAppname());
    }
}

