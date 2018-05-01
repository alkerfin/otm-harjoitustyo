/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

import java.util.Objects;

/**
 * Kategoria-luokka datan säilömiseen
 * @author aleksi
 */
public class Kategoria {
    private int id;
    private String nimi;
    
    public Kategoria(String nimi) {
        this.nimi = nimi;
    }

    public Kategoria(int id,String nimi) {
    	this.nimi = nimi;
	this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategoria other = (Kategoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public String getNimi() {
        return this.nimi;
    }
   
    public int getId() {
	return this.id;
    }
}
