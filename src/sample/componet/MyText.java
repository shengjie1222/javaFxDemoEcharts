package sample.componet;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:43
 */
public class MyText extends Text {

    private void init(){
        this.setCache(true);
        this.setFill(Color.RED);
        this.setFont(Font.font(null, FontWeight.BOLD, 32));

        //角度
        this.setRotate(30);
        //阴影
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));
        this.setEffect(ds);

        //反射
        Reflection r = new Reflection();
        r.setFraction(0.7);
        this.setEffect(r);

        //换行宽度
        this.setWrappingWidth(300);




    }

    public MyText(double x, double y, String text) {
        super(x, y, text);
        init();
    }
}
