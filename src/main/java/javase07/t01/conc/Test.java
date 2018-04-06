package javase07.t01.conc;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

            ExecutorService ex = Executors.newCachedThreadPool();

            Future<Integer> s1 = ex.submit(new TransactionHandler(accounts,1, in));
            Future<Integer> s2 = ex.submit(new TransactionHandler(accounts,2, in));

            try {
                s1.get();
                s2.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println(accounts);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}