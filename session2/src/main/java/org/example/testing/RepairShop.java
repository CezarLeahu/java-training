package org.example.testing;

public class RepairShop {

    public int repairCost(String vehicleJson) {
        return 300;
    }

    public void fix(String vehicleJson) {
        System.out.println("Doing the necessary vehicle mechanical work...");
    }

    public void fixElectricalIssues(String vehicleJson) {
        System.out.println("Doing the necessary vehicle electrical work...");
    }
}
