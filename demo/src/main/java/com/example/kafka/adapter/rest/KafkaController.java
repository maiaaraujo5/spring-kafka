package com.example.kafka.adapter.rest;

import com.example.kafka.adapter.shared.MessageTO;
import com.example.kafka.app.port.MessagePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private MessagePort messagePort;

    @PostMapping("/produce")
    public void produceMessage(@RequestBody MessageTO messageTO){
        log.info("Recebendo mensagem para processar");
        messagePort.process(messageTO);
    }
}
