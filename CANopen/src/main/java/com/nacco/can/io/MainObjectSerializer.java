package com.nacco.can.io;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.nacco.can.model.DataType;
import com.nacco.can.model.MainObject;
import com.nacco.can.model.ObjectType;
import com.nacco.can.model.SubObject;

public class MainObjectSerializer implements JsonSerializer<MainObject>, JsonDeserializer<MainObject> {

	@Override
	public JsonElement serialize(MainObject src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.getName());
		object.addProperty("index", src.getIndex());
		object.addProperty("objectType", src.getObjectType().toString());
		object.addProperty("dataType", src.getDataType().toString());
		object.addProperty("minValue", src.getMinValue());
		object.addProperty("maxValue", src.getMaxValue());
		
		JsonArray data = new JsonArray();
		for (Byte dataByte : src.getData()) {
			data.add(new JsonPrimitive(dataByte));
		}
		object.add("data", data);
		
		JsonArray subObjectList = new JsonArray();
		for (SubObject subObject : src.getSubObjectList()) {
			subObjectList.add(context.serialize(subObject, SubObject.class));
		}
		object.add("subObjectList", subObjectList);
		
		return object;		
	}

	@Override
	public MainObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		MainObject object = new MainObject();
		object.setName(json.getAsJsonObject().get("name").getAsString());
		object.setIndex(json.getAsJsonObject().get("index").getAsInt());
		object.setObjectType(ObjectType.fromString(json.getAsJsonObject().get("objectType").getAsString()));
		object.setDataType(DataType.fromString(json.getAsJsonObject().get("dataType").getAsString()));
		object.setMinValue(json.getAsJsonObject().get("minValue").getAsDouble());
		object.setMaxValue(json.getAsJsonObject().get("maxValue").getAsDouble());
		
		JsonArray jsonData = json.getAsJsonObject().get("data").getAsJsonArray();
		for (JsonElement element : jsonData) {
			object.getData().add(element.getAsByte());
		}
		
		JsonArray jsonSubObjectList = json.getAsJsonObject().get("subObjectList").getAsJsonArray();
		for (JsonElement element : jsonSubObjectList) {
			object.getSubObjectList().add(context.deserialize(element, SubObject.class));
		}
		
		return object;
	}
}
