package com.nacco.fxtensions;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import com.nacco.can.Network;
import com.nacco.can.Node;

public class NetworkView extends AnchorPane {

	protected ObjectProperty<Network> network;
	protected TabPane networkTabPane;
	protected Tab addNodeTab;

	public NetworkView(Network network) throws IOException {
		this.network = new SimpleObjectProperty<Network>(this, "network", network);
		networkTabPane = new TabPane();
		addNodeTab = new Tab();

		AnchorPane.setTopAnchor(networkTabPane, 0.0);
		AnchorPane.setRightAnchor(networkTabPane, 0.0);
		AnchorPane.setBottomAnchor(networkTabPane, 0.0);
		AnchorPane.setLeftAnchor(networkTabPane, 0.0);

		addNodeTab.setText(" + ");
		addNodeTab.setClosable(false);
		networkTabPane.getTabs().add(addNodeTab);

		for (Node node : network.getNodeList()) {
			this.addNode(node);
		}

		EventHandler<Event> addNodeHandler = new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				NetworkView.this.addNode(new Node());
			}
		};
		addNodeTab.setOnSelectionChanged(addNodeHandler);
		if (network.getNodeList().size() == 0) {
			addNodeHandler.handle(null);
		}

		network.getNodeList().addListener(new ListChangeListener<Node>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> change) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						while (change.next()) {
							for (Node node : change.getAddedSubList()) {
								addNode(node);
							}
							for (Node node : change.getRemoved()) {
								removeNode(node);
							}
						}
					}
				});
			}
		});

		this.getChildren().add(networkTabPane);
	}

	private void addNode(Node node) {
		try {
			Tab newNodeTab = new Tab();
			NodeView newNodeView = new NodeView(node);
			newNodeTab.textProperty().bind(newNodeView.titleProperty());
			newNodeTab.setContent(newNodeView);
			networkTabPane.getTabs().add(networkTabPane.getTabs().indexOf(addNodeTab), newNodeTab);
			networkTabPane.getSelectionModel().select(newNodeTab);
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}

	private void removeNode(Node node) {
		for (Iterator<Tab> iterator = networkTabPane.getTabs().iterator(); iterator.hasNext();) {
			Tab tab = iterator.next();
			if (tab.getContent() instanceof NodeView) {
				if (((NodeView) tab.getContent()).getNode().equals(node)) {
					iterator.remove();
				}
			}
		}
	}

}
