package sample.componet;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-04 14:50
 */
public class MyDatePicker extends DatePicker {


    private void init(){
        //默认时间
//        this.setValue(LocalDate.of(2014, 10, 8));
        this.setValue(LocalDate.now());
        //显示周数
        this.setShowWeekNumbers(true);

        //提示占位符
        this.setPromptText("yyyy/mm/dd");

        String pattern = "yyyy-MM-dd";

        //重新定义日期格式
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        this.setConverter(converter);


    }

    public MyDatePicker() {
        init();
    }
}
