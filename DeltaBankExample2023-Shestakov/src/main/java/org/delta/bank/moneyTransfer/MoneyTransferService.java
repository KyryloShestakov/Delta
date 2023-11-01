package org.delta.bank.moneyTransfer;

import jakarta.inject.Inject;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.moneyTransfer.validators.SourceAccountValidationService;

public class MoneyTransferService {

    @Inject private SourceAccountValidationService sourceAccountValidationService;
    @Inject private MoneyTransferFeeCalculator moneyTransferFeeCalculator;
    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double value) throws Exception {

        double transferFee = this.moneyTransferFeeCalculator.calculateTransferFee(sourceAccount, value);
        double valueToSub = value + transferFee;

        this.sourceAccountValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, valueToSub);

        sourceAccount.subFromBalance(valueToSub);
        destinationAccount.addToBalance(value);
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double value) throws Exception {

        this.sourceAccountValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.subFromBalance(value);
    }
}
