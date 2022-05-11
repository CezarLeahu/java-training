package org.example.lombok;

import java.util.Objects;

public class CarInPlainJava {

    private int seats;
    private String color;
    private final String vin;

    public CarInPlainJava(String vin) {
        this.vin = vin;
    }

    public CarInPlainJava(int seats, String color, String vin) {
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
        CarInPlainJava that = (CarInPlainJava) o;
        return seats == that.seats && Objects.equals(color, that.color) && Objects.equals(vin, that.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seats, color, vin);
    }

    @Override
    public String toString() {
        return "CarInPlainJava{" +
            "seats=" + seats +
            ", color='" + color + '\'' +
            ", vin='" + vin + '\'' +
            '}';
    }
}
