package sample.chart;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:30
 */
import javafx.scene.chart.*;

public class AreaChartUtils {
    private AreaChart areaChart;
    AreaChartUtils(AreaChart areaChart) {
        this.areaChart = areaChart;
    }
    void operateAreaChart() {
        //声明两条轴
        final CategoryAxis xAxis = (CategoryAxis) areaChart.getXAxis();
        final NumberAxis yAxis = (NumberAxis) areaChart.getYAxis();
        //定义轴的名称
        xAxis.setLabel("月份");
        yAxis.setLabel("股");
        yAxis.setAnimated(true);
        //定义表格名称
        areaChart.setTitle("2010年股票监控");

        //系列1
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("城市1");
        series1.getData().add(new XYChart.Data<>("Jan", 23));
        series1.getData().add(new XYChart.Data<>("Feb", 14));
        series1.getData().add(new XYChart.Data<>("Mar", 15));
        series1.getData().add(new XYChart.Data<>("Apr", 24));
        series1.getData().add(new XYChart.Data<>("May", 34));
        series1.getData().add(new XYChart.Data<>("Jun", 36));
        series1.getData().add(new XYChart.Data<>("Jul", 22));
        series1.getData().add(new XYChart.Data<>("Aug", 45));
        series1.getData().add(new XYChart.Data<>("Sep", 43));
        series1.getData().add(new XYChart.Data<>("Oct", 17));
        series1.getData().add(new XYChart.Data<>("Nov", 29));
        series1.getData().add(new XYChart.Data<>("Dec", 25));

        //系列2
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("城市2");
        series2.getData().add(new XYChart.Data<>("Jan", 33));
        series2.getData().add(new XYChart.Data<>("Feb", 34));
        series2.getData().add(new XYChart.Data<>("Mar", 25));
        series2.getData().add(new XYChart.Data<>("Apr", 44));
        series2.getData().add(new XYChart.Data<>("May", 39));
        series2.getData().add(new XYChart.Data<>("Jun", 16));
        series2.getData().add(new XYChart.Data<>("Jul", 55));
        series2.getData().add(new XYChart.Data<>("Aug", 54));
        series2.getData().add(new XYChart.Data<>("Sep", 48));
        series2.getData().add(new XYChart.Data<>("Oct", 27));
        series2.getData().add(new XYChart.Data<>("Nov", 37));
        series2.getData().add(new XYChart.Data<>("Dec", 29));

        //系列3
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("城市3");
        series3.getData().add(new XYChart.Data<>("Jan", 44));
        series3.getData().add(new XYChart.Data<>("Feb", 35));
        series3.getData().add(new XYChart.Data<>("Mar", 36));
        series3.getData().add(new XYChart.Data<>("Apr", 33));
        series3.getData().add(new XYChart.Data<>("May", 31));
        series3.getData().add(new XYChart.Data<>("Jun", 26));
        series3.getData().add(new XYChart.Data<>("Jul", 22));
        series3.getData().add(new XYChart.Data<>("Aug", 25));
        series3.getData().add(new XYChart.Data<>("Sep", 43));
        series3.getData().add(new XYChart.Data<>("Oct", 44));
        series3.getData().add(new XYChart.Data<>("Nov", 45));
        series3.getData().add(new XYChart.Data<>("Dec", 44));

        //显示图表
        areaChart.getData().addAll(series1, series2, series3);
    }
}