package sample.chart;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 15:29
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;


public class PieChartUtils {
    private PieChart pieChart;
    private ObservableList<PieChart.Data> pieChartData;

    PieChartUtils(PieChart pieChart) {
        pieChartData = FXCollections.observableArrayList();
        this.pieChart = pieChart;
    }

    private void addData(String name, double value) {
        pieChartData.add(new PieChart.Data(name, value));
    }

    private void showChart() {
        pieChart.setData(pieChartData);
    }

    private void setDataColor(int index, String color) {
        pieChartData.get(index).getNode().setStyle("-fx-background-color: " + color);
    }

    private void setMarkVisible(boolean b) {
        pieChart.setLabelsVisible(b);
    }

    private void setLegendColor(HashMap<Integer, String> colors) {
        String setColor = "";
        for (Map.Entry<Integer, String> entry : colors.entrySet()) {
            int index = entry.getKey();
            String color = entry.getValue();
            setColor = setColor.concat("CHART_COLOR_" + (index + 1) + ":" + color + ";");
        }
        pieChart.setStyle(setColor);
    }

    private void setLegendSide(String side) {
        if (side.equalsIgnoreCase("top")) {
            pieChart.setLegendSide(Side.TOP);
        } else if (side.equalsIgnoreCase("bottom")) {
            pieChart.setLegendSide(Side.BOTTOM);
        } else if (side.equalsIgnoreCase("left")) {
            pieChart.setLegendSide(Side.LEFT);
        } else {
            pieChart.setLegendSide(Side.RIGHT);
        }
    }

    private void setTitle(String title) {
        pieChart.setTitle(title);
    }

    private void setLabel(){
        pieChart.setLabelsVisible(true);
        pieChart.setLabelLineLength(20);
    }

    void setTip(final Label caption){
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }
    }

    PieChartUtils operatePieChart() {
        PieChartUtils pieChartUtils = new PieChartUtils(pieChart);
        pieChartUtils.addData("R", 0.5);
        pieChartUtils.addData("G", 0.3);
        pieChartUtils.addData("B", 0.2);
        //显示图表
        pieChartUtils.showChart();
        //必须在图标显示之后才能修改数据区域颜色
        pieChartUtils.setDataColor(0, "red");
        pieChartUtils.setDataColor(1, "green");
        pieChartUtils.setDataColor(2, "blue");
        //取消标示
        pieChartUtils.setMarkVisible(false);
        //设置扇形图数据系列的颜色
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "red");
        hashMap.put(1, "green");
        hashMap.put(2, "blue");
        //设置图例颜色和方位
        pieChartUtils.setLegendColor(hashMap);
        pieChartUtils.setLegendSide("Bottom");
        //设置图表的标题
        pieChartUtils.setTitle("RGB");
        //设置LabelLine
        pieChartUtils.setLabel();
        return this;
    }
}