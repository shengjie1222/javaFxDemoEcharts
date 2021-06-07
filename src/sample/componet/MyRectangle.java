package sample.componet;

import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 15:36
 */
public class MyRectangle extends Rectangle {

    private void init(){
        //边角圆角弧度
        this.setArcHeight(15);
        this.setArcWidth(15);
        //画笔边框颜色
        this.setStroke(Color.BLACK);
        //用于填充形状内的颜色。
        this.setFill(Color.BLUE);
    }

    public MyRectangle() {
        super();
        init();
    }

    public MyRectangle(double width, double height) {
        super(width, height);
        init();
    }

    public MyRectangle(double width, double height, Paint fill) {
        super(width, height, fill);
        init();
    }

    public MyRectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
        init();
    }
}
