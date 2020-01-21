package org.gui.instruments;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class Text {
	

	public void drawText(GraphicsContext gc, Canvas canvas, TextArea textArea) {
		
		canvas.setFocusTraversable(true);
		canvas.addEventFilter(MouseEvent.ANY, (e) -> canvas.requestFocus());
		
		canvas.setOnMouseClicked(e -> {
			
					gc.strokeText(textArea.getText(), e.getX(), e.getY());
			});
		

	}
}
