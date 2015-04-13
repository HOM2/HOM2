package hom2;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.Characters.GameCharacter;
import hom2.gamelogic.GameController;
import hom2.gamelogic.NavigationController;
import hom2.gamelogic.Position;
import java.awt.Point;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingQueue;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class SceneController implements Initializable {

    @FXML
    private ImageView mapView;
    @FXML
    private Pane pane_characters;
    @FXML
    private ImageView hero;
    @FXML
    private ScrollPane mapPane;
    @FXML
    private Label heroCoordinates;
    @FXML
    private TextArea bgInfo;
    @FXML
    private TextArea dialog;
    @FXML
    private Button btn_retreat;
    @FXML
    private ContextMenu menu_retreat;

    // Status labels
    @FXML
    private Label status_w_name;
    @FXML
    private Label status_w_hp;
    @FXML
    private Label status_w_wp;
    @FXML
    private Label status_w_pw;
    @FXML
    private Label status_e_name;
    @FXML
    private Label status_e_hp;
    @FXML
    private Label status_e_wp;
    @FXML
    private Label status_e_pw;

    private ImageView enemy; // the current enemy

    // game settings
    private final long STEP_LENGTH = GameSettings.GRID_SIZE;
    private final double MOVE_DURATION = GameSettings.CHARACTER_ANIMATION_DURATION;
    private final Image mapImage = GameSettings.MAP_IMAGE;
    private final Image heroImage = GameSettings.CharacterImageType.get(GameCharacter.CharacterType.WARRIOR);
    private Rectangle2D rec;

    static final int N_DIALOG_LINES = 5;
    private final Queue<String> dialogQueue = new LinkedBlockingQueue<>();

    protected GameController gameController;
    protected NavigationController navController;
    protected BattleController btlController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Init map
        mapView.setImage(mapImage);
        this.rec = new Rectangle2D(0, 0, GameSettings.getMapWidth(), GameSettings.getMapHeight());
        mapView.setViewport(rec);

        // Init hero
        hero.setImage(heroImage);
        hero.setFitHeight(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);
        hero.setFitWidth(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);

        displayHeroPosition(new Point((int) GameSettings.getMapGridsX() / 2 + 1, (int) GameSettings.getMapGridsY() / 2 + 1));

    }

    public void initMap() {
        // Center the hero
        long heroPositionOffset = (long) (GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE / 2);
        hero.setLayoutX(GameSettings.MAP_VIEW_SIZE / 2 - heroPositionOffset);
        hero.setLayoutY(GameSettings.MAP_VIEW_SIZE / 2 - heroPositionOffset);

        // center the map
        mapPane.setVvalue(0.5);
        mapPane.setHvalue(0.5);
    }

    public void setGameController(GameController gc) {
        this.gameController = gc;
    }

    public void setNavController(NavigationController nc) {
        this.navController = nc;
    }

    public void setBattleController(BattleController bc) {
        this.btlController = bc;
    }

    boolean transitionFinished = false;

    // Methods handle the input from user
    @FXML
    public void moveUp() {
        TranslateTransition transTransition;
        transTransition = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byY(+STEP_LENGTH)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransition.play();
    }

    @FXML
    public void moveDown() {
        TranslateTransition transTransition;
        transTransition = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byY(-STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransition.play();
    }

    @FXML
    public void moveLeft() {
        TranslateTransition transTransition;
        transTransition = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byX(+STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransition.play();
    }

    @FXML
    public void moveRight() {
        TranslateTransition transTransition;
        transTransition = TranslateTransitionBuilder.create()
                .duration(new Duration(MOVE_DURATION))
                .node(mapView)
                .byX(-STEP_LENGTH)
                .cycleCount(1)
                .interpolator(Interpolator.LINEAR)
                .build();
        transTransition.play();
    }

    // Heal
    @FXML
    public void Heal() {
        this.gameController.getCmdBtlFactory().createHealCommand().execute();
    }

    // Retreat
    @FXML
    public void showRetreatMenu() {
        this.menu_retreat.show(this.btn_retreat, Side.TOP, 20, 20);
    }

    @FXML
    public void retreatUp() {
        this.retreat(GameSettings.Direction.UP);
    }

    @FXML
    public void retreatDown() {
        this.retreat(GameSettings.Direction.DOWN);
    }

    @FXML
    public void retreatLeft() {
        this.retreat(GameSettings.Direction.LEFT);
    }

    @FXML
    public void retreatRight() {
        this.retreat(GameSettings.Direction.RIGHT);
    }

    public void retreat(GameSettings.Direction d) {
        this.gameController.getCmdBtlFactory().createRetreatCommand(d).execute();
    }

    // Methods doing the background lifts
    // Display
    public void displayHeroPosition(Point p) {
        String msg = (int) p.getX() + " : " + (int) p.getY()
                + " (" + GameSettings.getMapGridsX() + ":" + GameSettings.getMapGridsY() + ")";
        this.heroCoordinates.setText(msg);
    }

    public void updateStatus() {
        if (this.gameController == null) {
            return;
        }

        GameCharacter hc = this.gameController.getHero();
        GameCharacter ec = this.gameController.getEnemy();
        if (hc != null) {
            this.status_w_name.setText("@@@@@@@@@@");
            this.status_w_hp.setText(String.valueOf(hc.healthPoints()));
            this.status_w_wp.setText(hc.weaponEquippedNames());
            this.status_w_pw.setText(String.valueOf(hc.getAttackPower()));
        }
        if (ec != null) {
            this.status_e_name.setText(ec.getName());
            this.status_e_hp.setText(String.valueOf(ec.healthPoints()));
            this.status_e_wp.setText(ec.weaponEquippedNames());
            this.status_e_pw.setText(String.valueOf(ec.getAttackPower()));
        }
    }

    public void addDialog(String msg) {
        String output = "";

        // Ref of the Dialog box
        // Remove oldest msg
        if (this.dialogQueue.size() >= N_DIALOG_LINES) {
            this.dialogQueue.poll();
        }
        // Add the the new dialog to Queue
        dialogQueue.offer(msg);

        // Add msgs to output string
        for (String s : dialogQueue) {
            if (!output.isEmpty()) {
                output = output.concat("\n");
            }
            output = output.concat(s);
        }

        // Display dialogs
        dialog.setText(output);
    }

    public void displayBgInfo(String msg) {
        this.bgInfo.setText(msg);
    }

    // Create a character on the screen 
    private ImageView createCharacterImage(GameCharacter character) {
        ImageView characterImage = new ImageView();
        characterImage.setImage(GameSettings.CharacterImageType.get(character.getType()));
        characterImage.setFitHeight(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);
        characterImage.setFitWidth(GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE);
        return characterImage;
    }

    // Place a Position ( most likely with a character) object one the map
    public void showEnemy(Position position) {
        long characterPositionOffset
                = (long) (GameSettings.GRID_SIZE * GameSettings.FIGURE_SCALE / 2);

        Point heroCenterPoint = new Point((int) GameSettings.MAP_VIEW_SIZE / 2,
                (int) GameSettings.MAP_VIEW_SIZE / 2);

        ImageView character = createCharacterImage(position.getCharacter());

        long heroGridX = (long) gameController.getHeroPosition().getPoint().getX();
        long heroGridY = (long) gameController.getHeroPosition().getPoint().getY();

        character.setLayoutX(
                heroCenterPoint.getX() - characterPositionOffset
                + (position.getPoint().getX() - heroGridX) * GameSettings.GRID_SIZE);
        character.setLayoutY(
                heroCenterPoint.getY() - characterPositionOffset
                + (position.getPoint().getY() - heroGridY) * GameSettings.GRID_SIZE);

        this.pane_characters.getChildren().add(character);

        this.enemy = character;
    }

    public void hideEnemy() {
        if (this.enemy != null) {
            this.pane_characters.getChildren().remove(this.enemy);
        }
    }

}
