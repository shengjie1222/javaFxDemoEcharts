package sample.chart;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:30
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.chart.*;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LineChartUtils {
    private DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LineChart lineChart;
    private ObservableList<XYChart.Series<String, Number>> lineChartData;

    LineChartUtils(LineChart lineChart) {
        this.lineChartData = FXCollections.observableArrayList();
        this.lineChart = lineChart;
    }

    void setTip() {
        Tooltip tooltip = new Tooltip();
        tooltip.setAutoHide(true);
        for (XYChart.Series<String, Number> series : lineChartData) {
            for (XYChart.Data<String, Number> data : series.getData()) {
                data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        tooltip.setText(data.getYValue().toString());
                        tooltip.show(data.getNode(), event.getScreenX(), event.getScreenY());
                    }
                });
            }
        }
    }

    LineChartUtils operateLineChart() {
        //声明两条轴
        final CategoryAxis xAxis = (CategoryAxis) lineChart.getXAxis();
        final NumberAxis yAxis = (NumberAxis) lineChart.getYAxis();
        //定义轴的名称
        xAxis.setLabel("时间");
        yAxis.setLabel("股");
        yAxis.setAnimated(true);
        //定义表格名称
        lineChart.setTitle("2010年股票监控");
        //禁用点的符号图标
//        lineChart.setCreateSymbols(false);
        //系列1
        LocalDateTime lastDateTime = LocalDateTime.now();
        List<XYChart.Data> seriesData1 = new ArrayList<>();
        List<XYChart.Data> seriesData2 = new ArrayList<>();
        List<XYChart.Data> seriesData3 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String x = dtf2.format(lastDateTime);
            seriesData1.add(new XYChart.Data<String, Number>(x, new Random().nextInt(20)));
            seriesData2.add(new XYChart.Data<String, Number>(x, new Random().nextInt(20)));
            seriesData3.add(new XYChart.Data<String, Number>(x, new Random().nextInt(20)));
            lastDateTime = lastDateTime.plusMinutes(1);
        }
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("城市1");
        for (XYChart.Data data : seriesData1) {
            series1.getData().add(data);
        }
        lineChartData.add(series1);
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("城市2");
        for (XYChart.Data data : seriesData2) {
            series2.getData().add(data);
        }
        lineChartData.add(series2);
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("城市3");
        for (XYChart.Data data : seriesData3) {
            series3.getData().add(data);
        }
        lineChartData.add(series3);
        //显示图表
        lineChart.getData().addAll(lineChartData);
        return this;
    }
}