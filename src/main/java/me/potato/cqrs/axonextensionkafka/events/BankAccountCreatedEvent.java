package me.potato.cqrs.axonextensionkafka.events;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountCreatedEvent {
    private String bankAccountId;
    private Long overdraftLimit;
}
