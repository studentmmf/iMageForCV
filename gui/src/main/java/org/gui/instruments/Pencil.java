package org.gui.instruments;

import org.springframework.stereotype.Component;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

@Component
public class Pencil implements Draw {

	

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
