package me.potato.cqrs.axonextensionkafka.config;

import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.extensions.kafka.eventhandling.consumer.streamable.StreamableKafkaMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "${axon.kafka.consumer.event-processor-mode}", havingValue = "TRACKING")
public class TrackingConfiguration {

    @Autowired
    public void configure(EventProcessingConfigurer configurer, StreamableKafkaMessageSource<String, byte[]> streamableKafkaMessageSource) {
        configurer.registerTrackingEventProcessor("kafka-group", c -> streamableKafkaMessageSource);
    }
}
