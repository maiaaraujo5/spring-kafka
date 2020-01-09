package com.example.kafka.app.message;

import com.example.kafka.adapter.shared.MessageTO;
import com.example.kafka.app.port.KafkaPort;
import com.example.kafka.app.port.MessagePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Message implements MessagePort {

    @Autowired
    private KafkaPort kafkaPort;

    @Override
    public void process(MessageTO messageTO) {
       log.info("Processando mensagem");
       kafkaPort.send(messageTO);
    }
}
