package org.example.collections;

import java.util.Objects;

// A simple POJO properly implemented
public class Car {
    private int seats;
    private String color;
    private final String vin;

    public Car(int seats, String color, String vin) {
        this.seats = seats;
        this.color = color;
        this.vin = vin;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seats == car.seats && Objects.equals(color, car.color) && Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seats, color, vin);
    }

    @Override
    public String toString() {
        return "Car{" +
            "seats=" + seats +
            ", color='" + color + '\'' +
            ", vin='" + vin + '\'' +
            '}';
    }
}
