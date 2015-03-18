package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			MenuBar menubar = new MenuBar();
			Menu menu = new Menu("File");
			menu.getItems().add(new MenuItem("New"));
			menu.getItems().add(new MenuItem("Save"));		
			menu.getItems().add(new MenuItem("Exit"));

			menubar.getMenus().add(menu);			
			Button button = new Button();

			button.setText("Hello");
			button.setLayoutX(100);
			button.setLayoutY(50);
			button.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});
			
			menubar.prefWidthProperty().bind(primaryStage.widthProperty());
			root.getChildren().add(menubar);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
