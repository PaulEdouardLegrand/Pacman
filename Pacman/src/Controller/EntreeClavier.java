/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Direction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Kyle
 */
public class EntreeClavier implements EventHandler<KeyEvent> {

    private static Direction direction;

    public EntreeClavier() {
        direction = Direction.left;
    }

    public static Direction getDirection() {
        return direction;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                direction = Direction.up;
                break;
            case DOWN:
                direction = Direction.down;
                break;
            case LEFT:
                direction = Direction.left;
                break;
            case RIGHT:
                direction = Direction.right;
                break;
            default:
                direction = Direction.left;
                break;
        }
    }

}
