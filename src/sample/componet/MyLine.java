package sample.componet;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 15:17
 */
public class MyLine extends Line {


    private void init(){
        //表示打开反锯齿
        this.setSmooth(true);
        //线条颜色
        this.setStroke(Color.RED);
        //设置在Shape节点的边界周围绘制描边的位置
        this.setStrokeType(StrokeType.CENTERED);
        //线宽
        this.setStrokeWidth(5);
        //在线或路径的末尾设置帽样式
        this.setStrokeLineCap(StrokeLineCap.BUTT);
        //按照数组呈现显示/隐藏，数组偶数位（0位开始）显示，奇数位隐藏 可将距离设置为虚线模式
        this.getStrokeDashArray().addAll(5d, 2d);
        //虚线时起点的横向偏移
        this.setStrokeDashOffset(5);
        //当线相遇时设置装饰
        this.setStrokeLineJoin(StrokeLineJoin.MITER);
        //设置斜角连接的限制以及斜角连接装饰
        this.setStrokeMiterLimit(2);
    }
    public MyLine() {
        super();
        init();
    }

    public MyLine(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
        init();
    }
}
