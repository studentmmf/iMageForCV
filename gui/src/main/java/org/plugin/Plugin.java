package org.plugin;

/**
 * Each plugin for iMage must extended this class. It's a connector
 * plugin of developer and systen.
 * @version  1.0
 * @author  Dmitry Savkin
 */
public abstract class Plugin {


    private final String name;
    private final String version;
    private final String description;

    private String price;

    /**
     * Creates a plugin object, Sets price of plugin 0.0
     * @param name name of plugin
     * @param version version of plugin
     * @param description description what the plugin do
     */
    public Plugin(String name, String version, String description) {
        this.name = name;
        this.version = version;
        this.description = description;
    }

    /**
     * Creates a plugin object
     * @param name name of plugin
     * @param version version of plugin
     * @param description description what the plugin do
     * @param  price price of plugin
     */
    public Plugin(String name, String version, String description, String price) {
        this.name = name;
        this.version = version;
        this.description = description;
        this.price = price;

    }

    /**
     * Each plugin has called by this method.
     */
    public  abstract  void involke();

    /**
     * Gets name of plugin
     * @return name of plugin
     */
    public String getName() {
        return name;
    }

    /**
     * Gets version of plugin
     * @return version of plugin
     */
    public String getVersion() {
        return version;
    }

    /**
     * Gets description of plugin
     * @return what a plugin do
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets price of plugin.
     * @return price of plugin or  text "free" if plugin is free for using.
     */
    public String getPrice() {
        if (price.isEmpty() || price.equals("0")) {
            return  "free";
        }
        return price;
    }
}
