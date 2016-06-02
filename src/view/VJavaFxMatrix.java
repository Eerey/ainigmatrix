package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class VJavaFxMatrix extends Application {
 
   public void init() throws Exception {
      // Do some heavy lifting
   }
 
   public void start(Stage primaryStage) throws Exception {
      BorderPane root = new BorderPane(new Label("Loading complete!"));
      Scene scene = new Scene(root);
      primaryStage.setWidth(800);
      primaryStage.setHeight(600);
      primaryStage.setScene(scene);
      primaryStage.show();
      
      Text t2 = new Text();
      t2.setX(10.0f);
      t2.setY(140.0f);
      t2.setCache(true);
      t2.setText("Blurry Text");
      t2.setFill(Color.RED);
      t2.setFont(Font.font(null, FontWeight.BOLD, 36));
      t2.setEffect(new GaussianBlur());
      
      root.getChildren().add(t2);
      
      
      
   }
   
}