package me.potato.cqrs.axonextensionkafka.events;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SourceBankAccountDebitRejectedEvent {
    private String bankTransferId;
}
