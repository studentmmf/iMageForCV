package org.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Rubber implements Draw {

	public Rubber(GraphicsContext gc, Canvas canvas) {
		draw(gc, canvas);
	}

	@Override
	public void draw(GraphicsContext gc, Canvas canvas) {
		canvas.setOnMousePressed(e -> {

			//double lineWidth = gc.getLineWidth();
			//gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			gc.clearRect(e.getX() - 2, e.getY() - 2, 4, 4);
		});

		canvas.setOnMouseDragged(e -> {

			//double lineWidth = gc.getLineWidth();
			//gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			gc.clearRect(e.getX() - 2, e.getY() - 2, 4, 4);
		});

	}

}
