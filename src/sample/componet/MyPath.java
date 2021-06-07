package sample.componet;

import javafx.scene.shape.*;


/**
 * 路径
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:00
 */
public class MyPath extends Path {

    private void init(){
        //起点
        MoveTo moveTo = new MoveTo(5.0f,0.0f);

        LineTo lineTo = new LineTo(5.0f, 150.0f);


        //2点控制
        QuadCurveTo quadTo = new QuadCurveTo();
        //第 1 点
        quadTo.setControlX(25.0f);
        quadTo.setControlY(100.0f);
        //终点
        quadTo.setX(50.0f);
        quadTo.setY(150.0f);

        // 3点控制
        CubicCurveTo cubicTo = new CubicCurveTo();
        //第 1 点
        cubicTo.setControlX1(0.0f);
        cubicTo.setControlY1(0.0f);
        //第 2 点
        cubicTo.setControlX2(100.0f);
        cubicTo.setControlY2(100.0f);
        //终点
        cubicTo.setX(100.0f);
        cubicTo.setY(150.0f);


        this.getElements().add(moveTo);
        this.getElements().add(lineTo);
        this.getElements().add(quadTo);
        this.getElements().add(cubicTo);
    }

    public MyPath() {
        init();
    }
}
