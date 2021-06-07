package sample.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 10:40
 */
public class MyImageView {
    public static ImageView get(String picName){
        Image image = new Image(MyImageView.class.getResourceAsStream(picName));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        return imageView;
    }
}
