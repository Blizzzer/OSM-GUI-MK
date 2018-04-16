package Projekt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by mpars on 03.04.2018.
 */
public class Patient {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private String ubezpieczenie;
    private Boolean badanie;


    public Patient (String imie, String nazwisko, String pesel, String plec, String ubezpieczenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.ubezpieczenie = ubezpieczenie;
        this.badanie = false;
    }

    public Vector<Object> getVector(){
        return new Vector<>(Arrays.asList(getImie()+ " " + getNazwisko(),getPlec(),getPesel(),getUbezpieczenie(),getBadanie()));
    }
    public Object[] getObjectArray(){
        Object[] o = {getImie() + " " + getNazwisko(),getPlec(),getPesel(),getUbezpieczenie(),getBadanie()};
        return o;
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

    public Boolean getBadanie() {
        return badanie;
    }
    public void setBadanie(boolean s){
        this.badanie = s;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}