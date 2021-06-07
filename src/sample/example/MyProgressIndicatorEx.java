package sample.example;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 11:42
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class MyProgressIndicatorEx extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 260, 150);
        stage.setScene(scene);

        Group g = new Group();

        ProgressIndicator p1 = new ProgressIndicator();
        //不设定初始值将开启不确定模式
//        p1.setProgress(0);
        p1.setPrefSize(100,100);

        g.getChildren().add(p1);

        scene.setRoot(g);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

