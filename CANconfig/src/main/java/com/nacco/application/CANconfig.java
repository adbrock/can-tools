package com.nacco.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nacco.can.io.MainObjectSerializer;
import com.nacco.can.io.NetworkSerializer;
import com.nacco.can.io.NodeSerializer;
import com.nacco.can.io.SubObjectSerializer;
import com.nacco.can.model.MainObject;
import com.nacco.can.model.Network;
import com.nacco.can.model.SubObject;
import com.nacco.fxtensions.NetworkView;

public class CANconfig extends Application {
	@FXML protected StackPane mainContentPane;
	@FXML protected HBox contextToolbar;

	private Gson prettyGson;

	private Stage primaryStage;
	private NetworkView networkView;

	private ObjectProperty<Network> network;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		FXMLLoader loader = new FXMLLoader(CANconfig.class.getResource("CANconfig.fxml"));
		loader.setController(this);
		Scene scene = new Scene(loader.load());

		primaryStage.setScene(scene);
		primaryStage.setTitle("CANconfig");
		primaryStage.show();
	}

	@FXML
	protected void initialize() {
		prettyGson = createPrettyGson();

		network = new SimpleObjectProperty<Network>(this, "network", new Network());

		try {
			networkView = new NetworkView(network);
		} catch (IOException ex) {
			// TODO
			ex.printStackTrace();
		}

		mainContentPane.getChildren().add(networkView);
		handleShowNetworkPerspectiveAction();
	}

	@FXML
	protected void handleNewAction() {

	}

	@FXML
	protected void handleOpenAction() {

	}

	@FXML
	protected void handleSaveAsAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save As...");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Network Files", "*.ntwk"));
		File chosenFile = fileChooser.showSaveDialog(primaryStage);
		if (chosenFile != null) {
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(chosenFile.getAbsolutePath()), "utf-8"))) {
				writer.write(prettyGson.toJson(this.network.get()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	protected void handleShowNetworkPerspectiveAction() {
		contextToolbar.getChildren().clear();
		contextToolbar.getChildren().addAll(networkView.getContextButtons());

		for (Node node : mainContentPane.getChildren()) {
			node.setVisible(false);
		}
		networkView.setVisible(true);

	}

	@FXML
	protected void handleCloseAction() {
		Platform.exit();
	}

	private Gson createPrettyGson() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Network.class, new NetworkSerializer());
		builder.registerTypeAdapter(Node.class, new NodeSerializer());
		builder.registerTypeAdapter(MainObject.class, new MainObjectSerializer());
		builder.registerTypeAdapter(SubObject.class, new SubObjectSerializer());
		builder.setPrettyPrinting();
		return builder.create();
	}
}
