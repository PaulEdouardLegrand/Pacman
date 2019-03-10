/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class Grille {

    private int WIDTH;
    private int HEIGHT;

    private final int CASES_WIDTH = 30;
    private final int CASES_HEIGHT = 30;

    private Pacman pacman;

    private Case[][] cases;

    private final List<Personnage> personnages;

    public Grille() {
        personnages = new ArrayList<>();
        initialiserGrille();
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Case[][] getCases() {
        return cases;
    }

    public void setCases(Case[][] cases) {
        this.cases = cases;
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public final void initialiserGrille() {
        File file = new File("src/ressources/files/monde.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                String line;
                List<String> monde = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    monde.add(line);
                }

                WIDTH = 0;
                for (int l = 0; l < monde.size(); l++) {
                    int length = monde.get(l).length();
                    if (length > WIDTH) {
                        WIDTH = length;
                    }
                }

                HEIGHT = monde.size();

                cases = new Case[HEIGHT][WIDTH];

                for (int l = 0; l < HEIGHT; l++) {
                    line = monde.get(l);
                    for (int c = 0; c < line.length(); c++) {
                        ArrayList<Entite> entitesTmp = new ArrayList<>();
                        Personnage personnage;
                        switch (line.charAt(c)) {
                            case '#':
                                cases[l][c] = new Case(false);
                                break;
                            case '_':
                                cases[l][c] = new Case(true);
                                break;
                            case '.':
                                entitesTmp.add(new PacGomme(l, c, this));
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'o':
                                entitesTmp.add(new SPacGomme(l, c, this));
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'c':
                                cases[l][c] = new Case(true);
                                break;
                            case '@':
                                Pacman pc = new Pacman(l, c, this);
                                entitesTmp.add(pc);
                                personnages.add(pc);
                                this.pacman = pc;
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'C':
                                personnage = new Fantome( l, c, this);
                                entitesTmp.add(personnage);
                                personnages.add(personnage);
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'B':
                                personnage = new Fantome( l, c, this);
                                entitesTmp.add(personnage);
                                personnages.add(personnage);
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'P':
                                personnage = new Fantome( l, c, this);
                                entitesTmp.add(personnage);
                                personnages.add(personnage);
                                cases[l][c] = new Case(entitesTmp);
                                break;
                            case 'I':
                                personnage = new Fantome( l, c, this);
                                entitesTmp.add(personnage);
                                personnages.add(personnage);
                                cases[l][c] = new Case(entitesTmp);
                                break;
                        }


                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Grille.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Grille.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
