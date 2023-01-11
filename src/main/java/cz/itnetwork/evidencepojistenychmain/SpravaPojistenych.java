/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistenychmain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pksmi
 */
public class SpravaPojistenych {
    private Databaze databaze;
    private Scanner sc;
    
    public SpravaPojistenych() {
        databaze = new Databaze();
        sc = new Scanner(System.in);
    }
    
    //Hlavní cyklus
    public void program() {
        vytiskniUvodniobrazovku();
        String volba = "";
        while (!volba.equals("4")) {
            vytiskniAkce();
            volba = sc.nextLine();
            switch (volba) {
                case "1":
                    pridejPojisteneho();
                    break;
                case "2":
                    vypisPojistene();
                    break;
                case "3":
                    vyhledejPojisteneho();
                    break;
                case "4":
                    System.out.println("\nUkončuji program");
                    break;
            }
        }
    }
    
    //Vytisknutí úvodní obrazovky
    public void vytiskniUvodniobrazovku() {
        System.out.println("-".repeat(29) + "\nEvidence pojištěných\n" + "-".repeat(29) + "\n");

    }
    
    //Vytisknutí akcí k výběru
    public void vytiskniAkce() {
        System.out.println("Vyberte si akci:\n"
                + "1 - Přidat nového pojištěného\n"
                + "2 - Vypsat všechny pojištěné\n"
                + "3 - Vyhledat pojištěného\n"
                + "4 - Konec");
    }
    
    //Přidání pojištěného do "databáze"
    public void pridejPojisteneho() {
        System.out.println("\nZadejte jméno pojištěného:");
        String jmeno = sc.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = sc.nextLine();
        System.out.println("Zadejte telefonní číslo:");
        int telefonniCislo = Integer.parseInt(sc.nextLine());
        System.out.println("Zadejte věk:");
        int vek = Integer.parseInt(sc.nextLine());
        databaze.pridejPojisteneho(jmeno,prijmeni, vek, telefonniCislo);
        System.out.print("\nData byla uložena. ");
        pockej();
    }
    
    //Vypsání všech pojištěných
    public void vypisPojistene() {
        System.out.println("");
        ArrayList<PojistenaOsoba> seznamPojistenych = databaze.getSeznamPojistenych();
        
        if (seznamPojistenych.isEmpty()) {
            System.out.println("Nenalezena žádná data.");
        } else {
            for (PojistenaOsoba pojisteny : seznamPojistenych) {
                System.out.println(pojisteny);
            }
        }        
        System.out.println("");
        pockej();
    }
    
    //Vyhledání pojištěného
    public void vyhledejPojisteneho() {
        System.out.println("\nZadejte jméno pojištěného:");
        String jmeno = sc.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = sc.nextLine();
        System.out.println("");
        
        ArrayList<PojistenaOsoba> nalezeni = databaze.vratPojistenePodleJmena(jmeno, prijmeni);
        if (nalezeni.isEmpty()) {
            System.out.println("Žádný pojištěný neodpovídá zadaným údajům.");
        } else {
            for (PojistenaOsoba pojisteny : nalezeni) {
                System.out.println(pojisteny);
            }
        }
        
        System.out.println("");
        pockej();
    }
    
    //Čekání na reakci uživatele
    public void pockej() {
        System.out.println("Pokračujte stisknutím klávesy Enter");
        sc.nextLine();
    }
}
