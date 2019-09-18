package org.gui;

import org.gui.instruments.Draw;
import org.gui.instruments.Pencil;
import org.gui.instruments.Rubber;
import org.gui.instruments.Text;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Paint {

	public Paint(final Stage stage, Image image, int imageWidth, int imageHeight) {

		Button rubberButton = new Button("Rubber");
		Button pencilButton = new Button("Pencil");
		Button textButton = new Button("Text");
		TextArea textArea = new TextArea();
		
		Parent menu = stage.getScene().getRoot();
		
		FlowPane fp = new FlowPane();
		fp.getChildren().addAll(rubberButton, pencilButton, textButton, textArea);
		
		VBox vb = new VBox();
		

		Canvas canvas = new Canvas(600, 600);
		final GraphicsContext gc;
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, 0, 0, (double) imageWidth, (double) imageHeight);
		BorderPane bp = new BorderPane(canvas, fp, null, null, null);
		vb.getChildren().addAll(menu, bp);
		stage.setScene(new Scene(vb, 700, 700));
		stage.show();

		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Draw rubber = new Rubber();
				rubber.draw(gc, canvas);
			}
		};

		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Draw pencil = new Pencil();
				pencil.draw(gc, canvas);
			}
		};
		
		EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Text text = new Text();
				text.drawText(gc, canvas, textArea);
			}
		};

		rubberButton.setOnAction(event1);
		pencilButton.setOnAction(event2);
		textButton.setOnAction(event3);
	}
}
