package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static java.lang.Math.random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        Scene scene = new Scene(root,800,600, Color.BLACK);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);

        Group circles = new Group();
        for(int i=0;i<30;++i){
            Circle circle = new Circle(150,Color.web("white",0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white",0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        circles.setEffect(new BoxBlur(10,10,3));

        Rectangle colors = new Rectangle(scene.getWidth(),scene.getHeight(),new LinearGradient(0f,1f,1f,0f,true, CycleMethod.NO_CYCLE,
                new Stop[]{
                        new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14, Color.web("#c0fe56")),
                        new Stop(0.28, Color.web("#5dfbc1")),
                        new Stop(0.43, Color.web("#64c2f8")),
                        new Stop(0.57, Color.web("#be4af7")),
                        new Stop(0.71, Color.web("#ed5fc2")),
                        new Stop(0.85, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f")),
                }));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());

//        root.getChildren().add(colors);
//        root.getChildren().add(circles);
        Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(),scene.getHeight(),Color.BLACK),circles),colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);

        Timeline timeline = new Timeline();
        for(Node circle:circles.getChildren()){
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    ),
                    new KeyFrame(new Duration(4000),
                            new KeyValue(circle.translateXProperty(),random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    ),
                    new KeyFrame(new Duration(8000),
                            new KeyValue(circle.translateXProperty(),random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    ),
                    new KeyFrame(new Duration(12000),
                            new KeyValue(circle.translateXProperty(),random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    ),
                    new KeyFrame(new Duration(16000),
                            new KeyValue(circle.translateXProperty(),random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    ),
                    new KeyFrame(new Duration(40000),
                            new KeyValue(circle.translateXProperty(),random()*1980),
                            new KeyValue(circle.translateYProperty(),random()*1080)
                    )
            );
        }
        timeline.play();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
