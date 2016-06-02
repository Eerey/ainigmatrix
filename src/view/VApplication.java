package view;

import model.Matrix;
import model.Threader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class VApplication extends Application {
 
	boolean transparent = false;
	Stage primaryStage = null;
	
   public void init() throws Exception {

   }
 
   public void start(Stage primaryStage) throws Exception {
	  this.primaryStage = primaryStage;
	   
      //BorderPane root = new BorderPane(new Label("Loading complete!"));
      //Scene scene = new Scene(root);
	  VPane root = new VPane();
	  //if (transparent){
	  //primaryStage.initStyle(StageStyle.TRANSPARENT);
      //Text text = new Text("Transparent!");
      //text.setFont(new Font(12));
      //VBox box = new VBox();
      //box.getChildren().add(text);
      Scene scene = new Scene(root,1024, 768);
      //scene.setFill(null);
	  //}
      primaryStage.setWidth(1024);
      primaryStage.setHeight(768);
      primaryStage.setScene(scene);
      primaryStage.show();
      
//      Text t2 = new Text();
//      t2.setX(20.0f);
//      t2.setY(140.0f);
//      t2.setCache(true);
//      t2.setText("Blurry Text");
//      t2.setFill(Color.RED);
//      t2.setFont(Font.font(null, FontWeight.BOLD, 36));
//      t2.setEffect(new GaussianBlur());
//      
//      box.getChildren().add(t2);
      
		Threader x1 = new Threader(Matrix.getInstance().getMatrix(), Matrix.getInstance(),root);
		x1.start();
		primaryStage.setOnCloseRequest(e -> {
		    
		      Platform.exit();
		      x1.run=false;
		      });
   }
   
   
}