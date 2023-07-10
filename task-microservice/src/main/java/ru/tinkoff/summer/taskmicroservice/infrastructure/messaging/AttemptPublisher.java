package ru.tinkoff.summer.taskmicroservice.infrastructure.messaging;

import lombok.RequiredArgsConstructor;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import ru.tinkoff.summer.taskmicroservice.application.port.messaging.ExecutionPort;
import ru.tinkoff.summer.taskmicroservice.domain.Attempt;
import ru.tinkoff.summer.taskshareddomain.AttemptDTO;
import ru.tinkoff.summer.taskshareddomain.ConnectionConstants;

@Component
@RequiredArgsConstructor
public class AttemptPublisher implements ExecutionPort {

    private final KafkaTemplate<String, AttemptDTO> kafkaTemplate;

    @Override
    public void publishForExecute(Attempt attempt) {
        var dto = new AttemptDTO();
        dto.setCode(attempt.getCode());
        dto.setLanguage(attempt.getLanguage());
        kafkaTemplate.send(ConnectionConstants.ATTEMPT_TOPIC_NAME,dto );
    }
}
