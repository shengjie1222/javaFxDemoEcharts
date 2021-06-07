package sample.componet;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:25
 */
public class MyCircle extends Circle {
    public MyCircle(double radius) {
        super(radius);
    }

    public MyCircle(double radius, Paint fill) {
        super(radius, fill);
    }

    public MyCircle() {
    }

    public MyCircle(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    public MyCircle(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);
    }
}
