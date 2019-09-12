package org.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Pencil implements Draw {

	public Pencil(GraphicsContext gc, Canvas canvas) {
		draw(gc, canvas);
	}

	@Override
	public void draw(GraphicsContext gc, Canvas canvas) {
		canvas.setOnMousePressed(e -> {

			gc.beginPath();
			gc.moveTo(e.getX(), e.getY());
			gc.stroke();

		});

		canvas.setOnMouseDragged(e -> {

			gc.lineTo(e.getX(), e.getY());
			gc.stroke();

		});

	}

}
