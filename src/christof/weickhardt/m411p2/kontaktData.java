/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christof.weickhardt.m411p2;

/**
 *
 * @author christoftobias.weick
 */
public class kontaktData {
    private int kid;
    private String name;
    private String vorname;
    private String strasse;
    private int plz;
    private String ort;

    public kontaktData(int kid, String name, String vorname, String strasse, int plz, String ort) {
        this.kid = kid;
        this.name = name;
        this.vorname = vorname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    public int getKid() {
        return kid;
    }

    public String getName() {
        return name;
    }

    public String getOrt() {
        return ort;
    }

    public int getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getVorname() {
        return vorname;
    }
    
}
