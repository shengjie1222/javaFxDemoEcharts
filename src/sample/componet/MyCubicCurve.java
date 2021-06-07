package sample.componet;

import javafx.scene.shape.CubicCurve;

/**
 * 曲线
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:38
 */
public class MyCubicCurve extends CubicCurve {

    private void init(){
        this.setStartX(0.0f);
        this.setStartY(250.0f);
        this.setControlX1(25.0f);
        this.setControlY1(300.0f);
        this.setControlX2(75.0f);
        this.setControlY2(200.0f);
        this.setEndX(100.0f);
        this.setEndY(250.0f);
    }

    public MyCubicCurve() {
        init();
    }

}
