package pl.sda.equals_hashcode;

public class Bike extends Vehicle{

    private String model;
    private Integer seats;
    private Integer bikeNr;

    public Bike(String model, Integer seats, Integer bikeNr) {
        this.model = model;
        this.seats = seats;
        this.bikeNr = bikeNr;
    }

    @Override
    public Integer getRegistrationNr() {
        return bikeNr;
    }
}
