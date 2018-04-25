package com;

import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;


public class Patient {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private String ubezpieczenie;
    private Boolean badanie;

    public Badanie getBadanieObject() {
        return badanieObject;
    }

    public void setBadanieObject(Badanie badanieObject) {
        this.badanieObject = badanieObject;
    }

    private Badanie badanieObject;


    public Patient(String imie, String nazwisko, String pesel, String plec, String ubezpieczenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.ubezpieczenie = ubezpieczenie;
        this.badanie = false;
    }

    public Vector<Object> getVector() {
        return new Vector<>(Arrays.asList(getImie() + " " + getNazwisko(), getPlec(), getPesel(), getUbezpieczenie(), getBadanie()));
    }

    public Object[] getObjectArray() {
        Object[] o = {getImie() + " " + getNazwisko(), getPlec(), getPesel(), getUbezpieczenie(), getBadanie()};
        return o;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPlec() {
        return plec;
    }

    public String getUbezpieczenie() {
        return ubezpieczenie;
    }

    public Boolean getBadanie() {
        return badanie;
    }

    public void setBadanie(boolean s) {
        this.badanie = s;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Patient patient = (Patient) o;
        return Objects.equals(pesel, patient.pesel);
    }
}