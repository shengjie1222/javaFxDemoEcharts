package sample.echart;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Description
 * @create 2021-06-07 9:22
 */
public class JavaWebView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Web View Sample");
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(this.getClass().getResource("chart.html").toExternalForm());
        Scene scene = new Scene(webView, 900, 600, Color.web("lightgray"));
        stage.setScene(scene);
        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {
            if (newState == State.SUCCEEDED) {
                Map<String,Integer[]> ydata = new HashMap<>();
                ydata.put("邮件营销",new Integer[]{120, 132, 101, 134, 90, 230, 210});
                ydata.put("联盟广告",new Integer[]{220, 182, 191, 234, 290, 330, 310});
                ydata.put("视频广告",new Integer[]{150, 232, 201, 154, 190, 330, 410});
                ydata.put("直接访问",new Integer[]{320, 332, 301, 334, 390, 330, 320});
                ydata.put("搜索引擎",new Integer[]{820, 932, 901, 934, 1290, 1330, 1320});
                String script = initLineChart("折线图堆叠", new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"}, ydata);
                webEngine.executeScript(script);
                Object res = webEngine.executeScript("download()");
                File file = new File("D:\\test.svg");
                try {
                    if(file.exists()){
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream out = new FileOutputStream(file);
                    String imageb = res.toString().replace("data:image/svg+xml;charset=UTF-8,", "");
                    out.write(imageb.getBytes(StandardCharsets.UTF_8));
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(res);
                stage.show();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }

    private String initLineChart(String text, String [] xdata, Map<String,Integer[]> ydata){
        StringBuilder sb = new StringBuilder("init('");
        sb.append(text);
        sb.append("'");
        sb.append(",'");
        sb.append(String.join(",",xdata));
        sb.append("','");
        sb.append(JSONObject.valueToString(ydata));
        sb.append("');");
        return sb.toString();
    }
}