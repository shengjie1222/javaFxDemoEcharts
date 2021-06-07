package sample.componet;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.images.MyImageView;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 10:13
 */
public class MyLabel extends Label {

    public void init(){

        //图标
        ImageView imageView = MyImageView.get("movi.png");
        this.setGraphic(imageView);
        //字体填充颜色
        this.setTextFill(Color.web("#FF76a3"));

        //换行
        this.setPrefWidth(100);
        this.setWrapText(true);
        //旋转 平移
        this.setRotate(45);
        this.setTranslateY(10);

        //鼠标放大缩小事件
        MyLabel _this = this;
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                _this.setScaleX(1.5);
                _this.setScaleY(1.5);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                _this.setScaleX(1);
                _this.setScaleY(1);
            }
        });

        //阴影
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));
        this.setEffect(ds);

        //反射
        Reflection r = new Reflection();
        r.setFraction(0.7);
        this.setEffect(r);


    }

    public MyLabel(String text) {
        super(text);
        init();
    }
}
