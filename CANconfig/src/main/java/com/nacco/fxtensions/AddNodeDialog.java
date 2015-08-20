package com.nacco.fxtensions;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;

import com.nacco.can.model.Baudrate;
import com.nacco.can.model.Node;

public class AddNodeDialog extends Dialog<ButtonType> {
	@FXML protected TextField txtName;
	@FXML protected TextField txtVendor;
	@FXML protected TableView<Pair<Baudrate, Boolean>> tblBaudrate;
	@FXML protected TableColumn<Pair<Baudrate, Boolean>, Baudrate> clmBaudrate;
	@FXML protected TableColumn<Pair<Baudrate, Boolean>, Boolean> clmSupported;

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

		tblBaudrate.setItems(node.get().getSupportedBaudrateList());
		tblBaudrate.setEditable(true);
		clmBaudrate.setCellValueFactory(new PropertyValueFactory<Pair<Baudrate, Boolean>, Baudrate>("key"));
		clmSupported.setCellValueFactory(new PropertyValueFactory<Pair<Baudrate, Boolean>, Boolean>("value"));
		clmSupported.setCellFactory(CheckBoxTableCell.forTableColumn(clmSupported));
		clmSupported.setEditable(true);
		
	}
}
