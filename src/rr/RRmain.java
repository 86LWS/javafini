package rr;

import javafx.application.Application;
import javafx.stage.Stage;
import rr.frame.FLogin;

public class RRmain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		new FLogin().start(new Stage());
	}
	public static void main(String[] args) {
		launch(args);
	}
}
