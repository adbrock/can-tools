package com.nacco.can.io;

import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nacco.can.model.DataType;
import com.nacco.can.model.MainObject;
import com.nacco.can.model.Network;
import com.nacco.can.model.Node;
import com.nacco.can.model.SubObject;

public class SerializationTest {
	
	public static void main(String[] args) throws UnknownHostException {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Network.class, new NetworkSerializer());
		builder.registerTypeAdapter(Node.class, new NodeSerializer());
		builder.registerTypeAdapter(MainObject.class, new MainObjectSerializer());
		builder.registerTypeAdapter(SubObject.class, new SubObjectSerializer());
		builder.setPrettyPrinting();		
		Gson gson = builder.create();
		
		MainObject mainObject = new MainObject();
		mainObject.setIndex(0x1000);
		mainObject.setName("Identity");
		mainObject.setDataType(DataType.ASCII);
		mainObject.getSubObjectList().add(new SubObject());
		
		System.out.println(gson.toJson(mainObject));
	}
}
