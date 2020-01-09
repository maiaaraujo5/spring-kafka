package com.example.kafka.adapter.kafka;

import com.example.kafka.adapter.shared.MessageTO;
import com.example.kafka.app.port.KafkaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Producer implements KafkaPort {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(MessageTO messageTo) {
        final String messageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, messageKey, messageTo);
    }
}
