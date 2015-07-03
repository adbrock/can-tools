package com.nacco.fxtensions;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;

import com.nacco.can.MainObject;
import com.nacco.can.Node;
import com.nacco.can.SubObject;

public class NodeView extends AnchorPane {

	@FXML TreeTableView<Object> dictionaryTable;

	public ObjectProperty<Node> node;
	public StringProperty title;
	private TreeItem<Object> root;

	public NodeView(Node node) throws IOException {
		FXMLLoader loader = new FXMLLoader(NetworkView.class.getResource("NodeView.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		loader.load();

		this.node = new SimpleObjectProperty<Node>(this, "node", node);
		this.title = new SimpleStringProperty(this, "title");
		title.bind(node.idProperty().asString().concat(" - ").concat(node.nameProperty()));

		for (MainObject mainObject : node.getMainObjectList()) {
			addMainObject(mainObject);
		}

		node.getMainObjectList().addListener(new ListChangeListener<MainObject>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends MainObject> change) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						while (change.next()) {
							for (MainObject mainObject : change.getAddedSubList()) {
								addMainObject(mainObject);
							}
							for (MainObject mainObject : change.getRemoved()) {
								removeMainObject(mainObject);
							}
						}
					}
				});
			}
		});
	}

	@FXML
	public void initialize() {
		this.root = new TreeItem<Object>(null);
		dictionaryTable.setShowRoot(false);
		dictionaryTable.setRoot(root);
	}

	public Node getNode() {
		return this.node.get();
	}

	public ReadOnlyObjectProperty<Node> nodeProperty() {
		return new ReadOnlyObjectWrapper<Node>(this, "node", this.node.get());
	}

	public String getTitle() {
		return title.get();
	}

	public ReadOnlyStringProperty titleProperty() {
		return new ReadOnlyStringWrapper(this, "title", title.get());
	}

	private void addMainObject(MainObject mainObject) {
		TreeItem<Object> newItem = new TreeItem<Object>(mainObject);
		for (SubObject subObject : mainObject.getSubObjectList()) {
			addSubObject(newItem, subObject);
		}
		mainObject.getSubObjectList().addListener(new ListChangeListener<SubObject>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends SubObject> change) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						while (change.next()) {
							for (SubObject subObject : change.getAddedSubList()) {
								addSubObject(newItem, subObject);
							}
							for (SubObject subObject : change.getRemoved()) {
								removeSubObject(newItem, subObject);
							}
						}
					}
				});

			}
		});
		root.getChildren().add(newItem);
	}

	private void removeMainObject(MainObject mainObject) {
		for (Iterator<TreeItem<Object>> iterator = root.getChildren().iterator(); iterator.hasNext();) {
			if (iterator.next().getValue().equals(mainObject)) {
				iterator.remove();
			}
		}
	}

	private void addSubObject(TreeItem<Object> mainObject, SubObject subObject) {
		TreeItem<Object> newItem = new TreeItem<Object>(subObject);
		mainObject.getChildren().add(newItem);
	}

	private void removeSubObject(TreeItem<Object> mainObject, SubObject subObject) {
		for (Iterator<TreeItem<Object>> iterator = mainObject.getChildren().iterator(); iterator.hasNext();) {
			if (iterator.next().getValue().equals(subObject)) {
				iterator.remove();
			}
		}
	}
}
