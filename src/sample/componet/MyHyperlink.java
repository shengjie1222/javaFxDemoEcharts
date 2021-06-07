package sample.componet;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import sample.images.MyImageView;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 11:27
 */
public class MyHyperlink extends Hyperlink {

    private void init(){
        //显示，链接
        this.setText("http://www.yiibai.com");
        ImageView imageView = MyImageView.get("movi.png");
        //设置图标
        this.setGraphic(imageView);
        //设置字体
        this.setFont(Font.font("Arial", 14));

        //事件
        this.setOnAction((ActionEvent e) -> {
            System.out.println("This link is clicked");
        });


    }

    public MyHyperlink() {
        init();
    }
}
