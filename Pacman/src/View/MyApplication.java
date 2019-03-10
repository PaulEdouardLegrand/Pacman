package View;

import Controller.EntreeClavier;
import Model.Case;
import Model.Console;
import Model.Entite;
import Model.Grille;
import Model.Jeu;
import Model.Pacman;
import Model.Personnage;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MyApplication extends Application implements Observer {

	GridPane canvas ;
	ImageView [][] tab;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Jeu j = new Jeu();
		canvas = new GridPane();
		List<Personnage> personnages = j.getGrille().getPersonnages();

		personnages.stream().map((p) -> {
			p.addObserver(this);
			return p;
		}).forEachOrdered((p) -> {
			new Thread(p).start();
		});

		Grille grille = j.getGrille();
		tab = new ImageView[grille.getHEIGHT()][grille.getWIDTH()];
		Case[][] cases = grille.getCases();
		for (int l = 0; l < grille.getHEIGHT(); l++) {
			for (int c = 0; c < grille.getWIDTH(); c++) {
				if (cases[l][c] != null) {
					Case cs = cases[l][c];
					Rectangle rect = new Rectangle();
					Color color = cs.estTraversable() ? Color.BLACK : Color.ANTIQUEWHITE;
					rect.setFill(color);
					ArrayList<Entite> entities = cs.getEntites();
					if (!entities.isEmpty()) {
						ImageView iv = new ImageView();
						tab[l][c] = iv;
						canvas.add(tab[l][c],c,l);
					}
				}
			}
		}
		Scene scene = new Scene(canvas, 1000, 1000);
		scene.setOnKeyPressed(new EntreeClavier());
		primaryStage.setTitle("Pac-Man");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

		if (arg0 instanceof Pacman ) {
			
			Grille grille = ((Pacman)arg0).getGrille();
			Case[][] cases = grille.getCases();
			int compteurFantome = 0;
			for (int l = 0; l < grille.getHEIGHT(); l++) {
				for (int c = 0; c < grille.getWIDTH(); c++) {
					if (cases[l][c] != null) {
						Case cs = cases[l][c];
						ArrayList<Entite> entities = cs.getEntites();
						if (!entities.isEmpty()) {
							String perso = entities.get(0).getNom() ;
							//ImageView iv;
						
							switch (perso) {
							case ("Pacman"):
								tab[l][c].setImage(new Image("ressources/images/pacman_closed.png"));
								//iv = new ImageView(new Image("ressources/images/pacman_closed.png"));
								//iv.setFitWidth(22);			//a changer
								//iv.setFitHeight(22);		//de meme
								
							break;
							case ("Fantome"):
								switch (compteurFantome) {
								case (0):
									tab[l][c].setImage(new Image("ressources/images/clyde1.png"));
									//iv = new ImageView(new Image("ressources/images/clyde1.png"));
								break;
								case(1):
									tab[l][c].setImage(new Image("ressources/images/blinky1.png"));
									//iv = new ImageView(new Image("ressources/images/blinky1.png"));
								break;
								case (2):
									tab[l][c].setImage(new Image("ressources/images/pinky1.png"));
									//iv = new ImageView(new Image("ressources/images/pinky1.png"));
								break;
								case(3):
									tab[l][c].setImage(new Image("ressources/images/inky1.png"));
								
									//iv = new ImageView(new Image("ressources/images/inky1.png"));
								break;
								default:
								}
							compteurFantome = (compteurFantome+1)%4;
							//iv.setFitWidth(22);			//a changer
							//iv.setFitHeight(22);		//de meme
							break;
							case ("Piece"): 
								tab[l][c].setImage(new Image("ressources/images/rond.png"));
							tab[l][c].setFitWidth(6);		
							tab[l][c].setFitHeight(6);	

							break;
							case ("SuperPiece"): 
								tab[l][c].setImage(new Image("ressources/images/rond.png"));
							tab[l][c].setFitHeight(14);
							tab[l][c].setFitWidth(14);
							/*	iv = new ImageView(new Image("ressources/images/rond.png"));
							iv.setFitWidth(14);			//a changer
							iv.setFitHeight(14);		//de meme */
							break;
							default:
								break;
							}
						
						}
					}
				}
			}
		}
	}
}
