package pl.sda.equals_hashcode;

public class Plane extends Vehicle {

    private String model;
    private Integer seats;
    private Integer planeNr;

    public Plane(String model, Integer seats, Integer planeNr) {
        this.model = model;
        this.seats = seats;
        this.planeNr = planeNr;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if(!other.getClass().equals(this.getClass())){
            return false;
        }
        if (((Plane)other).getRegistrationNr().equals(this.planeNr)) {
            return true;
        }
        return false;
    }

    public int hashCode(){
        return this.planeNr;
    }

    @Override
    public Integer getRegistrationNr() {
        return planeNr;
    }
}
