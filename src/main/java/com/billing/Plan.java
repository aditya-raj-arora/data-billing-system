package com.billing;

public enum Plan {
    BASIC(299.0, 2.0, 10.0),
    STANDARD(599.0, 5.0, 8.0),
    PREMIUM(999.0, 10.0, 6.0);

    private final double baseCost;
    private final double dataLimitGB;
    private final double extraRatePerGB;

    Plan(double baseCost, double dataLimitGB, double extraRatePerGB) {
        this.baseCost = baseCost;
        this.dataLimitGB = dataLimitGB;
        this.extraRatePerGB = extraRatePerGB;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getDataLimitGB() {
        return dataLimitGB;
    }

    public double getExtraRatePerGB() {
        return extraRatePerGB;
    }

    public static Plan fromString(String input) {
        for (Plan plan : Plan.values()) {
            if (plan.name().equalsIgnoreCase(input.trim())) {
                return plan;
            }
        }
        throw new IllegalArgumentException("Invalid plan type: " + input);
    }
}
