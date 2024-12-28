package com.software.clock_desktop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    ImageView ivZeigerSek = new ImageView();
    ImageView ivZeigerMin = new ImageView();
    ImageView ivZeigerStd = new ImageView();

    double opacity = 0.9;

    @Override
    public void start(Stage stage) {

        ImageView ivZiffern = new ImageView();
        Image Ziffern = new Image("Ziffern.png");
        ivZiffern.setImage(Ziffern);
        ivZiffern.setOpacity(opacity);

        double t = System.currentTimeMillis() / 1000;

        double sek = t % 60;
        double min = (t / 60) % 60;
        double std = ((t / 3600) + 1) % 24; // plus 2 Stunden Sommerzeit, plus 1 Stunde Winterzeit!

        int sekint = (int)sek;
        int minint = (int)min;
        int stdint = (int)std;

        Image ZeigerStd= new Image("stundenzeiger.png");
        ivZeigerStd.setImage(ZeigerStd);
        ivZeigerStd.setOpacity(opacity);

        ivZeigerStd.setLayoutX(220 - 11);
        ivZeigerStd.setLayoutY(85);

        ivZeigerStd.setRotate(30 * stdint + 0.5 * minint);

        Image ZeigerMin = new Image("minutenzeiger.png");
        ivZeigerMin.setImage(ZeigerMin);
        ivZeigerMin.setOpacity(opacity);

        ivZeigerMin.setLayoutX(220 - 11.5);
        ivZeigerMin.setLayoutY(76);

        ivZeigerMin.setRotate(6 * minint + 0.1 * sekint);

        Image ZeigerSek = new Image("sekundenzeiger.png");
        ivZeigerSek.setImage(ZeigerSek);
        ivZeigerSek.setOpacity(opacity);

        ivZeigerSek.setLayoutX(220 - 5.5);
        ivZeigerSek.setLayoutY(76);

        ivZeigerSek.setRotate(6 * sekint);

        Group root = new Group();

        root.getChildren().add(ivZiffern);
        root.getChildren().add(ivZeigerStd);
        root.getChildren().add(ivZeigerMin);
        root.getChildren().add(ivZeigerSek);

        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root, 440, 440);
        scene.setFill(Color.TRANSPARENT);

        /*
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        */

        /*
        scene.setOnMousePressed(pressEvent -> {
            scene.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        */

        stage.setScene(scene);

        //stage.getIcons().add(new Image(""));
        stage.setTitle("Clock");

        stage.setX(1440);
        stage.setY(600);

        stage.show();

        Timer TimerTime = new Timer();
        TimerTime.schedule(new timerTaskTime(), 0, 1000);
    }

    public class timerTaskTime extends TimerTask {

        @Override
        public void run() {

            double t = System.currentTimeMillis() / 1000;

            double sek = t % 60;
            double min = (t / 60) % 60;
            double std = ((t / 3600) + 1) % 24; // plus 2 Stunden Sommerzeit, plus 1 Stunde Winterzeit!

            int sekint = (int)sek;
            int minint = (int)min;
            int stdint = (int)std;

            ivZeigerSek.setRotate(6 * sekint);
            ivZeigerMin.setRotate(6 * minint + 0.1 * sekint);

            if (sekint == 1) {

                ivZeigerStd.setRotate(30 * stdint + 0.5 * minint);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
