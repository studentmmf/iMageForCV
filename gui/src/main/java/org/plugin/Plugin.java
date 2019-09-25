package org.plugin;


/**
 * Each plugin for iMage must extended this class. It's a connector
 * plugin of developer and systen.
 * @version  1.0
 *
 */
public abstract class Plugin {



    private PluginContext context;

    /**
     * @return The text for the menu labels for the plugin
     */
    public abstract String getMenuText();

    /**
     *
     * @return The name of the plug in
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

    /**
     *
     * @return Price of plugin.
     */
    public abstract String getPrice();

    /**
     *
     * @return Description what the plugin do.
     */
    public abstract String getDescription();

    /**
     *
     * @return the contact inforamtion with author of the plugin.
     * It may be e-mail or url of website of autor.
     */
    public abstract String getContact();
}
