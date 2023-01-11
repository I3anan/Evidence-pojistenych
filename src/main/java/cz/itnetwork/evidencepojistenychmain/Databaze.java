/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistenychmain;

import java.util.ArrayList;

/**
 *
 * @author pksmi
 */
public class Databaze {
    private ArrayList<PojistenaOsoba> seznamPojistenych;
    
    public Databaze() {
        seznamPojistenych = new ArrayList<>();
    }
    
    // Přidání pojištěného
    public void pridejPojisteneho(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        seznamPojistenych.add(new PojistenaOsoba(jmeno, prijmeni, vek, telefonniCislo));
    }
    
    //Vrácení všech pojištěných
    public ArrayList<PojistenaOsoba> getSeznamPojistenych() {
        return seznamPojistenych;
    }
    
    //Vrácení pojištěných podle jména a příjmení
    public ArrayList<PojistenaOsoba> vratPojistenePodleJmena(String jmeno, String prijmeni) {
        ArrayList<PojistenaOsoba> pojisteniPodleJmena = new ArrayList<>();
        for (PojistenaOsoba pojisteny : seznamPojistenych) {
            if (pojisteny.getJmeno().equals(jmeno) && pojisteny.getPrijmeni().equals(prijmeni)) {
                pojisteniPodleJmena.add(pojisteny);
            }
        }
        return pojisteniPodleJmena;
    }
    
}
