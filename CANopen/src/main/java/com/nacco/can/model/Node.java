package com.nacco.can.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Node {
	private StringProperty name;
	private IntegerProperty id;
	private StringProperty vendorName;
	private IntegerProperty vendorNumber;
	private StringProperty productName;
	private IntegerProperty productNumber;
	private IntegerProperty revisionNumber;
	private StringProperty orderCode;
	private IntegerProperty granularity;
	private IntegerProperty supportedReceivePDOs;
	private IntegerProperty supportedTransmitPDOs;
	private IntegerProperty supportedDynamicChannels;
	private BooleanProperty simpleBootUpMasterSupported;
	private BooleanProperty simpleBootUpSlaveSupported;
	private BooleanProperty groupMessagingSupported;
	private BooleanProperty layerSettingServiceSupported;
	private MapProperty<Integer, Boolean> supportedDummyMap;
	private MapProperty<Integer, Boolean> supportedBaudrateMap;
	private ListProperty<MainObject> mainObjectList;

	public Node() {
		name = new SimpleStringProperty(this, "name");
		id = new SimpleIntegerProperty(this, "id");
		vendorName = new SimpleStringProperty(this, "vendorName");
		vendorNumber = new SimpleIntegerProperty(this, "vendorNumber");
		productName = new SimpleStringProperty(this, "productName");
		productNumber = new SimpleIntegerProperty(this, "productNumber");
		revisionNumber = new SimpleIntegerProperty(this, "revisionNumber");
		orderCode = new SimpleStringProperty(this, "orderCode");
		granularity = new SimpleIntegerProperty(this, "granularity");
		supportedReceivePDOs = new SimpleIntegerProperty(this, "supportedReceivePDOs");
		supportedTransmitPDOs = new SimpleIntegerProperty(this, "supportedTransmitPDOs");
		supportedDynamicChannels = new SimpleIntegerProperty(this, "supportedDynamicChannels");
		simpleBootUpMasterSupported = new SimpleBooleanProperty(this, "simpleBootUpMasterSupported");
		simpleBootUpSlaveSupported = new SimpleBooleanProperty(this, "simpleBootUpSlaveSupported");
		groupMessagingSupported = new SimpleBooleanProperty(this, "groupMessagingSupported");
		layerSettingServiceSupported = new SimpleBooleanProperty(this, "layerSettingServiceSupported");
		supportedDummyMap = new SimpleMapProperty<Integer, Boolean>(this, "supportedDummyMap", FXCollections.observableHashMap());
		supportedBaudrateMap = new SimpleMapProperty<Integer, Boolean>(this, "supportedBaudrateMap", FXCollections.observableHashMap());
		mainObjectList = new SimpleListProperty<MainObject>(this, "mainObjectList", FXCollections.observableArrayList());
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

	public String getVendorName() {
		return this.vendorName.get();
	}

	public void setVendorName(String name) {
		this.name.set(name);
	}

	public StringProperty vendorNameProperty() {
		return this.vendorName;
	}

	public int getVendorNumber() {
		return this.vendorNumber.get();
	}

	public void setVendorNumber(int vendorNumber) {
		this.vendorNumber.set(vendorNumber);
	}

	public IntegerProperty vendorNumberProperty() {
		return this.vendorNumber;
	}

	public String getProductName() {
		return this.productName.get();
	}

	public void setProductName(String productName) {
		this.productName.set(productName);
	}

	public StringProperty productNameProperty() {
		return this.productName;
	}

	public int getProductNumber() {
		return this.productNumber.get();
	}

	public void setProductNumber(int productNumber) {
		this.productNumber.set(productNumber);
	}

	public IntegerProperty productNumberProperty() {
		return this.productNumber;
	}

	public int getRevisionNumber() {
		return this.revisionNumber.get();
	}

	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber.set(revisionNumber);
	}

	public IntegerProperty revisionNumberProperty() {
		return this.revisionNumber;
	}

	public String getOrderCode() {
		return this.orderCode.get();
	}

	public void setOrderCode(String orderCode) {
		this.orderCode.set(orderCode);
	}

	public StringProperty orderCodeProperty() {
		return this.orderCode;
	}

	public int getGranularity() {
		return this.granularity.get();
	}

	public void setGranularity(int granularity) {
		this.granularity.set(granularity);
	}

	public IntegerProperty granularityProperty() {
		return this.granularity;
	}

	public int getSupportedReceivePDOs() {
		return this.supportedReceivePDOs.get();
	}

	public void setSupportedReceivePDOs(int supportedReceivePDOs) {
		this.supportedReceivePDOs.set(supportedReceivePDOs);
	}

	public IntegerProperty supportedReceivePDOsProperty() {
		return this.supportedReceivePDOs;
	}

	public int getSupportedTransmitPDOs() {
		return this.supportedTransmitPDOs.get();
	}

	public void setSupportedTransmitPDOs(int supportedTransmitPDOs) {
		this.supportedTransmitPDOs.set(supportedTransmitPDOs);
	}

	public IntegerProperty supportedTransmitPDOsProperty() {
		return this.supportedTransmitPDOs;
	}

	public int getSupportedDynamicChannels() {
		return this.supportedDynamicChannels.get();
	}

	public void setSupportedDynamicChannels(int supportedDynamicChannels) {
		this.supportedDynamicChannels.set(supportedDynamicChannels);
	}

	public IntegerProperty supportedDyamicChannelsProperty() {
		return this.supportedDynamicChannels;
	}

	public boolean isSimpleBootUpMasterSupported() {
		return this.simpleBootUpMasterSupported.get();
	}

	public void setSimpleBootUpMasterSupported(boolean simpleBootUpMasterSupported) {
		this.simpleBootUpMasterSupported.set(simpleBootUpMasterSupported);
	}

	public BooleanProperty simpleBootUpMasterSupportedProperty() {
		return this.simpleBootUpMasterSupported;
	}

	public boolean isSimpleBootUpSlaveSupported() {
		return this.simpleBootUpSlaveSupported.get();
	}

	public void setSimpleBootUpSlaveSupported(boolean simpleBootUpSlaveSupported) {
		this.simpleBootUpSlaveSupported.set(simpleBootUpSlaveSupported);
	}

	public BooleanProperty simpleBootUpSlaveSupportedProperty() {
		return this.simpleBootUpSlaveSupported;
	}

	public boolean isGroupMessagingSupported() {
		return this.groupMessagingSupported.get();
	}

	public void setGroupMessagingSupported(boolean groupMessagingSupported) {
		this.groupMessagingSupported.set(groupMessagingSupported);
	}

	public BooleanProperty groupMessagingSupportedProperty() {
		return this.groupMessagingSupported;
	}

	public boolean isLayerSettingServiceSupported() {
		return this.layerSettingServiceSupported.get();
	}

	public void setLayerSettingServiceSupported(boolean layerSettingServiceSupported) {
		this.layerSettingServiceSupported.set(layerSettingServiceSupported);
	}

	public BooleanProperty layerSettingServiceSupportedProperty() {
		return this.layerSettingServiceSupported;
	}

	public ObservableMap<Integer, Boolean> getSupportedDummyMap() {
		return this.supportedDummyMap.get();
	}

	public MapProperty<Integer, Boolean> supportedDummyMapProperty() {
		return this.supportedDummyMap;
	}

	public ObservableMap<Integer, Boolean> getSupportedBaudrateMap() {
		return this.supportedBaudrateMap.get();
	}

	public MapProperty<Integer, Boolean> supportedBaudrateMapProperty() {
		return this.supportedBaudrateMap;
	}

	public ObservableList<MainObject> getMainObjectList() {
		return this.mainObjectList.get();
	}

	public ListProperty<MainObject> mainObjectListProperty() {
		return this.mainObjectList;
	}

	protected List<DictionaryWarning> validate() {
		List<DictionaryWarning> warningList = new ArrayList<DictionaryWarning>();
		return warningList;
	}
}
