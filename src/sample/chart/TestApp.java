package sample.chart;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 17:27
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by wangzoey on 2019/6/13.
 */
public class TestApp extends Application {
    private ObservableList<XYChart.Series<Number, Number>> lineChartData;


    public TestApp() {
        this.lineChartData = FXCollections.observableArrayList();
    }

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        LineChart chart = new LineChart(x, y);

        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data<Number, Number>(1600, 54301.85));
        series1.getData().add(new XYChart.Data<Number, Number>(600, 41251.19));
        series1.getData().add(new XYChart.Data<Number, Number>(500, 40013.37));
        lineChartData.add(series1);
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data<Number, Number>(1600, 57401.85));
        series2.getData().add(new XYChart.Data<Number, Number>(600, 41941.19));
        series2.getData().add(new XYChart.Data<Number, Number>(500, 45263.37));
        lineChartData.add(series2);
        chart.getData().addAll(lineChartData);

        HBox box = new HBox();
        //需要先添加,再绑定tooltip事件
        box.getChildren().add(chart);

        Tooltip tooltip = new Tooltip();
        tooltip.setAutoHide(true);
        for (XYChart.Series<Number, Number> series : lineChartData) {
            for (XYChart.Data<Number, Number> data : series.getData()) {
                data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        tooltip.setText(data.getYValue().toString());
                        tooltip.show(data.getNode(), event.getScreenX(), event.getScreenY());
                    }
                });
            }
        }


        stage.setScene(new Scene(box));
        stage.show();
    }

}