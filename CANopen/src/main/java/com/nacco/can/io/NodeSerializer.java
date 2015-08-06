package com.nacco.can.io;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.nacco.can.model.Baudrate;
import com.nacco.can.model.MainObject;
import com.nacco.can.model.Node;

public class NodeSerializer implements JsonSerializer<Node>, JsonDeserializer<Node> {

	@Override
	public JsonElement serialize(Node src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.getName());
		object.addProperty("id", src.getId());
		object.addProperty("vendorName", src.getVendorName());
		object.addProperty("vendorNumber", src.getVendorNumber());
		object.addProperty("productName", src.getProductName());
		object.addProperty("productNumber", src.getProductNumber());
		object.addProperty("revisionNumber", src.getRevisionNumber());
		object.addProperty("orderCode", src.getOrderCode());
		object.addProperty("granularity", src.getGranularity());
		object.addProperty("supportedReceivePDOs", src.getSupportedReceivePDOs());
		object.addProperty("supportedTransmitPDOs", src.getSupportedTransmitPDOs());
		object.addProperty("supportedDynamicChannels", src.getSupportedDynamicChannels());
		object.addProperty("simpleBootUpMasterSupported", src.isSimpleBootUpMasterSupported());
		object.addProperty("simpleBootUpSlaveSupported", src.isSimpleBootUpSlaveSupported());
		object.addProperty("groupMessagingSupported", src.isGroupMessagingSupported());
		object.addProperty("layerSettingServiceSupported", src.isLayerSettingServiceSupported());
		// TODO Leaving out supported Dummy Map for now, may need to be removed.

		JsonObject supportedBaudrateMap = new JsonObject();
		for (Baudrate baudrate : Baudrate.values()) {
			supportedBaudrateMap.addProperty(baudrate.toString(), src.getSupportedBaudrateMap().get(baudrate));
		}
		object.add("supportedBaudrateMap", supportedBaudrateMap);

		JsonArray mainObjectList = new JsonArray();
		for (MainObject mainObject : src.getMainObjectList()) {
			mainObjectList.add(context.serialize(mainObject, MainObject.class));
		}
		object.add("mainObjectList", mainObjectList);

		return object;
	}

	@Override
	public Node deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Node object = new Node();
		object.setName(json.getAsJsonObject().get("name").getAsString());
		object.setId(json.getAsJsonObject().get("id").getAsInt());
		object.setVendorName(json.getAsJsonObject().get("vendorName").getAsString());
		object.setVendorNumber(json.getAsJsonObject().get("vendorNumber").getAsInt());
		object.setProductName(json.getAsJsonObject().get("productName").getAsString());
		object.setProductNumber(json.getAsJsonObject().get("productNumber").getAsInt());
		object.setRevisionNumber(json.getAsJsonObject().get("revisionNumber").getAsInt());
		object.setOrderCode(json.getAsJsonObject().get("orderCode").getAsString());
		object.setGranularity(json.getAsJsonObject().get("granularity").getAsInt());
		object.setSupportedReceivePDOs(json.getAsJsonObject().get("supportedReceivePDOs").getAsInt());
		object.setSupportedTransmitPDOs(json.getAsJsonObject().get("supportedTransmitPDOs").getAsInt());
		object.setSupportedDynamicChannels(json.getAsJsonObject().get("supportedDynamicChannels").getAsInt());
		object.setSimpleBootUpMasterSupported(json.getAsJsonObject().get("simpleBootUpMasterSupported").getAsBoolean());
		object.setSimpleBootUpSlaveSupported(json.getAsJsonObject().get("simpleBootUpSlaveSupported").getAsBoolean());
		object.setGroupMessagingSupported(json.getAsJsonObject().get("groupMessagingSupported").getAsBoolean());
		object.setLayerSettingServiceSupported(json.getAsJsonObject().get("layerSettingServiceSupported").getAsBoolean());

		JsonObject jsonSupportedBaudrateMap = json.getAsJsonObject().get("supportedBaudrateMap").getAsJsonObject();
		for (Baudrate baudrate : Baudrate.values()) {
			if (jsonSupportedBaudrateMap.get(baudrate.toString()) != null) {
				object.getSupportedBaudrateMap().put(baudrate, false);
			} else {
				object.getSupportedBaudrateMap().put(baudrate, jsonSupportedBaudrateMap.get(baudrate.toString()).getAsBoolean());
			}
		}
		
		JsonArray jsonMainObjectList = json.getAsJsonObject().get("mainObjectList").getAsJsonArray();
		for (JsonElement element : jsonMainObjectList) {
			object.getMainObjectList().add(context.deserialize(element, MainObject.class));
		}
		
		return object;
	}
}
