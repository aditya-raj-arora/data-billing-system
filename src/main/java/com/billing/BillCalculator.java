package com.billing;

public class BillCalculator {

    public double calculateExtraCharge(Customer customer) {
        Plan plan = customer.getPlan();
        double excess = customer.getDataUsedGB() - plan.getDataLimitGB();
        if (excess <= 0) {
            return 0.0;
        }
        return excess * plan.getExtraRatePerGB();
    }

    public double calculateTotalBill(Customer customer) {
        return customer.getPlan().getBaseCost() + calculateExtraCharge(customer);
    }
}
