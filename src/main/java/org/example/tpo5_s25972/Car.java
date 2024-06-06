package org.example.tpo5_s25972;

public class Car {
    private int id;
    private String type;
    private String brand;
    private int productionYear;
    private float fuelConsumption;

    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public float getConsumpt() {
        return fuelConsumption;
    }
    public void setConsumpt(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public int getProdYear() {
        return productionYear;
    }
    public void setProdYear(int productionYear) {
        this.productionYear = productionYear;
    }

}
