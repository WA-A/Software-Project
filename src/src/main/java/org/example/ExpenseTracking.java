package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class ExpenseTracking {
    private static final Logger logger = Logger.getLogger(ExpenseTracking.class.getName());
    private ArrayList<Expense> scanif;
    private Scanner scanner;

    public ExpenseTracking() {
        this.scanif = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addExpenseFromConsole() {
        logger.info("Enter expense details:");
        logger.info("Description: ");
        String description = scanner.nextLine();
        logger.info("Category: ");
        String category = scanner.nextLine();
        logger.info("Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        logger.info("Payee (optional): ");
        String payee = scanner.nextLine();

        Expense expense = new Expense(description, category, amount, payee);
        scanif.add(expense);
        logger.info("Expense added successfully!");
    }

    public void displayExpenses() {
        for (Expense expense : scanif) {
            logger.info("Description: " + expense.getDescription());
            logger.info("Category: " + expense.getCategory());
            logger.info("Amount: " + expense.getAmount());
            logger.info("Payee: " + expense.getPayee());
            logger.info("");
        }
    }

    public static void main(String[] args) {
        ExpenseTracking tracker = new ExpenseTracking();
        Scanner scanner = new Scanner(System.in);

        // Adding expenses from console input
        char addMore;
        do {
            tracker.addExpenseFromConsole();
            logger.info("Add another expense? (y/n): ");
            addMore = scanner.nextLine().charAt(0);
        } while (addMore == 'y' || addMore == 'Y');

        // Displaying all expenses
        tracker.displayExpenses();
    }
}

class Expense {
    private String description;
    private String category;
    private String payee;
    private int amount;

    public Expense(String description, String category, int amount, String payee) {
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.payee = payee;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPayee() {
        return payee;
    }

    public int getAmount() {
        return amount;
    }
}
