package javase07.t01.conc;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionHandler implements Callable<Integer> {
    private List<Account> accounts;
    private final Scanner in;
    private Account withdrawalAccount;
    private Account depositAccount;
    private int amount;
    private int threadNumber;
    private static Lock lock = new ReentrantLock();


    public TransactionHandler(List<Account> accounts, int threadNumber, Scanner in) {
        this.accounts = accounts;
        this.in = in;
        this.threadNumber = threadNumber;

    }

    private Account findAccount(int id) {
        for (Account x : accounts) {
            if (x.getId() == id) return x;
        }
        return null;
    }

    private boolean readInput() {
        try {
            lock.lock();
//            synchronized (in) {
            if (in.hasNextInt()) withdrawalAccount = findAccount(in.nextInt());
            else return false;

            if (in.hasNextInt()) depositAccount = findAccount(in.nextInt());
            else return false;

            if (in.hasNextInt()) amount = in.nextInt();
            else return false;
        }finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public Integer call()
    {
        while (readInput()) {

            try {
                lock.lock();
                withdrawalAccount.withdraw(amount);
                System.out.println("Thread " + threadNumber +
                        ": -" + amount +
                        " from " + withdrawalAccount.getId() + "\n" +
                        withdrawalAccount.getId() + ": " + withdrawalAccount.getBalance());

                depositAccount.deposit(amount);
                System.out.println("Thread " + threadNumber +
                        ": +" + amount +
                        " to " + depositAccount.getId() + "\n" +
                        depositAccount.getId() + ": " + depositAccount.getBalance());

            }finally {
                lock.unlock();
            }

            System.out.println();

            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return 1;
    }
}