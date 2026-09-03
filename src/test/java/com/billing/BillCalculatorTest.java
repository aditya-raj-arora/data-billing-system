package com.billing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BillCalculatorTest {

    private final BillCalculator calculator = new BillCalculator();

    @Test
    public void noExtraChargeWhenUnderLimit() {
        Customer customer = new Customer("Test", "C1", Plan.BASIC, 1.0);
        assertEquals(0.0, calculator.calculateExtraCharge(customer), 0.001);
    }

    @Test
    public void extraChargeAppliedWhenOverLimit() {
        Customer customer = new Customer("Test", "C2", Plan.BASIC, 5.0);
        double expected = (5.0 - Plan.BASIC.getDataLimitGB()) * Plan.BASIC.getExtraRatePerGB();
        assertEquals(expected, calculator.calculateExtraCharge(customer), 0.001);
    }

    @Test
    public void totalBillIncludesBaseCost() {
        Customer customer = new Customer("Test", "C3", Plan.STANDARD, 2.0);
        assertEquals(Plan.STANDARD.getBaseCost(), calculator.calculateTotalBill(customer), 0.001);
    }
}
