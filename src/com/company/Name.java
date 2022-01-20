package com.company;

public enum Name {
    Lenuvo (5),
    Asos (4),
    MacNote (3),
    Eser (2),
    Xamiou (1);

    private int number;

    Name(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
