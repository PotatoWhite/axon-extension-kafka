package me.potato.cqrs.axonextensionkafka.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepositMoneyCommand {
    @TargetAggregateIdentifier
    private String bankAccountId;
    private Long amountOfMoney;
}
