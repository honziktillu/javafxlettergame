package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Pane pane;
    public Canvas canvas;
    public GraphicsContext gc;
    public Letter letter;
    public double lineX1 = 400;
    public double lineX2 = 900;
    public int counter = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        letter = new Letter(canvas.getWidth(), canvas.getHeight() / 4, 220, 360, "A");
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleLetter();
                drawScene();
            }
        };
        timer.start();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1),
                event -> {
                    letter.setX(letter.getX() - 1);
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void drawScene() {
        gc.setFill(Paint.valueOf("WHITE"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Paint.valueOf("BLACK"));
        gc.fillRect(lineX1, letter.getY() + 50, 10, letter.getHeight());
        gc.fillRect(lineX2, letter.getY() + 50, 10, letter.getHeight());
        gc.setFill(letter.getColor());
        gc.setStroke(letter.getColor());
        gc.strokeRect(letter.getX(), letter.getY() + 50, letter.getWidth(), letter.getHeight());
        gc.setFont(new Font(letter.getHeight()));
        gc.fillText(letter.getLetter(), letter.getX(), letter.getY() + letter.getHeight(), letter.getWidth());
        gc.setFont(new Font(24));
        gc.fillText("Counter: " + counter, 80, 80);
    }

    public void handleLetter() {
        if (letter.getX() + letter.getWidth() < 0) {
            letter.setX(canvas.getWidth() + letter.getWidth());
            letter.setStatus(0);
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');
            letter.setLetter(String.valueOf(c));
        }
    }


    public void stroke(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE && letter.getStatus() == 0) {
            if (letter.getX() > lineX1 + 9 && letter.getX() + letter.getWidth() < lineX2 + 1) {
                letter.setStatus(1);
                counter++;
            } else {
                letter.setStatus(2);
            }
        }
    }


}
