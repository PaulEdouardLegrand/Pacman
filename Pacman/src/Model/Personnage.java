/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EntreeClavier;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public abstract class Personnage extends Entite implements Runnable {

    public Personnage(String image, int line, int col, Grille grille) {
        super(image, line, col, grille);
    }

    @Override
    public void run() {

        while (true) {
            try {
                sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Personnage.class.getName()).log(Level.SEVERE, null, ex);
            }
            deplacer();
            setChanged();
            notifyObservers();
        }
    }

    public abstract void deplacer();
}
