package com.jeffcode.broker;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

public class BrokerServer {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(Boolean.TRUE);
        TransportConnector transportConnector = brokerService.addConnector("tcp://localhost:1234");
        brokerService.start();
    }
}
