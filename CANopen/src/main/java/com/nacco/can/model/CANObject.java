package com.nacco.can.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public interface CANObject {

	public String getName();

	public void setName(String name);

	public StringProperty nameProperty();

	public ObjectType getObjectType();

	public void setObjectType(ObjectType objectType);

	public ObjectProperty<ObjectType> objectTypeProperty();

	public DataType getDataType();

	public void setDataType(DataType dataType);

	public ObjectProperty<DataType> dataTypeProperty();

	public AccessType getAccessType();

	public void setAccessType(AccessType accessType);

	public ObjectProperty<AccessType> accessTypeProperty();

	public Endianness getEndianness();

	public void setEndianness(Endianness endianness);

	public ObjectProperty<Endianness> endiannessProperty();
	
	public byte[] getData();
	
	public void setData(byte[] data);
	
	public ObjectProperty<byte[]> dataProperty();

	public int getDataLength();

	public void setDataLength(int dataLength);

	public IntegerProperty dataLengthProperty();

	public double getMinValue();

	public void setMinValue(double minValue);

	public DoubleProperty minValueProperty();

	public double getMaxValue();

	public void setMaxValue(double maxValue);

	public DoubleProperty maxValueProperty();
}
