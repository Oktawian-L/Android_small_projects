package com.archiedev.optimus.cw3fragmenty;

import java.io.Serializable;

public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int wiek;
    private int priorytet;
    private char gatunek;

    public Pet() {
        // TODO Auto-generated constructor stub
    }

    public Pet(String name, int wiek, int priorytet, char gatunek) {
        super();
        this.name = name;
        this.wiek = wiek;
        this.priorytet = priorytet;
        this.gatunek = gatunek;
    }


    public String getName() {
        return name;
    }

    public int getWiek() {
        return wiek;
    }

    public int getPriorytet() {
        return priorytet;
    }

    public char getGatunek() { return gatunek; }

    public void setName(String name) {
        this.name = name;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setGatunek(char gatunek) { this.gatunek = gatunek; }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }
}