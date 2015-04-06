/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import javafx.scene.control.Alert;

/**
 *
 * @author Alex
 */
public class BattleController {

    public void move(String direction) {
        System.out.println(direction);
    }

    public void buzz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

}
