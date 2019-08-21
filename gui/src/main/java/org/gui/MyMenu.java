package org.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyMenu extends MenuBar {

	public MyMenu(final Stage stage) {

		super();

		Menu m1 = new Menu("File");
		Menu m2 = new Menu("Help");

		final FileChooser fc = new FileChooser();

		final Stage st1 = new Stage();
		final Stage st2 = new Stage();

		final FlowPane fp = new FlowPane();

		st1.setTitle("About");
		st2.setTitle("Saving image");

		st1.setHeight(200);
		st1.setWidth(300);
		st1.setScene(new Scene(new Group(new Label("Описание базового плагина iMage"))));

		MenuItem i11 = new MenuItem("Load file");
		MenuItem i12 = new MenuItem("Exit");
		MenuItem i21 = new MenuItem("About");

		final Button b1 = new Button("Save");
		final Button b2 = new Button("Cancel");

		m1.getItems().add(i11);
		m1.getItems().add(i12);
		m2.getItems().add(i21);

		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				st1.show();
			}
		};

		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				stage.close();
			}
		};

		EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final File selectedFile = fc.showOpenDialog(stage);
				
				String localUrl = null;
				try {
					localUrl = selectedFile.toURI().toURL().toString();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				Image image = new Image(localUrl);
				ImageView imageView = new ImageView(image);
				fp.getChildren().addAll(b1, b2, imageView);
				Scene scene = new Scene(fp, 400, 200);
				st2.setScene(scene);
				st2.show();

				EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						
						File dest = new File("C:\\Users\\User\\eclipse-workspace\\testmavenproject\\gui\\src\\main", selectedFile.getName());
						InputStream is = null;
						OutputStream os = null;
						try {
							try {
								is = new FileInputStream(selectedFile);
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							try {
								os = new FileOutputStream(dest);
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							byte[] buffer = new byte[1024];
							int length;
							try {
								while ((length = is.read(buffer)) > 0) {
									os.write(buffer, 0, length);
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} finally {
							try {
								is.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							try {
								os.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				};

				b1.setOnAction(event5);
			}
		};

		EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				st2.close();
			}
		};

		i21.setOnAction(event1);
		i12.setOnAction(event2);
		i11.setOnAction(event3);
		b2.setOnAction(event4);
		

		this.getMenus().add(m1);
		this.getMenus().add(m2);

	}

}
