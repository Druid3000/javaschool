package javase07.t01.conc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int id;
    private int balance;
    private static Lock lock = new ReentrantLock();

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        try {
            lock.lock();
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(int amount) {
        try {
            lock.lock();
            balance = balance + amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        try {
            lock.lock();
            balance = balance - amount;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        return balance == account.balance;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + balance;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}