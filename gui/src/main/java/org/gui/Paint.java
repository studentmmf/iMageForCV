package org.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Paint {

	public Paint(final Stage stage, Image image, int imageWidth, int imageHeight) {

		Button rubberButton = new Button("Rubber");
		Button pencilButton = new Button("Pencil");
		Button textButton = new Button("Text");

		FlowPane fp = new FlowPane();
		fp.getChildren().addAll(rubberButton, pencilButton, textButton);

		Canvas canvas = new Canvas(600, 600);
		final GraphicsContext gc;
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, 0, 0, (double) imageWidth, (double) imageHeight);
		BorderPane bp = new BorderPane(canvas, fp, null, null, null);
		stage.setScene(new Scene(bp, 700, 700));
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
				text.drawText(gc, canvas);
			}
		};

		rubberButton.setOnAction(event1);
		pencilButton.setOnAction(event2);
		textButton.setOnAction(event3);
	}
}
