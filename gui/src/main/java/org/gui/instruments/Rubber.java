package org.gui.instruments;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Rubber implements Draw {

	

	@Override
	public void draw(GraphicsContext gc, Canvas canvas) {
		
		canvas.setOnMousePressed(e -> {

			gc.clearRect(e.getX() - 2, e.getY() - 2, 4, 4);
		});

		canvas.setOnMouseDragged(e -> {

			gc.clearRect(e.getX() - 2, e.getY() - 2, 4, 4);
		});

	}

}
