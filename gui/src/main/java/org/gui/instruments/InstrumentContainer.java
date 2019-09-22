package org.gui.instruments;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class InstrumentContainer {

    private Pencil pencil;

    private Rubber rubber;


    @Autowired
    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    @Autowired
    public void setRubber(Rubber rubber) {
        this.rubber = rubber;
    }

    public void drawPencil(GraphicsContext gc, Canvas c) {
        pencil.draw(gc,c);
    }

    public void drawRubber(GraphicsContext gc, Canvas c) {
        rubber.draw(gc,c);
    }
}
