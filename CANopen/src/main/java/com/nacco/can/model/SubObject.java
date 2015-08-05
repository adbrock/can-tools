package com.nacco.can.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubObject {
	private StringProperty name;
	private IntegerProperty subIndex;
	
	public SubObject() {
		this.name = new SimpleStringProperty(this, "name", "NewSubObject");
		this.subIndex = new SimpleIntegerProperty(this, "subIndex", 1);
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
	
	public int getSubIndex() {
		return this.subIndex.get();
	}
	
	protected void setSubIndex(int subIndex) {
		this.subIndex.set(subIndex);
	}
	
	public IntegerProperty subIndexProperty() {
		return this.subIndex;
	}
	
	protected List<DictionaryWarning> validate() {
		List<DictionaryWarning> warningList = new ArrayList<DictionaryWarning>();		
		return warningList;
	}
}
