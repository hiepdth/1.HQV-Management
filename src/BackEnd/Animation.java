package BackEnd;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.util.Duration;


public class Animation {
    public void done(AnchorPane pane, String mes){
        AnchorPane node = new AnchorPane();
        pane.getChildren().add(node);
        node.setStyle("-fx-background-color: #56d366");
        node.setPrefSize(150,40);
        node.setLayoutX(1040);
        node.setLayoutY(0);
        Label label = new Label(mes);
        label.setLayoutX(0);
        label.setLayoutY(0);
        label.setPrefSize(150, 40);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("System", FontPosture.ITALIC, 14));

        node.getChildren().addAll(label);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        PathTransition pathTransition= new PathTransition();
        Line line = new Line(75,20,75,50);
        pathTransition.setNode(node);
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setPath(line);
        pathTransition.play();
    }
    public void warning(AnchorPane pane, String mes){
        AnchorPane node = new AnchorPane();
        pane.getChildren().add(node);
        node.setStyle("-fx-background-color: #ee4c4c");
        node.setPrefSize(150,40);
        Label label = new Label(mes);
        label.setLayoutX(0);
        label.setLayoutY(0);
        label.setPrefSize(150, 40);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("System", FontPosture.ITALIC, 14));

        node.getChildren().addAll(label);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        PathTransition pathTransition= new PathTransition();

        Line line = new Line(node.getLayoutX(), node.getLayoutY(), node.getLayoutX(), node.getLayoutY()+20);
        pathTransition.setNode(node);
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setPath(line);
        pathTransition.play();
    }
}
