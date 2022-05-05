package org.example.interfaces;

import org.junit.jupiter.api.Test;

public class TestInterfaces {

    @Test
    public void createSomeVehicles(){

        Vehicle v = new Rubicon();
        MotorVehicle mv = new Rubicon();
        OffRoadVehicle ov = new Rubicon();

        ElecticVehicle ev = new ModelS();
        ElecticVehicle hv = new Prius();
        MotorVehicle   mv2 = new Prius();
    }

    @Test
    public void callSomeVehicleMethods() {
        refuelVehicle(new Goldwing());
        refuelVehicle(new Golf());
        refuelVehicle(new Rubicon());
        refuelVehicle(new ChevyTruck());
        refuelVehicle(new Prius());

        rechargeVehicle(new Prius());
        rechargeVehicle(new ModelS());

        deductTax(new ChevyTruck());

        runVehicle(new Prius());
        runVehicleOffRoad(new Rubicon());
    }

    private static void rechargeVehicle(ElecticVehicle v){
        v.recharge();
    }

    private static void refuelVehicle(MotorVehicle v) {
        v.refuel();
    }

    private static void runVehicle(Vehicle v) {
        v.run();
    }

    private static void runVehicleOffRoad(OffRoadVehicle v) {
        v.deflateTyres();
        v.run();
    }

    private static void loadVehicleCargo(Truck v) {
        v.loadCargo();
    }

    private static void deductTax(ClassicVehicle v) {
        v.taxDeduction();
    }
}
