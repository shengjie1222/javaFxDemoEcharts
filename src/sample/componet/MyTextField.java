package sample.componet;

import javafx.scene.control.TextField;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 11:13
 */
public class MyTextField extends TextField {

    private void init(){
        this.setPromptText("Enter your first name.");
        this.setPrefColumnCount(10);
        //方法
//        this.clear();
//        this.copy();
//        this.cut();
//        this.paste();
//        this.selectAll();
    }

    public MyTextField(String text) {
        super(text);
        init();
    }
}
