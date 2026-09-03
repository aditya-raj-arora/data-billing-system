package com.billing;

public class Customer {
    private final String name;
    private final String id;
    private final Plan plan;
    private final double dataUsedGB;

    public Customer(String name, String id, Plan plan, double dataUsedGB) {
        this.name = name;
        this.id = id;
        this.plan = plan;
        this.dataUsedGB = dataUsedGB;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Plan getPlan() {
        return plan;
    }

    public double getDataUsedGB() {
        return dataUsedGB;
    }
}
