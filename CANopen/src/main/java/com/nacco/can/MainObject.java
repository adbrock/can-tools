package com.nacco.can;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainObject {
	private StringProperty name;
	private IntegerProperty index;
	private ObjectProperty<ObjectType> objectType;
	private ObservableList<SubObject> subObjectList;
	
	public MainObject() {
		this.name = new SimpleStringProperty(this, "name", "NewMainObject");
		this.index = new SimpleIntegerProperty(this, "index", 0x2000);
		this.objectType = new SimpleObjectProperty<ObjectType>(this, "objectType", ObjectType.VAR);
		this.subObjectList = FXCollections.observableArrayList();
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
	
	public int getIndex() {
		return this.index.get();
	}
	
	protected void setIndex(int index) {
		this.index.set(index);
	}
	
	public IntegerProperty indexProperty() {
		return this.index;
	}
	
	public ObservableList<SubObject> getSubObjectList() {
		return this.subObjectList;
	}
	
	protected List<DictionaryWarning> validate() {
		List<DictionaryWarning> warningList = new ArrayList<DictionaryWarning>();		
		return warningList;
	}
}
