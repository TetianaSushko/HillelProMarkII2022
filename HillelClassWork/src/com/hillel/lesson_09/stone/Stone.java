package com.hillel.lesson_09.stone;
/*
наменование
драгоценных и полудрагоценных;
стоимость
вес
прозрачность
 */
public class Stone {
    private String name;
    private boolean drag;
    private double weightCarat;
    private double pricePerCarat;
    private double clarity;

    public Stone() {
    }

    public Stone(String name, boolean drag, double weightCarat, double pricePerCarat, double clarity) {
        this.name = name;
        this.drag = drag;
        this.weightCarat = weightCarat;
        this.pricePerCarat = pricePerCarat;
        this.clarity = clarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDrag() {
        return drag;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    public double getWeightCarat() {
        return weightCarat;
    }

    public void setWeightCarat(double weightCarat) {
        this.weightCarat = weightCarat;
    }

    public double getPricePerCarat() {
        return pricePerCarat;
    }

    public void setPricePerCarat(double pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
    }

    public double getClarity() {
        return clarity;
    }

    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    public double getPrice(){
        return this.pricePerCarat * this.weightCarat;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "name='" + name + '\'' +
                ", drag=" + drag +
                ", weightCarat=" + weightCarat +
                ", pricePerCarat=" + pricePerCarat +
                ", clarity=" + clarity +
                '}';
    }
}
