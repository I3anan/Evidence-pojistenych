/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistenychmain;

/**
 *
 * @author pksmi
 */
public class PojistenaOsoba {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefonniCislo;

    public PojistenaOsoba(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }
    
    @Override
    public String toString() {
        return pridejMezery(jmeno) + pridejMezery(prijmeni) + pridejMezery(Integer.toString(vek)) + pridejMezery(Integer.toString(telefonniCislo));
    }
    
    public String pridejMezery(String udaj) {
        int delkaSloupce = 10;
        if (udaj.length() >= 10) {
            return udaj + " ";
        }
        return  udaj + " ".repeat(delkaSloupce - udaj.length());
    }
}
