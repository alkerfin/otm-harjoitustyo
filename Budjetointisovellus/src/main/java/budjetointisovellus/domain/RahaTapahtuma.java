

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
    private int summa;
    private Kategoria kategoria;
    
    public RahaTapahtuma(int id,String nimi,Date paiva,int summa,Kategoria kategoria) {
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
    
}
