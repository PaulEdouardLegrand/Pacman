/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EntreeClavier;

/**
 *
 * @author Kyle
 */
public class Pacman extends Personnage {

    public Pacman(int line, int col, Grille grille) {
        super("Pacman", line, col, grille);
    }

    @Override
    public void deplacer() {
        Case[][] cases = grille.getCases();
        switch (EntreeClavier.getDirection()) {
            case up:
                if (cases[line - 1][col].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    
                    line--;
                } else {
                    return;
                }
                break;
            case right:
                if (cases[line][col + 1].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    col++;
                } else {
                    return;
                }
                break;
            case down:
                if (cases[line + 1][col].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    line++;
                } else {
                    return;
                }
                break;
            case left:
            	
            	System.out.print(cases[line][col]);
                if (cases[line][col - 1].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    col--;
                } else {
                    return;
                }
                break;
            default:
            	
                break;
        }
        //System.out.print(EntreeClavier.getDirection());
        cases[line][col].ajouterEntite(this);
        this.setChanged();
        this.notifyObservers();
    }

}
