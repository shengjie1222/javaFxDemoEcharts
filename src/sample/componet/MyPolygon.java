package sample.componet;

import javafx.scene.shape.Polygon;

/**
 * 多边形
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:28
 */
public class MyPolygon extends Polygon {

    private final Double[] points = new Double[]{10.0, 200d,30.0, 210d,20.0, 200d };

    private void init(){
        this.getPoints().addAll(points);
    }

    public MyPolygon() {
        init();
    }

}
