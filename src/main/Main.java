package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.IOService;

import java.io.IOException;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("layout/layout_main.fxml"));
		primaryStage.getIcons().add(new Image("file:src/res/picture/ic_converter.png"));
		primaryStage.setTitle("GPA 换算器");
		primaryStage.setScene(new Scene(root, 360, 600));
		primaryStage.show();
	}


	public static void main(String[] args) {
		try {
			IOService.readStudent(IOService.DATA_FILE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		launch(args);
	}
}
