package javase07.t01.synch;

import java.util.List;
import java.util.Scanner;

public class TransactionHandler extends Thread {
    private List<Account> accounts;
    private final Scanner in;
    private Account withdrawalAccount;
    private Account depositAccount;
    private int amount;

    public TransactionHandler(List<Account> accounts, int threadNumber, Scanner in) {
        super("Thread " + threadNumber);
        this.accounts = accounts;
        this.in = in;
        this.start();
    }

    private Account findAccount(int id) {
        for (Account x : accounts) {
            if (x.getId() == id) return x;
        }
        return null;
    }

    private void printInformationAboutTransaction(Account account) {
        System.out.println(this.getName() +
                ": -" + amount +
                " from " + account.getId() + "\n" +
                account.getId() + ": " + account.getBalance());
    }

    private boolean readInput() {
        synchronized (in) {

            if (in.hasNextInt()) withdrawalAccount = findAccount(in.nextInt());
            else return false;

            if (in.hasNextInt()) depositAccount = findAccount(in.nextInt());
            else return false;

            if (in.hasNextInt()) amount = in.nextInt();
            else return false;
        }
        return true;
    }

    @Override
    public void run() {
        while (readInput()) {

            withdrawalAccount.withdraw(amount);
            printInformationAboutTransaction(withdrawalAccount);

            depositAccount.deposit(amount);
            printInformationAboutTransaction(depositAccount);

            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
