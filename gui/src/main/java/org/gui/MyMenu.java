package org.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static org.gui.messages.Constants.FILE_MENU;
import static org.gui.messages.Constants.HELP_MENU;


public class MyMenu extends MenuBar {

	private final App app;
	private Stage st1;
	private Stage st2;
	private Image image;
	private ImageView imageView;
	private File selectedFile;
	private String localUrl;
	
	

	public MyMenu(App app, final Stage stage) {

		super();
		this.app = app;
		Menu m1 = new Menu(app.getMes().getString(FILE_MENU));
		Menu m2 = new Menu(app.getMes().getString(HELP_MENU));

		final FileChooser fc = new FileChooser();

		
		st1 = new Stage();
		st2 = new Stage();

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

		final Slider s1 = new Slider(100.0, 500.0, 200.0);
		final Slider s2 = new Slider(100.0, 500.0, 200.0);

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
				
				selectedFile = fc.showOpenDialog(stage);
				localUrl = null;
				try {
					localUrl = selectedFile.toURI().toURL().toString();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				
				image = new Image(localUrl, 200, 200, false, false);
				
				imageView = new ImageView(image);
				fp.getChildren().addAll(s1, s2, b1, b2);
				fp.setPadding(new Insets(20));
				BorderPane bp = new BorderPane(imageView, null, null, fp, null);
				Scene scene = new Scene(bp, 600, 600);
				st2.setScene(scene);
				st2.show();
				
				s1.valueProperty().addListener(new ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> observable, //
							Number oldValue, Number newValue) {
						
						image = new Image(localUrl, newValue.intValue(), newValue.intValue(), false, false);
						
						imageView = new ImageView(image);
						BorderPane bp = new BorderPane(imageView, null, null, fp, null);
						Scene scene = new Scene(bp, 600, 600);
						st2.setScene(scene);
						st2.show();
						
						
					}
				});
				
				s2.valueProperty().addListener(new ChangeListener<Number>() {/////////////////////////////////
					public void changed(ObservableValue<? extends Number> observable, //
							Number oldValue, Number newValue) {
						
						image = new Image(localUrl, newValue.intValue(), newValue.intValue(), false, false);
						
						
						
						imageView = new ImageView(image);
						BorderPane bp = new BorderPane(imageView, null, null, fp, null);
						Scene scene = new Scene(bp, 600, 600);
						st2.setScene(scene);
						st2.show();
						
						
						
					}
				});
				
				EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						BorderPane bp = new BorderPane(imageView, null, null, null, null);
						stage.setScene(new Scene(bp, 600, 600));
						stage.show();
					}
				};
				b1.setOnAction(event5);
			}
			
			
		};
				
				
				
				
				

				/*EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						File dest = new File("C:\\Users\\User\\eclipse-workspace\\testmavenproject\\gui\\src\\main",
								selectedFile.getName());
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
				};*/

				
		

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
