package Projekt1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpars on 03.04.2018.
 */
public class Patient {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private String ubezpieczenie;


    public Patient (String imie, String nazwisko, String pesel, String plec, String ubezpieczenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.ubezpieczenie = ubezpieczenie;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getUbezpieczenie() {
        return ubezpieczenie;
    }

    public void setUbezpieczenie(String ubezpieczenie) {
        this.ubezpieczenie = ubezpieczenie;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}