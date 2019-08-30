package org.plugin;


/**
 * Each plugin for iMage must extended this class. It's a connector
 * plugin of developer and systen.
 * @version  1.0
 * @author  Dmitry Savkin
 */
public abstract class Plugin {



    private PluginContext context;

    /**
     * @return The text for the menu labels for the plugin
     */
    public abstract String getMenuText();

    /**
     *
     * @return the name of the plug in
     */
    public abstract String getName();

    /**
     * Run plugin
     */
    public abstract void run();

    /**
     * @return true if the plugin can be configured.
     */
    public abstract boolean isConfigurable();

    /**
     * Open a configuration dialogue.
     */
    public abstract void configure();

    public void init(PluginContext context) {
        this.context = context;
    }

    public abstract String getPrice();

    public abstract String getDescription();

    public abstract String getContact();
}
