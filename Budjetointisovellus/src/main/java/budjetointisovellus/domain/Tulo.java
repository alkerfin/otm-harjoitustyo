/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

/**
 *
 * @author aleksi
 */
public class Tulo {
    private int id;
    private int summa;
    private Kategoria kategoria;
    
    Tulo(int summa,Kategoria kategoria) {
        this.summa = summa;
        this.kategoria = kategoria;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
    
    //Save to Database
    public void save() {
        
    }
    

}
