package rr.frame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import rr.function.playmusic;

public class FMaster extends Application{
	@Override
	public void start(Stage ps) throws Exception {
		Parent pa=FXMLLoader.load(this.getClass().getResource("/rr/fxml/FXMLMaster.fxml"));
		ps.setScene(new Scene(pa));
		ps.setTitle("Ricochet Robots");
		ps.setResizable(false);
		ps.getIcons().add(new Image("/rr/ui/card-blue-1.png"));
		ps.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		new playmusic().play();
		ps.show();
	}
}
