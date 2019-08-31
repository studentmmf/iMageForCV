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
import org.gui.messages.Messages;
import org.gui.options.Option;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static org.gui.messages.Constants.TITLE_OF_FRAME;

@Component
public class App extends Application {

	private Option opt;
	private Messages mes;

	public static void main(String[] args) {

		launch(args);
	}

	public App() {
		opt = new Option();
		mes = new Messages(Locale.ENGLISH);
	}
	@Override
	public void start(Stage stage) {

		stage.setTitle(mes.getString(TITLE_OF_FRAME));
		MyMenu menu = new MyMenu(this,stage);

		VBox vbox = new VBox(menu);
		Scene scene = new Scene(vbox, opt.width(), opt.height());

		stage.setScene(scene);
		stage.show();
	}

	public Option getOption() {
		return opt;
	}

	public Messages getMessages() {
		return mes;
	}
}
