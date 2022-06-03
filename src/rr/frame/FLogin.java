package rr.frame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FLogin extends Application{
	@Override
	public void start(Stage ps) throws Exception {
		Parent pa=FXMLLoader.load(this.getClass().getResource("/rr/fxml/FXMLLogin.fxml"));
		ps.setScene(new Scene(pa));
		ps.getIcons().add(new Image("/rr/ui/card-blue-1.png"));
		ps.setTitle("Ricochet Robots");
		ps.setResizable(false);
		ps.show();
	}
}
