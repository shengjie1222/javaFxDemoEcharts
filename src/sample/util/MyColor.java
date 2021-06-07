package sample.util;

import javafx.scene.paint.Color;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-03 16:56
 */
public class MyColor{

    public static Color getRGB(){
        return Color.rgb(255,100,0);
    }
    public static Color getName(){
        return Color.BURLYWOOD;
    }
    public static Color getAlpha(){
        return new Color(0.9,.2,0,.8);
    }
    public static Color getHsb(){
        return Color.hsb(270,1.0,1.0,.8);
    }
    public static Color getWeb(){
        return Color.web("#FF1A00",.8);
    }
}
