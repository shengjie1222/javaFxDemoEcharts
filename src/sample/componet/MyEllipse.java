package sample.componet;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 15:50
 */
public class MyEllipse extends Ellipse {

    private void init(){

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(1, 0.4, 0.4));

        //用于填充形状内的颜色。
        this.setFill(Color.BLUE);
        //线条颜色
        this.setStroke(Color.AQUA);
        //阴影
        this.setEffect(ds);
    }

    public MyEllipse() {
        super();
        init();
    }

    public MyEllipse(double radiusX, double radiusY) {
        super(radiusX, radiusY);
        init();
    }

    /**
     *
     * @param centerX 中心位置
     * @param centerY 中心位置
     * @param radiusX 横向半径
     * @param radiusY 纵向半径
     */
    public MyEllipse(double centerX, double centerY, double radiusX, double radiusY) {
        super(centerX, centerY, radiusX, radiusY);
        init();
    }
}
