package sample.componet;

import javafx.scene.shape.Polyline;

/**
 * 多线
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:32
 */
public class MyPolyline extends Polyline {

    private final Double[] points = new Double[]{50.0, 200d,70.0, 210d,60.0, 200d };

    private void init(){
        this.getPoints().addAll(points);
    }

    public MyPolyline() {
        init();
    }
}
