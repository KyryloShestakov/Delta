package org.delta.bank.account;
import jakarta.inject.Inject;
import org.delta.bank.persons.Owner;
import org.delta.bank.print.PrintService;
import java.util.Map;
 public class AccountService {
     private Map<String, BaseBankAccount> accounts;
    @Inject private PrintService printService;
    @Inject private BankAccountFactory bankAccountFactory;
    public AccountService(){};
    public BaseBankAccount createAndStoryNewBankAccount(Owner owner,String bankAccountNumber,double balance){
        BaseBankAccount bankAccount = bankAccountFactory.createBaseBankAccount(owner,bankAccountNumber,balance);
        this.accounts.put(bankAccount.getBankAccountNumber(),bankAccount);
        this.printService.printBankAccountBalance(bankAccount);

        return bankAccount;
    }
}
