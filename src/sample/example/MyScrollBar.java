package sample.example;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 14:42
 */
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
public class MyScrollBar extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);

        ScrollBar s1 = new ScrollBar();
        s1.setMax(500);
        s1.setMin(0);
        s1.setValue(100);
        s1.setUnitIncrement(30);
        s1.setBlockIncrement(100);

        s1.setOrientation(Orientation.HORIZONTAL);

        s1.valueProperty().addListener((ObservableValue<? extends Number> ov,
                                        Number old_val, Number new_val) -> {
            System.out.println(new_val.doubleValue());
        });

        root.getChildren().add(s1);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


