package org.example.enums;

public enum Genre {

    ACTION(301),
    FICTION(302),
    SCIFI(303),
    NOVEL(304),
    ROMANCE(305),
    FANTASY(306),
    MYSTERY(307);

    private final int value;

    Genre(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
