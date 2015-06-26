package com.nacco.can;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Network {
	private StringProperty name;
	private ObservableList<Node> nodeList;
	
	public Network() {
		name = new SimpleStringProperty(this, "name", "NewNetwork");
		nodeList = FXCollections.observableArrayList();
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return this.name;
	}
	
	public Node addNode() {
		// TODO
		return null;
	}
	
	public void remove(Node node) {
		this.nodeList.remove(node);
	}
	
	public ObservableList<Node> getNodeList() {
		return this.nodeList;
	}
	
	protected List<DictionaryWarning> validate() {
		List<DictionaryWarning> warningList = new ArrayList<DictionaryWarning>();		
		return warningList;
	}
}
