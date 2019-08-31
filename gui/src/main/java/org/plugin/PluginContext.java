package org.plugin;

import org.gui.App;

public class PluginContext {

   private final App app;


    public PluginContext(App app) {
        this.app = app;
    }

    public App getApp() {
        return app;
    }
}
