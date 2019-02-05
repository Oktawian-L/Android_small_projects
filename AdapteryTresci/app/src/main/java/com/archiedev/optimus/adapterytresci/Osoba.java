package com.archiedev.optimus.adapterytresci;

import java.io.Serializable;

public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int wiek;
    private int priorytet;
    private char plec;

    public Osoba() {
        // TODO Auto-generated constructor stub
    }

    public Osoba(String name, int wiek, int priorytet, char plec) {
        super();
        this.name = name;
        this.wiek = wiek;
        this.priorytet = priorytet;
        this.plec = plec;
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

    public char getPlec() {
        return plec;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }
}

