package com.software.clock_desktop;

import javafx.application.Application;
//import javafx.scene.Camera;
import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Sphere;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    ImageView ivZeigerSek = new ImageView();
    ImageView ivZeigerMin = new ImageView();
    ImageView ivZeigerStd = new ImageView();

    double opacity = 0.4;

    //ImageView ivSonne = new ImageView();

    //Rotate rotation = new Rotate();

    //public static final float WIDTH = 800;
    //public static final float HEIGHT = 800;

    //Sphere sphere = new Sphere(334);

    //Transform rotateEarth = new Rotate(-0.25, Rotate.Y_AXIS);

    @Override
    public void start(Stage stage) {

        ImageView ivZiffern = new ImageView();
        Image Ziffern = new Image("Ziffern.png");
        ivZiffern.setImage(Ziffern);
        ivZiffern.setOpacity(opacity);

        double t = System.currentTimeMillis() / 1000;

        double sek = t % 60;
        double min = (t / 60) % 60;
        double std = ((t / 3600) + 2) % 24; // plus 2 Stunden Sommerzeit, plus 1 Stunde Winterzeit!

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

        stage.getIcons().add(new Image("Uhr.png"));
        stage.setTitle("Clock");

        stage.setX(1440);
        stage.setY(600);

        /*
        Stage stageSun = new Stage();

        Image Sonne = new Image("Sonne.png");
        ivSonne.setImage(Sonne);

        ivSonne.setLayoutX(410);
        ivSonne.setLayoutY(820);

        rotation.setPivotX(60);
        rotation.setPivotY(-350);
        ivSonne.getTransforms().add(rotation);

        rotation.setAngle(15 * stdint + 0.25 * minint);

        Group sunroot = new Group();

        sunroot.getChildren().add(ivSonne);

        stageSun.initStyle(StageStyle.TRANSPARENT);
        Scene sceneSun = new Scene(sunroot, 940, 940);
        sceneSun.setFill(Color.TRANSPARENT);

        stageSun.setScene(sceneSun);

        stageSun.setX(490);
        stageSun.setY(70);
        */

        /*Stage stageEarth = new Stage();

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image("8081_earthmap10k.png"));
        sphere.setMaterial(material);

        Transform zero = new Rotate(195.267 - (15 * stdint + 0.25 * minint), Rotate.Y_AXIS);
        sphere.getTransforms().add(zero);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(-2.5);
        rectangle.setY(-WIDTH/2);
        rectangle.setWidth(5);
        rectangle.setHeight(HEIGHT);
        rectangle.setFill(Color.YELLOWGREEN);

        Circle circleTop = new Circle(0, -HEIGHT/2+20, 20);
        circleTop.setFill(Color.YELLOWGREEN);
        Circle circleButtom = new Circle(0, +HEIGHT/2-20, 20);
        circleButtom.setFill(Color.YELLOWGREEN);

        Group group = new Group();
        group.getChildren().add(sphere);
        group.getChildren().add(rectangle);
        group.getChildren().add(circleTop);
        group.getChildren().add(circleButtom);

        Camera camera = new PerspectiveCamera();

        stageEarth.initStyle(StageStyle.TRANSPARENT);
        Scene sceneEarth = new Scene(group, WIDTH, HEIGHT);
        sceneEarth.setFill(Color.TRANSPARENT);
        sceneEarth.setCamera(camera);

        group.translateXProperty().set(WIDTH/2);
        group.translateYProperty().set(HEIGHT/2);
        group.translateZProperty().set(0);

        stageEarth.setX((1920-WIDTH)/2);
        stageEarth.setY((1080-HEIGHT)/2);

        stageEarth.setScene(sceneEarth);*/

        //Stage stageSunLine = new Stage();

//        Group groupSunLine = new Group();
//        groupSunLine.getChildren().add(rectangle);
//        groupSunLine.getChildren().add(circleTop);
//        groupSunLine.getChildren().add(circleButtom);

//        stageSunLine.initStyle(StageStyle.TRANSPARENT);
//        Scene sceneSunLine = new Scene(groupSunLine, WIDTH, HEIGHT);
//        sceneSunLine.setFill(Color.TRANSPARENT);

//        stageSunLine.setX((1920-WIDTH)/2);
//        stageSunLine.setY((1080-HEIGHT)/2);
//
//        stageSunLine.setScene(sceneSunLine);

        stage.show();
        //stageSun.show();
        //stageEarth.show();
        //stageSunLine.show();

        Timer TimerTime = new Timer();
        TimerTime.schedule(new timerTaskTime(), 0, 1000);
    }

    public class timerTaskTime extends TimerTask {

        @Override
        public void run() {

            double t = System.currentTimeMillis() / 1000;

            double sek = t % 60;
            double min = (t / 60) % 60;
            double std = ((t / 3600) + 2) % 24; // plus 2 Stunden Sommerzeit, plus 1 Stunde Winterzeit!

            int sekint = (int)sek;
            int minint = (int)min;
            int stdint = (int)std;

            ivZeigerSek.setRotate(6 * sekint);
            ivZeigerMin.setRotate(6 * minint + 0.1 * sekint);

            if (sekint == 1) {

                ivZeigerStd.setRotate(30 * stdint + 0.5 * minint);
                //rotation.setAngle(15 * stdint + 0.25 * minint);

                //sphere.getTransforms().add(rotateEarth);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
