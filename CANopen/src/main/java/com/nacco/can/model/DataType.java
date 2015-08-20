package com.nacco.can.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptException;

public class DataType {
	private String name;
	private Invocable script;
	
	public DataType(File scriptFile) throws FileNotFoundException, ScriptException {
		name = scriptFile.getName().replace(".py", "");	
		DataTypeManager mgr = DataTypeManager.getInstance();
		script = (Invocable) mgr.getScriptEngine().eval(new BufferedReader(new FileReader(scriptFile)));		
	}
	
	public String toString(int bitLength, byte[] data) throws NoSuchMethodException, ScriptException {
		return (String) script.invokeFunction("toString", bitLength, data);
	}
	
	public byte[] fromString(int bitLength, String str) throws NoSuchMethodException, ScriptException {
		return (byte[]) script.invokeFunction("fromString", bitLength, str);
	}
	
	public boolean validateToString() {
		return true;
	}
	
	public boolean validateFromString() {
		return true;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
