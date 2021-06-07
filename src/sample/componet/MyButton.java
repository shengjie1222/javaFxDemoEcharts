package sample.componet;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import sample.images.MyImageView;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 10:32
 */
public class MyButton extends Button {


    private void init(){
        ImageView imageView = MyImageView.get("movi.png");
        this.setGraphic(imageView);
        //阴影
        DropShadow shadow = new DropShadow();
        this.setEffect(shadow);
        //倒影
        Reflection r = new Reflection();
        r.setFraction(0.7);
        this.setEffect(r);
        //去掉所有的效果
        this.setEffect(null);

        //根据css文件设置样式
        this.getStyleClass().add("button1");
        //直接设置样式 与上等价
        this.setStyle("-fx-font: 12 arial; -fx-base: #ee2211;");





    }


    public MyButton(String text) {
        super(text);
        init();
    }
}
