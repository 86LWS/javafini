package rr.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import rr.data.RRData;
import rr.frame.FMaster;

public class CLogin implements Initializable{
	@FXML
	private Label tip;
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	/**
	 * 模式1
	 */
	public void onAction1() {
		try {
			RRData.mode=1;
			new FMaster().start(new Stage());
			((Stage)tip.getScene().getWindow()).close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 模式2
	 */
	public void onAction2() {
		try {
			RRData.mode=2;
			new FMaster().start(new Stage());
			((Stage)tip.getScene().getWindow()).close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 模式3
	 */
	public void onAction3() {
		try {
			RRData.mode=3;
			new FMaster().start(new Stage());
			((Stage)tip.getScene().getWindow()).close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
