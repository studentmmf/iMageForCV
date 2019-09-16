package org.gui;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class Text {
	String string = "";

	public void drawText(GraphicsContext gc, Canvas canvas) {
		// gc.strokeText("Hello world!", 150, 100);
		canvas.setOnMouseClicked(e -> {
			// gc.strokeText("Hello world!", 150, 100);
			
			canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
				

				@Override
				public void handle(KeyEvent ke) {
					
					  // System.out.println( "got key pressed event");
		            
					gc.strokeText("Hello world!", 150, 100);

					// string += ke.getText();
					string += "bla ";
					gc.strokeText(string, e.getX(), e.getY());
				}
				
			});
		});

	}
}
