package org.example.testing;

public class CarDealership {
    private BodyShop bodyShop = new BodyShop();
    private RepairShop repairShop = new RepairShop();

    public int repairCost(String vehicleJson) {
        return bodyShop.repairCost(vehicleJson) + repairShop.repairCost(vehicleJson);
    }

    public void fixVehicle(String vehicleJson) {
        bodyShop.fix(vehicleJson);
        repairShop.fix(vehicleJson);
        repairShop.fixElectricalIssues(vehicleJson);
    }
}
