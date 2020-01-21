package org.gui.options;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Option {

    private Properties appProps;



    public Option() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
    	//URL u = Thread.currentThread().getContextClassLoader().getResource("app.properties");
    	//String appConfigPath = u.getPath();
    	//String appConfigPath = "/C:/Users/User/eclipse-workspace/iMageForCV/gui/target/classes/app.properties";
        System.out.println(appConfigPath);
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

    public String getTheme(String theme) {
        return "theme/" + theme + "/style.css";
    }
}
