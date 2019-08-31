package org.gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Option {

    private Properties appProps;


    public Option() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProp(String key) {
        return appProps.getProperty(key);
    }

    public int width() {
        try {
            return  Integer.parseInt(getProp("width"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int height() {
        try {
            return  Integer.parseInt(getProp("height"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
