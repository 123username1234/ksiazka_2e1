package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Kontakt> ksiazkaTelefoniczna;

    public static void main(String[] args) {

        ksiazkaTelefoniczna = new ArrayList<Kontakt>();

    }

    public static void OdczytajZPliku() throws FileNotFoundException {

        File plik = new File("Kontakty.txt");
        Scanner sc = new Scanner(plik);

        ksiazkaTelefoniczna.clear();

        while (sc.hasNext()){
            ksiazkaTelefoniczna.add(new Kontakt(sc.next(), sc.nextInt()));
        }
    }
}
