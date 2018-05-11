

package budjetointisovellus.domain;

import java.util.Date;

/**
 * Rahatapahtuma-luokka datan säilömiseen
 * @author aleksi
 */
public class RahaTapahtuma {
    private int id;
    private String nimi;
    private Date paiva;
    private double summa;
    private Kategoria kategoria;
    
    public RahaTapahtuma(int id,String nimi,Date paiva,double summa,Kategoria kategoria) {
        this.summa = summa;
	this.nimi = nimi;
	this.paiva = paiva;
	this.id = id;
        this.kategoria = kategoria;
    }

    public int getId() {
	return this.id;
    }
    
    public String getNimi() {
	return this.nimi;
    } 
    
    public Date getPaiva() {
	return this.paiva;
    }


    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
 
    @Override
    public String toString() {
	return this.paiva+"\t\t"+this.nimi+"          "+this.summa;
    }
   
}
