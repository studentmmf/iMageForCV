
package org.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.gui.messages.Messages;
import org.gui.options.Option;
import org.gui.options.Theme;

import java.util.Locale;

import static org.gui.messages.Constants.TITLE_OF_FRAME;

public class App extends Application {

	private Option opt;
	private Messages mes;
	private String currentTheme;

	public static void main(String[] args) {

		launch(args);
	}

	public App() {
		opt = new Option();
		currentTheme = opt.getTheme(Theme.STANDARD);
		mes = new Messages(Locale.ENGLISH);

	}
	@Override
	public void start(Stage stage) {

		stage.setTitle(mes.getString(TITLE_OF_FRAME));
		AppMenu menu = new AppMenu(this,stage);

		VBox vbox = new VBox(menu);
		Scene scene = new Scene(vbox, opt.width(), opt.height());
		scene.getStylesheets().add(currentTheme);
		stage.setScene(scene);
		stage.show();
	}

	public Option getOption() {
		return opt;
	}

	public Messages getMessages() {
		return mes;
	}

	public String getCurrentTheme() {
		return currentTheme;
	}
}
