package org.delta.bank;
import com.google.inject.Injector;
import com.google.inject.Guice;

public class Main {

    public static void main(String[] args) {

        try {
              Injector injector = Guice.createInjector(new BankInjector());
              Bank bank = injector.getInstance(Bank.class);
              bank.run();
        } catch (Exception e) {
          System.out.println("Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}