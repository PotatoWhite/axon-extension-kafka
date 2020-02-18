package me.potato.cqrs.axonextensionkafka.events;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class MoneySubtractedEvent {
    private String bankAccountId;
    private Long amount;
}
