package sample.example;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:06
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyMenuEx extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu - new, save, exit
        Menu fileMenu = new Menu("_File");
        //开启助记符
        fileMenu.setMnemonicParsing(true);

        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("_Save");
        //设置助记符+快捷键 Ctrl+S
        saveMenuItem.setMnemonicParsing(true);
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));


        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        //上下文菜单（右键）  构造函数传入的是右键面板放置的组件，此处放了一个退出按钮
        ContextMenu  contextFileMenu = new ContextMenu(exitMenuItem);
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
            if (me.getButton() == MouseButton.SECONDARY  || me.isControlDown())  {
                contextFileMenu.show(root, me.getScreenX(), me.getScreenY());
            }  else  {
                contextFileMenu.hide();
            }
        });


        //自定义菜单
        CustomMenuItem customMenuItem = new CustomMenuItem(new Slider());
        customMenuItem.setHideOnClick(false);

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
                new SeparatorMenuItem(), exitMenuItem,customMenuItem);

        Menu webMenu = new Menu("Web");

        CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
        htmlMenuItem.setSelected(true);
        webMenu.getItems().add(htmlMenuItem);

        CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
        cssMenuItem.setSelected(true);
        webMenu.getItems().add(cssMenuItem);

        Menu sqlMenu = new Menu("SQL");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
        mysqlItem.setToggleGroup(tGroup);

        RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
        oracleItem.setToggleGroup(tGroup);
        oracleItem.setSelected(true);

        sqlMenu.getItems().addAll(mysqlItem, oracleItem,
                new SeparatorMenuItem());

        Menu tutorialManeu = new Menu("Tutorial");
        tutorialManeu.getItems().addAll(
                new CheckMenuItem("Java"),
                new CheckMenuItem("JavaFX"),
                new CheckMenuItem("Swing"));

        sqlMenu.getItems().add(tutorialManeu);

        menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

