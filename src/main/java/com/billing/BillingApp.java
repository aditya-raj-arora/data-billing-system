package com.billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillCalculator calculator = new BillCalculator();
        List<Customer> customers = new ArrayList<>();

        System.out.print("Enter number of customers: ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Customer " + (i + 1) + " ---");
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Customer ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("Plan (BASIC/STANDARD/PREMIUM): ");
            Plan plan = Plan.fromString(scanner.nextLine());

            System.out.print("Data used (GB): ");
            double dataUsed = Double.parseDouble(scanner.nextLine().trim());

            customers.add(new Customer(name, id, plan, dataUsed));
        }

        System.out.println("\n===== BILL SUMMARY =====");
        for (Customer customer : customers) {
            double extraCharge = calculator.calculateExtraCharge(customer);
            double total = calculator.calculateTotalBill(customer);

            System.out.println("\nCustomer: " + customer.getName() + " (" + customer.getId() + ")");
            System.out.println("Plan: " + customer.getPlan());
            System.out.println("Data Used: " + customer.getDataUsedGB() + " GB");
            System.out.println("Data Limit: " + customer.getPlan().getDataLimitGB() + " GB");
            System.out.println("Base Cost: Rs. " + customer.getPlan().getBaseCost());
            System.out.println("Extra Usage Charge: Rs. " + extraCharge);
            System.out.println("Total Bill: Rs. " + total);
        }

        scanner.close();
    }
}
