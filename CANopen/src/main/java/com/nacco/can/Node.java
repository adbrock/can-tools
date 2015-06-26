package com.nacco.can;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Node {
	private StringProperty name;
	private IntegerProperty id;
	private ObservableList<MainObject> mainObjectList;
	
	public Node() {
		name = new SimpleStringProperty(this, "name", "NewNode");
		id = new SimpleIntegerProperty(this, "id", 1);
		mainObjectList = FXCollections.observableArrayList();
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
	
	public int getId() {
		return this.id.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public IntegerProperty idProperty() {
		return this.id;
	}
	
	public Node addMainObject() {
		return null;
	}
	
	public void remove(MainObject mainObject) {
		this.mainObjectList.remove(mainObject);
	}
	
	public ObservableList<MainObject> getNodeList() {
		return this.mainObjectList;
	}
	
	protected List<DictionaryWarning> validate() {
		List<DictionaryWarning> warningList = new ArrayList<DictionaryWarning>();		
		return warningList;
	}
}
