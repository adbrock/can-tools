package com.nacco.can.io;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.nacco.can.model.SubObject;

public class SubObjectSerializer implements JsonSerializer<SubObject>, JsonDeserializer<SubObject> {

	@Override
	public JsonElement serialize(SubObject src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.getName());
		object.addProperty("subObject", src.getSubIndex());
		
		return object;
	}
	
	
	@Override
	public SubObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		SubObject object = new SubObject();
		object.setName(json.getAsJsonObject().get("name").getAsString());
		object.setSubIndex(json.getAsJsonObject().get("subIndex").getAsInt());
		
		return object;
	}
}
