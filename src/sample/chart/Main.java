package sample.chart;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:28
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("main_view.fxml"));

        //扇形图
        PieChart pieChart = (PieChart)root.lookup("#pieChart");
        PieChartUtils pieChartUtils = new PieChartUtils(pieChart);
        Label label = (Label)root.lookup("#pieLabel");
        pieChartUtils.operatePieChart().setTip(label);

        //柱状图
        BarChart bc = (BarChart)root.lookup("#barChart");
        BarChartUtils barChartUtils = new BarChartUtils(bc);
        barChartUtils.operateBarChart();

        //堆叠柱状图
        StackedBarChart stackedBarChart = (StackedBarChart)root.lookup("#stackedBarChart");
        StackedBarChartUtils stackedBarChartUtils = new StackedBarChartUtils(stackedBarChart);
        stackedBarChartUtils.operateStackedBarChart();

        //折线图
        LineChart lineChart = (LineChart)root.lookup("#lineChart");
        LineChartUtils lineChartUtils = new LineChartUtils(lineChart);
        lineChartUtils.operateLineChart().setTip();

        //面积图
        AreaChart areaChart = (AreaChart)root.lookup("#areaChart");
        AreaChartUtils areaChartUtils = new AreaChartUtils(areaChart);
        areaChartUtils.operateAreaChart();

        //堆叠面积图
        StackedAreaChart stackedAreaChart = (StackedAreaChart) root.lookup("#stackedAreaChart");
        StackedAreaChartUtils stackedAreaChartUtils = new StackedAreaChartUtils(stackedAreaChart);
        stackedAreaChartUtils.operateStackedAreaChart();

        //气泡图
        BubbleChart bubbleChart = (BubbleChart)root.lookup("#bubbleChart");
        BubbleChartUtils bubbleChartUtils = new BubbleChartUtils(bubbleChart);
        bubbleChartUtils.operateBubbleChart();

        //散布图
        ScatterChart scatterChart = (ScatterChart) root.lookup("#scatterChart");
        ScatterChartUtils scatterChartUtils = new ScatterChartUtils(scatterChart);
        scatterChartUtils.operateScatterChart();

        primaryStage.setTitle("图表Chart");
        primaryStage.setScene(new Scene(root, 797, 484));

        primaryStage.show();
    }
}
