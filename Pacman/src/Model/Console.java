package Model;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Console implements Observer {

    private final Jeu jeu;
    private final Pane pane;

    public Console(Jeu j, Pane pane) {
        this.jeu = j;
        this.pane = pane;
    }

    @Override
    public void update(Observable o, Object arg) {
        Grille grille = jeu.getGrille();
        Case[][] cases = grille.getCases();
        
        /*Pane canvas = new Pane();
        for (int l = 0; l < grille.getHEIGHT(); l++) {
        for (int c = 0; c < grille.getWIDTH(); c++) {
        if (cases[l][c] != null) {
        Case cs = cases[l][c];
        cs.setFill(cs.getColor());
        canvas.getChildren().add(cs);
        ArrayList<Entite> entities = cs.getEntites();
        if (!entities.isEmpty()) {
        Entite entite = entities.get(0);
        ImageView iv = new ImageView(new Image("ressources/images/" + entite.getImg()));
        iv.setFitWidth(entite.getWidth());
        iv.setFitHeight(entite.getHeight());
        iv.setX(cs.getX() + (cs.getWidth() - iv.getFitWidth()) / 2);
        iv.setY(cs.getY() + (cs.getHeight() - iv.getFitHeight()) / 2);
        canvas.getChildren().add(iv);
        }
        }
        }*/
    }

}
