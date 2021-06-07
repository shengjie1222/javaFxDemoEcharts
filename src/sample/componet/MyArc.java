package sample.componet;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 * 圆弧
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:17
 */
public class MyArc extends Arc {

    private void init(){
        //定义弧的闭包类型
        this.setType(ArcType.ROUND);
    }

    public MyArc() {
        init();
    }

    /**
     *
     * @param centerX
     * @param centerY
     * @param radiusX
     * @param radiusY
     * @param startAngle 起始角度
     * @param length 终点角度
     */
    public MyArc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length) {
        super(centerX, centerY, radiusX, radiusY, startAngle, length);
        init();
    }
}
