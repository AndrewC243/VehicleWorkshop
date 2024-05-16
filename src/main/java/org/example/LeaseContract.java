package org.example;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String custoemrEmail, Vehicle vehicleSold) {
        super(date, customerName, custoemrEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        return (getMonthlyPayment() * 36) + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        return getVehicleSold().getPrice() * .04 / 12;
    }

    public double getExpectedEndingValue() { return getVehicleSold().getPrice() / 2; }
    public double getLeaseFee() { return getVehicleSold().getPrice() * .07; }
}