package me.potato.cqrs.axonextensionkafka.config;

import org.axonframework.config.Configurer;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.extensions.kafka.KafkaProperties;
import org.axonframework.extensions.kafka.configuration.KafkaMessageSourceConfigurer;
import org.axonframework.extensions.kafka.eventhandling.KafkaMessageConverter;
import org.axonframework.extensions.kafka.eventhandling.consumer.Fetcher;
import org.axonframework.extensions.kafka.eventhandling.consumer.subscribable.SubscribableKafkaMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@ConditionalOnProperty(value="${axon.kafka.consumer.event-processor-mode}", havingValue = "SUBSCRIBING")
public class SubscribingConfiguration {
    @Bean
    public KafkaMessageSourceConfigurer kafkaMessageSourceConfigurer(Configurer configurer) {
        KafkaMessageSourceConfigurer kafkaMessageSourceConfigurer = new KafkaMessageSourceConfigurer();
        configurer.registerModule(kafkaMessageSourceConfigurer);
        return kafkaMessageSourceConfigurer;
    }

    @Autowired
    public Configurer registerKafkaMessageSourceConfigurer(Configurer configurer, KafkaMessageSourceConfigurer kafkaMessageSourceConfigurer){
        return configurer.registerModule(kafkaMessageSourceConfigurer);
    }

    @Bean
    public SubscribableKafkaMessageSource subscriibableKafkaMessageSource(
            KafkaProperties kafkaProperties,
            ConsumerFactory<String, byte[]> consumerFactory,
            Fetcher<String, byte[], EventMessage> fetcher,
            KafkaMessageConverter<String, byte[]> messageConverter,
            KafkaMessageSourceConfigurer kafkaMessageSourceConfigurer){
        SubscribableKafkaMessageSource messageSource = SubscribableKafkaMessageSource.<String, byte[]>builder()
                .addTopic(kafkaProperties.getDefaultTopic())
                .groupId("kafka-group")
                .consumerFactory(consumerFactory)
                .fetcher(fetcher)
                .messageConverter(messageConverter)
                .build();

        kafkaMessageSourceConfigurer.registerSubscribableSource(c->messageSource);

        return messageSource;
    }

}
