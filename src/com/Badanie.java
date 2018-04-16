package com;

import java.util.Date;

public class Badanie {
    private Date date;
    private long liczbaErytrocytow;
    private double stezenieHemoglobiny;
    private double stezenieZelaza;

    public Badanie(Date date, long liczbaErytrocytow, double stezenieHemoglobiny, double stezenieZelaza) {
        this.date = date;
        this.liczbaErytrocytow = liczbaErytrocytow;
        this.stezenieHemoglobiny = stezenieHemoglobiny;
        this.stezenieZelaza = stezenieZelaza;
    }

    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getLiczbaErytrocytow() {
        return liczbaErytrocytow;
    }

    public void setLiczbaErytrocytow(long liczbaErytrocytow) {
        this.liczbaErytrocytow = liczbaErytrocytow;
    }

    public double getStezenieHemoglobiny() {
        return stezenieHemoglobiny;
    }

    public void setStezenieHemoglobiny(double stezenieHemoglobiny) {
        this.stezenieHemoglobiny = stezenieHemoglobiny;
    }

    public double getStezenieZelaza() {
        return stezenieZelaza;
    }

    public void setStezenieZelaza(double stezenieZelaza) {
        this.stezenieZelaza = stezenieZelaza;
    }


}
