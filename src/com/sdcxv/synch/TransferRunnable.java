package com.sdcxv.synch;

import java.util.Random;

/**
 * A runnable that transfers money from an account to other accounts in a bank.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-08-01
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    /**
     * Constructs a transfer runnable.
     *
     * @param b    the bank between whose account money is transferred
     * @param from the account to transfer money from
     * @param max  the maximum amount of money in each transfer
     */
    public TransferRunnable(Bank b, int from, double max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int toAccount = random.nextInt(bank.size());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep(random.nextInt(DELAY));
            }
        } catch (InterruptedException e) {
        }
    }
}
