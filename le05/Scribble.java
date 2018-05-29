package le05;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Scribble extends Application {

	private Group root;
	private double x, y, lastX, lastY;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		
		Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
		root.getChildren().add(panel);
		
		//panel.setOnMousePressed(new LineStarter());
		panel.setOnMousePressed(event->{
			x = event.getX();
			y = event.getY();
			root.getChildren().add(new Circle(x, y, 3, Color.BLUE));			
			
		});
		
		panel.setOnMouseDragged(new DragPainter());
		panel.setOnMouseReleased(new LineEnder());
		
		primaryStage.show();		
	}
	
	private class LineStarter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			x = event.getX();
			y = event.getY();
			root.getChildren().add(new Circle(x, y, 3, Color.BLUE));			
		}
		
	}
	
	private class DragPainter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			lastX = x;
			lastY = y;
			x = event.getX();
			y = event.getY();
			Line line = new Line(x, y, lastX, lastY);
			line.setStroke(Color.RED);
			root.getChildren().add(line);			
		}
		
	}
	
	private class LineEnder implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			root.getChildren().add(new Circle(lastX, lastY, 3, Color.BLUE));
			
		}
		
	}

}
