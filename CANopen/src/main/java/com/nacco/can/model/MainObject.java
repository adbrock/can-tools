package com.nacco.can.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainObject {
	private StringProperty name;
	private IntegerProperty index;
	private ObjectProperty<ObjectType> objectType;
	private ObjectProperty<DataType> dataType;
	private ObjectProperty<AccessType> accessType;
	private IntegerProperty dataLength;
	private DoubleProperty minValue;
	private DoubleProperty maxValue;
	private BooleanProperty parameter;
	private BooleanProperty diagnostic;
	private ListProperty<Byte> data;
	private ListProperty<SubObject> subObjectList;

	public MainObject() {
		this.name = new SimpleStringProperty(this, "name", "NewMainObject");
		this.index = new SimpleIntegerProperty(this, "index", 0x2000);
		this.objectType = new SimpleObjectProperty<ObjectType>(this, "objectType", ObjectType.VAR);
		this.dataType = new SimpleObjectProperty<DataType>(this, "dataType", DataType.UNSIGNED);
		this.accessType = new SimpleObjectProperty<AccessType>(this, "accessType", AccessType.RW);
		this.minValue = new SimpleDoubleProperty(this, "minValue", 0.0);
		this.maxValue = new SimpleDoubleProperty(this, "maxValue", 255.0);
		this.dataLength = new SimpleIntegerProperty(this, "dataLength", 8);
		this.minValue = new SimpleDoubleProperty(this, "minValue", 0);
		this.maxValue = new SimpleDoubleProperty(this, "maxValue", 255);
		this.parameter = new SimpleBooleanProperty(this, "parameter", false);
		this.diagnostic = new SimpleBooleanProperty(this, "diagnostic", false);
		this.data = new SimpleListProperty<Byte>(this, "data", FXCollections.observableArrayList());
		this.subObjectList = new SimpleListProperty<SubObject>(this, "subObjectList", FXCollections.observableArrayList());
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

	public void setIndex(int index) {
		this.index.set(index);
	}

	public IntegerProperty indexProperty() {
		return this.index;
	}	
	
	public ObjectType getObjectType() {
		return this.objectType.get();
	}
	
	public void setObjectType(ObjectType objectType) {
		this.objectType.set(objectType);
	}
	
	public ObjectProperty<ObjectType> objectTypeProperty() {
		return this.objectType;
	}
	
	public DataType getDataType() {
		return this.dataType.get();
	}
	
	public void setDataType(DataType dataType) {
		this.dataType.set(dataType);
	}
	
	public ObjectProperty<DataType> dataTypeProperty() {
		return this.dataType;
	}
	
	public AccessType getAccessType() {
		return this.accessType.get();
	}

	public void setAccessType(AccessType accessType) {
		this.accessType.set(accessType);
	}

	public ObjectProperty<AccessType> accessTypeProperty() {
		return this.accessType;
	}
	
	public int getDataLength() {
		return this.dataLength.get();
	}
	
	public void setDataLength(int dataLength) {
		this.dataLength.set(dataLength);
	}
	
	public IntegerProperty dataLengthProperty() {
		return this.dataLength;
	}
	
	public double getMinValue() {
		return this.minValue.get();
	}
	
	public void setMinValue(double minValue) {
		this.minValue.set(minValue);
	}
	
	public DoubleProperty minValueProperty() {
		return this.minValue;
	}
	
	public double getMaxValue() {
		return this.maxValue.get();
	}
	
	public void setMaxValue(double maxValue) {
		this.maxValue.set(maxValue);
	}
	
	public DoubleProperty maxValueProperty() {
		return this.maxValue;
	}

	public ObservableList<Byte> getData() {
		return this.data.get();
	}

	public ListProperty<Byte> dataProperty() {
		return this.data;
	}

	public ObservableList<SubObject> getSubObjectList() {
		return this.subObjectList.get();
	}

	public ListProperty<SubObject> subObjectListProperty() {
		return this.subObjectList;
	}
}
