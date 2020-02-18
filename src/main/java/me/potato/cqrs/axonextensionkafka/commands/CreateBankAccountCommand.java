package me.potato.cqrs.axonextensionkafka.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankAccountCommand {
    @TargetAggregateIdentifier
    private String bankAccountId;

    @Min(value = 0, message = "Overdraft limit must not be less then Zero")
    private Long overdraftLimit;
}


