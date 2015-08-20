package com.nacco.can.io;

import java.io.FileNotFoundException;

import javax.script.ScriptException;

import com.nacco.can.model.DataTypeManager;

public class Shdtf {

	public static void main(String args[]) throws ScriptException, FileNotFoundException {
		System.setProperty("user.dir", "C:/Users/agabrock/Desktop/");
		DataTypeManager mgr = DataTypeManager.getInstance();
		mgr.load();
		
		System.out.println(mgr.getAvailableDataTypes());		
	}
}
