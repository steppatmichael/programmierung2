package le05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ampel extends Application
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}


	private Circle redlight;
	private Circle yellowlight;
	private Circle greenlight;
	int state = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		redlight = new Circle(35, Color.RED);
		yellowlight = new Circle(35, Color.YELLOW);
		greenlight = new Circle(35, Color.GREEN);
		
		Button button = new Button("Weiter");
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				weiter();
			}});
		
//		 button.setOnAction((event)->{
//			 weiter();
//		 });
		 
		 redlight.setFill(Color.RED);
		 yellowlight.setFill(Color.GREY);
		 greenlight.setFill(Color.GREY);
		 
		 VBox lightbox = new VBox(10, redlight, yellowlight, greenlight, button);
		 lightbox.setAlignment(Pos.CENTER);
		 
		 Scene scene = new Scene(lightbox, 50, 300);
		 primaryStage.setScene(scene);
		 primaryStage.show();	
		
	}
	private void weiter() {
		state++;
		if(state > 3)
			state = 0;
		
		switch(state) {
			case 0: // Rot
				redlight.setFill(Color.RED);
				yellowlight.setFill(Color.GREY);
				greenlight.setFill(Color.GREY);
				break;
			case 1: // Rot-Gelb
				redlight.setFill(Color.RED);
				yellowlight.setFill(Color.YELLOW);
				greenlight.setFill(Color.GREY);
				break;
			case 2: // Grün
				redlight.setFill(Color.GREY);
				yellowlight.setFill(Color.GREY);
				greenlight.setFill(Color.GREEN);
				break;
			case 3: // Gelb
				redlight.setFill(Color.GREY);
				yellowlight.setFill(Color.YELLOW);
				greenlight.setFill(Color.GREY);
				break;
			
		}
		
	}

}
