package org.delta.bank;

import com.google.inject.AbstractModule;
import org.delta.bank.account.AccountService;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferFeeCalculator;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.moneyTransfer.validators.exceptions.AccountValidationException;
import org.delta.bank.persons.Owner;
import org.delta.bank.persons.OwnerFactory;
import org.delta.bank.print.ConsolePrintService;
import org.delta.bank.print.PrintInterface;
import org.delta.bank.print.PrintService;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure()
    {
     this.bind(PrintInterface.class).to(ConsolePrintService.class);
    }
}
