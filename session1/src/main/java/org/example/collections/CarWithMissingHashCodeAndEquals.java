package org.example.collections;

// A simple POJO without equals() or hashCode()
public class CarWithMissingHashCodeAndEquals {

    private int seats;
    private String color;
    private final String vin;

    public CarWithMissingHashCodeAndEquals(int seats, String color, String vin) {
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
    public String toString() {
        return "CarWithMissingHashCodeAndEquals{" +
            "seats=" + seats +
            ", color='" + color + '\'' +
            ", vin='" + vin + '\'' +
            '}';
    }
}
