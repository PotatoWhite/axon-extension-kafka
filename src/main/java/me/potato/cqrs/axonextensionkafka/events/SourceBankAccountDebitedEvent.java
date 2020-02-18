package me.potato.cqrs.axonextensionkafka.events;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SourceBankAccountDebitedEvent extends MoneySubtractedEvent  {
    private String bankTransferId;
}
