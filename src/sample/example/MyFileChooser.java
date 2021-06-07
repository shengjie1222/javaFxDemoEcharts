package sample.example;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:00
 */
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyFileChooser extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();

        Button buttonLoad = new Button("Load");
        buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                //文件类型过滤器
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"),
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("GIF", "*.gif"),
                        new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                System.out.println(file);
            }
        });
        VBox vBox = VBoxBuilder.create()
                .children(buttonLoad)
                .build();
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

}

