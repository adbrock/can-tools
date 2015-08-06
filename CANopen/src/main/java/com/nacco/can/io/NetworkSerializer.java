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
import com.nacco.can.model.Network;
import com.nacco.can.model.Node;

public class NetworkSerializer implements JsonSerializer<Network>, JsonDeserializer<Network> {

	@Override
	public JsonElement serialize(Network src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.getName());
		
		JsonArray nodeList = new JsonArray();
		for (Node node : src.getNodeList()) {
			nodeList.add(context.serialize(node, Node.class));
		}
		object.add("nodeList", nodeList);
		
		return object;
	}
	
	@Override
	public Network deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Network object = new Network();
		object.setName(json.getAsJsonObject().get("name").getAsString());
		
		JsonArray jsonNodeList = json.getAsJsonObject().get("nodeList").getAsJsonArray();
		for (JsonElement element : jsonNodeList) {
			object.getNodeList().add(context.deserialize(element, Node.class));
		}
		
		return object;
	}
}
