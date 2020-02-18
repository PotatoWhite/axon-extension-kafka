package me.potato.cqrs.axonextensionkafka.events;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class MoneyAddedEvent {
    private String bankAccountId;
    private Long amount;
}
