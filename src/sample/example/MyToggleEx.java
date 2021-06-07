package sample.example;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 10:51
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyToggleEx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        stage.setWidth(250);
        stage.setHeight(350);

        final ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("High");
        tb1.setToggleGroup(group);
        tb1.setUserData("High");
        tb1.setSelected(true);

        ToggleButton tb2 = new ToggleButton("Medium");
        tb2.setToggleGroup(group);
        tb2.setUserData("Medium");

        ToggleButton tb3 = new ToggleButton("Low");
        tb3.setToggleGroup(group);
        tb3.setUserData("Low");


        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
            if (new_toggle == null) {
                System.out.println("default value");
            } else {
                System.out.println(group.getSelectedToggle().getUserData());
            }
        });

        //添加样式
        tb1.getStyleClass().add("toggle-button1");
        tb2.getStyleClass().add("toggle-button2");
        tb3.getStyleClass().add("toggle-button3");



        HBox hbox = new HBox();
        VBox vbox = new VBox();

        vbox.getChildren().add(tb1);
        vbox.getChildren().add(tb2);
        vbox.getChildren().add(tb3);
        vbox.setSpacing(10);

        hbox.getChildren().add(vbox);
        hbox.setSpacing(50);
        hbox.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
}

