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

public class MainObject implements CANObject {
	private StringProperty name;
	private IntegerProperty index;
	private ObjectProperty<ObjectType> objectType;
	private ObjectProperty<DataType> dataType;
	private ObjectProperty<AccessType> accessType;
	private ObjectProperty<Endianness> endianness;
	private ObjectProperty<byte[]> data;
	private IntegerProperty dataLength;
	private DoubleProperty minValue;
	private DoubleProperty maxValue;
	private BooleanProperty parameter;
	private BooleanProperty diagnostic;
	private ListProperty<SubObject> subObjectList;

	public MainObject() {
		this.name = new SimpleStringProperty(this, "name", "NewMainObject");
		this.index = new SimpleIntegerProperty(this, "index", 0x2000);
		this.objectType = new SimpleObjectProperty<ObjectType>(this, "objectType", ObjectType.VAR);
		this.dataType = new SimpleObjectProperty<DataType>(this, "dataType", DataType.UNSIGNED);
		this.accessType = new SimpleObjectProperty<AccessType>(this, "accessType", AccessType.RW);
		this.endianness = new SimpleObjectProperty<Endianness>(this, "endianness", Endianness.BIG_ENDIAN);
		this.data = new SimpleObjectProperty<byte[]>(this, "data", new byte[1]);
		this.dataLength = new SimpleIntegerProperty(this, "dataLength", 8);
		this.minValue = new SimpleDoubleProperty(this, "minValue", 0);
		this.maxValue = new SimpleDoubleProperty(this, "maxValue", 255);
		this.parameter = new SimpleBooleanProperty(this, "parameter", false);
		this.diagnostic = new SimpleBooleanProperty(this, "diagnostic", false);
		this.subObjectList = new SimpleListProperty<SubObject>(this, "subObjectList", FXCollections.observableArrayList());
	}

	@Override
	public String getName() {
		return this.name.get();
	}

	@Override
	public void setName(String name) {
		this.name.set(name);
	}

	@Override
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
	
	@Override
	public ObjectType getObjectType() {
		return this.objectType.get();
	}
	
	@Override
	public void setObjectType(ObjectType objectType) {
		this.objectType.set(objectType);
	}
	
	@Override
	public ObjectProperty<ObjectType> objectTypeProperty() {
		return this.objectType;
	}
	
	@Override
	public DataType getDataType() {
		return this.dataType.get();
	}
	
	@Override
	public void setDataType(DataType dataType) {
		this.dataType.set(dataType);
	}
	
	@Override
	public ObjectProperty<DataType> dataTypeProperty() {
		return this.dataType;
	}
	
	@Override
	public AccessType getAccessType() {
		return this.accessType.get();
	}

	@Override
	public void setAccessType(AccessType accessType) {
		this.accessType.set(accessType);
	}

	@Override
	public ObjectProperty<AccessType> accessTypeProperty() {
		return this.accessType;
	}
	
	@Override
	public Endianness getEndianness() {
		return this.endianness.get();
	}

	@Override
	public void setEndianness(Endianness endianness) {
		this.endianness.set(endianness);
	}

	@Override
	public ObjectProperty<Endianness> endiannessProperty() {
		return this.endianness;
	}
	
	@Override
	public byte[] getData() {
		return this.data.get();
	}

	@Override
	public void setData(byte[] data) {
		this.data.set(data);		
	}

	@Override
	public ObjectProperty<byte[]> dataProperty() {
		return this.data;
	}
	
	@Override
	public int getDataLength() {
		return this.dataLength.get();
	}
	
	@Override
	public void setDataLength(int dataLength) {
		this.dataLength.set(dataLength);
	}
	
	@Override
	public IntegerProperty dataLengthProperty() {
		return this.dataLength;
	}
	
	@Override
	public double getMinValue() {
		return this.minValue.get();
	}
	
	@Override
	public void setMinValue(double minValue) {
		this.minValue.set(minValue);
	}
	
	@Override
	public DoubleProperty minValueProperty() {
		return this.minValue;
	}
	
	@Override
	public double getMaxValue() {
		return this.maxValue.get();
	}
	
	@Override
	public void setMaxValue(double maxValue) {
		this.maxValue.set(maxValue);
	}
	
	@Override
	public DoubleProperty maxValueProperty() {
		return this.maxValue;
	}

	public ObservableList<SubObject> getSubObjectList() {
		return this.subObjectList.get();
	}

	public ListProperty<SubObject> subObjectListProperty() {
		return this.subObjectList;
	}
}
