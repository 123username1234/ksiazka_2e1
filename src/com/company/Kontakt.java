package com.company;

public class Kontakt {

    public String nazwa;
    public int numer;

    public Kontakt(String nazwa, int numer){
        this.nazwa = nazwa;
        this.numer = numer;
    }

    public void WyswietlInformacje(){
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Numer: " + numer);
    }
}
