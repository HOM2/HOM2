package hom2;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.NavigationController;
import hom2.gamelogic.Position;
import java.awt.Point;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class SceneController implements Initializable {

    @FXML
    private ImageView mapView;
    @FXML
    private ImageView hero;
    @FXML
    private ScrollPane mapPane;
    @FXML
    private Label heroCoordinates;

    // game settings
    private final long STEP_LENGTH = GameSettings.GRID_SIZE;
    private final double MOVE_DURATION = GameSettings.CHARACTER_ANIMATION_DURATION;
    private final Image mapImage = GameSettings.MAP_IMAGE;
    private final Image heroImage = GameSettings.HERO_IMAGE;
    private final Image dragonKnightImage = GameSettings.DRAGON_KNIGHT_IMAGE;

    protected NavigationController navController;
    protected BattleController btlController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Init map
        mapView.setImage(mapImage);
        Rectangle2D rec = new Rectangle2D(0, 0, GameSettings.getMapWidth(), GameSettings.getMapHeight());
        mapView.setViewport(rec);

        // Init hero
        hero.setImage(heroImage);
        hero.setFitHeight(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);
        hero.setFitWidth(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);
        
        displayHeroPosition( new Point((int)GameSettings.getMapGridsX()/2+1, (int)GameSettings.getMapGridsY()/2+1) );

    }
    
    public void displayHeroPosition(Point p){
        String msg = (int)p.getX() + " : " + (int)p.getY() 
                + " (" + GameSettings.getMapGridsX() + ":" + GameSettings.getMapGridsY() + ")";
        this.heroCoordinates.setText( msg);
    }
    

    public void setNavController(NavigationController nc) {
        this.navController = nc;
    }

    public void setBattleController(BattleController bc) {
        this.btlController = bc;
    }

    @FXML
    public void moveUp() {
        TranslateTransition transTransitionUp;
        transTransitionUp = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byY(+STEP_LENGTH)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransitionUp.play();
    }

    @FXML
    public void moveDown() {
        TranslateTransition transTransitionUp;
        transTransitionUp = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byY(-STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransitionUp.play();
    }

    @FXML
    public void moveLeft() {
        TranslateTransition transTransitionUp;
        transTransitionUp = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byX(+STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransitionUp.play();
    }

    @FXML
    public void moveRight() {
        TranslateTransition transTransitionUp;
        transTransitionUp = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byX(-STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransitionUp.play();
    }

    @FXML
    public void initMap() {
        // Center the hero
        long heroPositionOffset = (long) (GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE / 2);
        hero.setLayoutX(GameSettings.MAP_VIEW_SIZE / 2 - heroPositionOffset);
        hero.setLayoutY(GameSettings.MAP_VIEW_SIZE / 2 - heroPositionOffset);

        // center the map
        mapPane.setVvalue(0.5);
        mapPane.setHvalue(0.5);
    }

}
