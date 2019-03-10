package Model;

public class Jeu {

    private Grille grille;

    public Jeu() {
        grille = new Grille();
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

}
