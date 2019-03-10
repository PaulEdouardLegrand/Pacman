/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Kyle
 */
public abstract class Entite extends Observable {

    protected String nom;
    protected int line;
    protected int col;
    protected Grille grille;

    public Entite(String nom, int line, int col, Grille grille) {
        this.grille = grille;
        this.line = line;
        this.col = col;
        this.nom = nom;
    }

    public Grille getGrille() {
        return grille;
    }


    public String getNom() {
        return nom;
    }


    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
