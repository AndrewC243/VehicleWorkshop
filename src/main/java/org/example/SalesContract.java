package org.example;


public class SalesContract extends Contract {
    private boolean financed;

    public SalesContract(String date, String customerName, String custoemrEmail, Vehicle vehicleSold, boolean financed) {
        super(date, customerName, custoemrEmail, vehicleSold);
        this.financed = financed;
    }

    @Override
    public double getTotalPrice() {
        return getSalesTax() + getRecordingFee() + getProcessingFee() + getVehicleSold().getPrice();
    }

    @Override
    public double getMonthlyPayment() {
        if (!financed) return 0;
        var price = getVehicleSold().getPrice();
        if (price >= 10000)
            return (price * 0.0425 / 12) + (price / 48);
        return (price * 0.0525 / 12) + (price / 24);
    }

    @Override
    public String toString() {
        return "SALE|"
                + getDate() + "|"
                + getCustomerName() + "|"
                + getCustoemrEmail() + "|"
                + getVehicleSold().getVin() + "|"
                + getVehicleSold().getYear() + "|"
                + getVehicleSold().getMake() + "|"
                + getVehicleSold().getModel() + "|"
                + getVehicleSold().getVehicleType() + "|"
                + getVehicleSold().getColor() + "|"
                + getVehicleSold().getOdometer() + "|"
                + getVehicleSold().getPrice() + "|"
                + getSalesTax() + "|"
                + getRecordingFee() + "|"
                + getProcessingFee() + "|"
                + getTotalPrice() + "|"
                + (isFinanced() ? "YES" : "NO") + "|"
                + getMonthlyPayment();
    }

    public double getRecordingFee() { return 100; }
    public double getProcessingFee() {
        if (getVehicleSold().getPrice() >= 10000)
            return 495;
        return 295;
    }
    public double getSalesTax() { return 0.05 * getVehicleSold().getPrice(); }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }
}