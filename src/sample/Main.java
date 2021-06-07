package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.componet.*;
import sample.util.MyColor;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello World");
        final Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        //线条
        Line line1 = new MyLine(0, 50,   580,   100);
        Line line2 = new MyLine(0, 100,   580,   50);

        //矩形
        Rectangle rectangle = new MyRectangle(260, 100, 80, 50);

        //椭圆
        Ellipse ellipse = new MyEllipse(300,180,50,50);

        //路径
        Path path = new MyPath();

        //路径减法 去掉rectangle部分
        Shape shape = Path.subtract(ellipse,rectangle);

        //圆弧
        Arc arc = new MyArc(420,180,50,50,45f,270f);

        //圆
        Circle circle = new MyCircle(500f,180f,50f, MyColor.getWeb());

        //多边形
        Polygon polygon = new MyPolygon();

        //多线
        Polyline polyline = new MyPolyline();

        //曲线
        CubicCurve cubicCurve = new MyCubicCurve();

        //文本
        Text text = new MyText(100,300,"JavaFX drop shadow...");

        //标签
        Label label = new MyLabel("JavaFX Label long long long long...");
        //坐标
        label.setLayoutX(400);
        label.setLayoutY(300);

        //按钮
        Button button = new MyButton("点击我");
        //坐标
        button.setLayoutX(500);
        button.setLayoutY(300);

        //输入框
        TextField textField = new MyTextField("我是输入的内容");
        //坐标
        textField.setLayoutX(300);
        textField.setLayoutY(350);

        //超链接
        Hyperlink hyperlink = new MyHyperlink();
        //坐标
        hyperlink.setLayoutX(100);
        hyperlink.setLayoutY(350);

        //日期组件
        DatePicker datePicker = new MyDatePicker();
        //坐标
        datePicker.setLayoutX(100);
        datePicker.setLayoutY(400);


        List<Node> nodes = new ArrayList<>();
        nodes.add(line1);
        nodes.add(line2);
        nodes.add(rectangle);
        nodes.add(ellipse);
        nodes.add(path);
        nodes.add(shape);
        nodes.add(arc);
        nodes.add(circle);
        nodes.add(polygon);
        nodes.add(polyline);
        nodes.add(cubicCurve);
        nodes.add(text);
        nodes.add(label);
        nodes.add(button);
        nodes.add(textField);
        nodes.add(hyperlink);
        nodes.add(datePicker);
        root.getChildren().addAll(nodes);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
