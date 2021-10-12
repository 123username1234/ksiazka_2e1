package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Kontakt> ksiazkaTelefoniczna;

    public static void main(String[] args) throws  IOException {

        ksiazkaTelefoniczna = new ArrayList<Kontakt>();
        OdczytajZPliku();

    }

    //Podac index kontaktu ktore jest do edycji
    public static void edytowanie(int id) throws IOException {
        int wybor = 0;
        Scanner sc = new Scanner(System.in);

        while(wybor != 3) {
            ksiazkaTelefoniczna.get(id).WyswietlInformacje();
            System.out.println();
            System.out.println("Co chcesz zmienic?");
            System.out.println("1. Nazwa");
            System.out.println("2. Numer");
            System.out.println("3. Wyjscie");

            wybor = sc.nextInt();
            sc.nextLine();

            switch(wybor) {
                case 1:
                    System.out.print("Podaj nowe nazwe: ");
                    ksiazkaTelefoniczna.get(id).nazwa = sc.nextLine();
                    break;
                case 2:
                    System.out.print("Podaj nowy numer: ");
                    ksiazkaTelefoniczna.get(id).numer = sc.nextInt();
                    break;
                case 3:
                    break;
            }

            if(wybor != 3) {
                ZapiszDoPliku();
                System.out.println("Dane zostały zaktualizowane");
            }
            System.out.println();

        }

    }

    public static void OdczytajZPliku() throws FileNotFoundException {

        File plik = new File("Kontakty.txt");
        Scanner sc = new Scanner(plik);

        ksiazkaTelefoniczna.clear();

        while (sc.hasNext()){
            ksiazkaTelefoniczna.add(new Kontakt(sc.next(), sc.nextInt()));
        }
    }

    public static void ZapiszDoPliku() throws IOException {

        FileWriter fw = new FileWriter("Kontakty.txt");

        for (int i = 0; i < ksiazkaTelefoniczna.size(); i++) {
            fw.write(ksiazkaTelefoniczna.get(i).nazwa + " " + ksiazkaTelefoniczna.get(i).numer + "\n");
        }

        fw.close();
    }
}
