package me.potato.cqrs.axonextensionkafka.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DestinationBankAccountCreditedEvent extends MoneyAddedEvent {
    private String bankTransferId;
}
