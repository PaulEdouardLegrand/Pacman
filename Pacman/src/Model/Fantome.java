/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EntreeClavier;
import java.util.Random;

/**
 *
 * @author Kyle
 */
public class Fantome extends Personnage {

    private Direction direction;

    public Fantome( int line, int col, Grille grille) {
        super("Fantome", line, col, grille);
        direction = Direction.left;
    }

    @Override
    public void deplacer() {/*
        Case[][] cases = grille.getCases();
        switch (direction) {
            case up:
                if (cases[line - 1][col].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    line--;
                } else {
                    int pick = new Random().nextInt(Direction.values().length);
                    direction = Direction.values()[pick];
                }
                break;
            case right:
                if (cases[line][col + 1].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    col++;
                } else {
                    int pick = new Random().nextInt(Direction.values().length);
                    direction = Direction.values()[pick];
                }
                break;
            case down:
                if (cases[line + 1][col].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    line++;
                } else {
                    int pick = new Random().nextInt(Direction.values().length);
                    direction = Direction.values()[pick];
                }
                break;
            case left:
                if (cases[line][col - 1].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    col--;
                } else {
                    int pick = new Random().nextInt(Direction.values().length);
                    direction = Direction.values()[pick];
                }
                break;
            default:
                if (cases[line][col - 1].estTraversable()) {
                    cases[line][col].supprimerEntite(this);
                    col--;
                } else {
                    int pick = new Random().nextInt(Direction.values().length);
                    direction = Direction.values()[pick];
                }
                break;
        }
        cases[line][col].ajouterEntite(this);
        this.setChanged();
        this.notifyObservers();
        /*imageV.setX(col * 30 + 5);
        imageV.setY(line * 30 + 5);*/
    }

}
