package com.jeffcode;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {
    public static void main(String[] args) throws JMSException {
        // 这个broker就是我么连接activeMQ的哪个实例，brokerUrl就是这个实例的地址
        ActiveMQConnectionFactory activeMQSender = new ActiveMQConnectionFactory("tcp://" +
                "192.168.10.128:61616");
        // 创建连接
        Connection connection = activeMQSender.createConnection();
        connection.start();
        // 创建会话
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE );
        // 创建队列名
        Destination destination = session.createQueue("my-queue");
        // 创建消息消费者
        MessageConsumer consumer = session.createConsumer(destination);
        // 获取到消息
        TextMessage receive = (TextMessage)consumer.receive();
        receive.acknowledge();
        String text = receive.getText();
        System.out.println(text);

        // 结束
        session.commit();
        session.close();
    }
}
