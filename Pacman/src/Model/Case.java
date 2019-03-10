/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;


/**
 *
 * @author Kyle
 */
public class Case  {

    private boolean estTraversable;
    private ArrayList<Entite> entites;

    public Case(boolean estTraversable) {
        this.estTraversable = estTraversable;
        this.entites = new ArrayList();
    }

    public Case(ArrayList<Entite> entities) {
        estTraversable = true;
        this.entites = entities;
    }

    public ArrayList<Entite> getEntites() {
        return entites;
    }

    public void setEntites(ArrayList<Entite> entities) {
        this.entites = entities;
    }

    public void ajouterEntite(Entite entite) {
        entites.add(entite);
    }

    public void supprimerEntite(Entite entite) {
        entites.remove(entite);
    }

    public boolean estTraversable() {
        return estTraversable;
    }

    public void setEstTraversable(boolean estTraversable) {
        this.estTraversable = estTraversable;
    }



}
