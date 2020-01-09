package com.example.kafka.app.port;

import com.example.kafka.adapter.shared.MessageTO;

public interface MessagePort {

    void process(MessageTO messageTO);
}
