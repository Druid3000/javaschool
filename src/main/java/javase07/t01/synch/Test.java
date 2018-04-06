package javase07.t01.synch;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner in;
        try (FileReader fileReader = new FileReader("src/main/java/javase07/t01/synch/transactions.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            in = new Scanner(bufferedReader);

            List<Account> accounts = new ArrayList<Account>();
            accounts.add(new Account(4561,10_000));
            accounts.add(new Account(3122,10_000));
            accounts.add(new Account(9553,10_000));
            accounts.add(new Account(3684,10_000));
            accounts.add(new Account(3575,10_000));
            accounts.add(new Account(1476,10_000));
            accounts.add(new Account(6577,10_000));

            TransactionHandler transactionHandler1 = new TransactionHandler(accounts,1, in);
            TransactionHandler transactionHandler2 = new TransactionHandler(accounts,2, in);

            try {
                transactionHandler1.join();
                transactionHandler2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(accounts);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
