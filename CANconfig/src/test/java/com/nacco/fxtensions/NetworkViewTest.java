package com.nacco.fxtensions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.nacco.can.model.MainObject;
import com.nacco.can.model.Network;
import com.nacco.can.model.Node;
import com.nacco.can.model.SubObject;

public class NetworkViewTest extends Application {

	public static void main(String[] args) {
		NetworkViewTest.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Network network = new Network();
		Node node1 = new Node();
		Node node2 = new Node();
		MainObject object1 = new MainObject();
		MainObject object2 = new MainObject();
		SubObject sub1 = new SubObject();
		SubObject sub2 = new SubObject();
		object1.getSubObjectList().add(sub1);
		object1.getSubObjectList().add(sub2);
		node1.getMainObjectList().add(object1);
		node2.getMainObjectList().add(object2);
		network.getNodeList().add(node1);
		network.getNodeList().add(node2);

		node1.setId(0x11);
		node2.setId(0x12);
		node1.setName("Combi");
		node2.setName("Traction");

		NetworkView networkView = new NetworkView(network);

		Scene scene = new Scene(networkView);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Network View Test");
		primaryStage.show();
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					Node node3 = new Node();
					network.getNodeList().add(node3);
					network.getNodeList().get(0).getMainObjectList().add(new MainObject());
					network.getNodeList().get(1).getMainObjectList().get(0).getSubObjectList().add(new SubObject());
					Thread.sleep(1000);
					network.getNodeList().remove(2);
					network.getNodeList().get(1).getMainObjectList().remove(0);
					network.getNodeList().get(0).getMainObjectList().get(0).getSubObjectList().remove(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}								
			}			
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
	}
}
