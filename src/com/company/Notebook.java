package com.company;

public class Notebook {

    private int price;
    private Name name;
    private int ram;

    public Notebook(int price, Name name, int ram) {
        this.price = price;
        this.name = name;
        this.ram = ram;
    }

    public static Notebook generateRandom() {
        return new Notebook((int)(Math.random() * 30 + 1) * 50 + 500,
                Name.values()[(int)(Math.random() * 5)],
                (int)(Math.random() * 5 + 1) * 4);
    }

    public int getPrice() {
        return price;
    }

    public Name getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "{" +
                "price=" + price +
                ", name=" + name +
                ", ram=" + ram +
                '}';
    }
}

