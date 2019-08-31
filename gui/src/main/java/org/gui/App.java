/*package org.gui;


public class App 
{
	
    public static void main( String[] args )
    {
    	MainFrame mf = new MainFrame();
        
    }
}*/
package org.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private Option opt;
	public static void main(String[] args) {

		launch(args);
	}

	public App() {
		opt = new Option();
	}
	@Override
	public void start(Stage stage) {

		stage.setTitle("Hello JavaFX");
		MyMenu menu = new MyMenu(stage);

		VBox vbox = new VBox(menu);
		Scene scene = new Scene(vbox, opt.width(), opt.height());

		stage.setScene(scene);
		stage.show();
	}
}
