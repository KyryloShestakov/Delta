package org.delta.bank.account;

import jakarta.inject.Inject;
import org.delta.bank.persons.Owner;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.account.AccountService;
public class BankAccountFactory {
    @Inject private AccountNumberGenerator accountNumberGenerator;

    public BaseBankAccount createBaseBankAccount(Owner owner, String bankAccountNumber, double balance) {
        String BankAccountNumber = this.accountNumberGenerator.generateAccountNumber();

        return new BaseBankAccount(owner, bankAccountNumber, balance);
    }
    public StudentBankAccount createStudentBankAccount(Owner owner, String bankAccountNumber, double balance) {
        String BankAccountNumber = this.accountNumberGenerator.generateAccountNumber();

        return new StudentBankAccount(owner, bankAccountNumber, balance);
    }
    public SaveBankAccount createSaveBankAccount(Owner owner, String bankAccountNumber, double balance) {
        String BankAccountNumber = this.accountNumberGenerator.generateAccountNumber();
        return  new SaveBankAccount(owner, bankAccountNumber,balance);
    }
}

