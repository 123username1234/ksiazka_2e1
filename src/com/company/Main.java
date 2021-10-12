package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Kontakt> ksiazkaTelefoniczna;


    public static void main(String[] args) throws  IOException {

        ksiazkaTelefoniczna = new ArrayList<Kontakt>();
        OdczytajZPliku();

        Scanner sc = new Scanner(System.in);

        int wybor = -1;

        while(wybor != 0){
            System.out.println(" --| MENU |-------");
            System.out.println(" 1. DODAJ NUMER");
            System.out.println(" 2. USUŃ NUMER");
            System.out.println(" 3. EDYTUJ NUMER");
            System.out.println(" 4. WYŚWIETL LISTĘ NUMERÓW");
            System.out.println(" 5. WYSZUKAJ NUMER");

            System.out.println("");
            System.out.println(" 0. ZAKOŃCZ DZIAŁANIE APLIKACJI");
            System.out.println("WYBIERZ OPCJĘ");
            wybor = sc.nextInt();
            sc.nextLine();

            switch (wybor) {
                case 1:
                    System.out.println("DODAJ NUMER");
                    String nick;
                    int numer;
                    System.out.println("Podak Nick: ");
                    nick = sc.nextLine();
                    System.out.println("Podak Numer: ");
                    numer = sc.nextInt();
                    sc.nextLine();
                    DodawanieWpisow(nick, numer);
                    break;
                case 2:
                    System.out.println("USUŃ NUMER");
                    int id;
                    System.out.println("Podaj index numeru: ");
                    id = sc.nextInt();
                    ksiazkaTelefoniczna.remove(id);
                    ZapiszDoPliku();
                    System.out.println("Usunięyo kontakt!");
                    break;
                case 3:
                    System.out.println("EDYTUJ NUMER");
                    break;
                case 4:
                    System.out.println("WYŚWIETL LISTĘ NUMERÓW");
                    break;
                case 5:
                    System.out.println("WYSZUKAJ NUMER");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("NIE ZNAM TAKIEJ OPCJI");
            }
        }
    }




    public static void DodawanieWpisow(String nick, int numer) throws IOException
    {
        Kontakt k = new Kontakt(nick, numer); //tworzenie obiektu
        ksiazkaTelefoniczna.add(k);
        ZapiszDoPliku();
        System.out.println("Dodano kontakt!");
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
