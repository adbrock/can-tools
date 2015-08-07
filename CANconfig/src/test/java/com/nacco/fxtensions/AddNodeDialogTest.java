package com.nacco.fxtensions;

import com.nacco.can.Network;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddNodeDialogTest extends Application {

	public static void main(String[] args) {
		AddNodeDialogTest.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AddNodeDialog dialog = new AddNodeDialog();

		Scene scene = new Scene(new AnchorPane());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Network View Test");
		primaryStage.show();
		dialog.showAndWait().ifPresent(response -> {
			if (response.getButtonData().equals(ButtonData.OK_DONE)) {
				System.out.println("OK!");
			}
		});
	}
}