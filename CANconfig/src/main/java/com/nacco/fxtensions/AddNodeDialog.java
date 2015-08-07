package com.nacco.fxtensions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.nacco.can.model.Baudrate;
import com.nacco.can.model.Node;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddNodeDialog extends Dialog<ButtonType> {
	@FXML protected TextField txtName;
	@FXML protected TextField txtVendor;
	@FXML protected TableView<Map<Baudrate, Boolean>> tblBaudrate;
	@FXML protected TableColumn<Map<Baudrate, Boolean>, Baudrate> clmBaudrate;
	@FXML protected TableColumn<Map<Baudrate, Boolean>, Boolean> clmSupported;

	private ObjectProperty<Node> node;

	public AddNodeDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(AddNodeDialog.class.getResource("AddNodeDialog.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}

	@FXML
	protected void initialize() {
		node = new SimpleObjectProperty<Node>(this, "node", new Node());
		
		clmBaudrate.setCellValueFactory(new PropertyValueFactory(""));
	}
}
