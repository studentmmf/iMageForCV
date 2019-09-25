package org.gui;

import org.gui.instruments.InstrumentContainer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {

    private Context() {}

    public static InstrumentContainer getContext() {

        ClassPathXmlApplicationContext cxl = new ClassPathXmlApplicationContext("applicationContext.xml");
        InstrumentContainer c = cxl.getBean("instrumentContainer", InstrumentContainer.class);
        cxl.close();
        return  c;
    }
}
