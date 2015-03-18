package com.mjj.javafx;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class HelloMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello javafx");
		Group root = new Group();
		Scene scene = new Scene(root,1024,768);
		Button button = new Button();

		MenuBar menubar = new MenuBar();
		Menu menu = new Menu("File");
		menu.getItems().add(new MenuItem("New"));
		menu.getItems().add(new MenuItem("Save"));		
		menu.getItems().add(new MenuItem("Exit"));

		menubar.getMenus().add(menu);

		button.setText("Hello");
		button.setLayoutX(100);
		button.setLayoutY(100);
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					Platform.exit();
			}
		});
		
		int x,y,radius,red,green,blue,font;
		Random rand = new Random(System.currentTimeMillis());
		Font serif,sanserif,dialog;


		for (int i=0;i<10 ;i++ ) {
			x = rand.nextInt((int)scene.getWidth());
			y = rand.nextInt((int)scene.getHeight());
			radius = rand.nextInt(360);
			red = rand.nextInt(255);
			green = rand.nextInt(255);
			blue = rand.nextInt(255);
			font = rand.nextInt(3);
			Text text = new Text(x,y,"JavaFX 2.0");

			switch(font) {
				case 0: text.setFont(Font.font("serif",rand.nextInt(30))); break;
				case 1: text.setFont(Font.font("SanSerif",rand.nextInt(30))); break;
				case 2: text.setFont(Font.font("Dialog",rand.nextInt(30))); break;
				default:
					text.setFont(Font.font("Dialog",rand.nextInt(30)));
			}
			
			text.setRotate(radius);
			text.setFill(Color.rgb(red,green,blue,.99));
			//root.getChildren().add(text);	
		}
		root.getChildren().add(menubar);
		

		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}