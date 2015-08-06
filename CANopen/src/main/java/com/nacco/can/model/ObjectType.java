package com.nacco.can.model;

public enum ObjectType {
	DEFVAR, DEFSTRUCT, VAR, ARRAY, RECORD;
	
	public static ObjectType fromString(String input) {
		for (ObjectType objectType : ObjectType.values()) {
			if (objectType.toString().equals(input)) {
				return objectType;
			}
		}
		return null;
	}
}
