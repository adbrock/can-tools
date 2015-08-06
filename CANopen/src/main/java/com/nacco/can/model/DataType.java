package com.nacco.can.model;

public enum DataType {
	UNSIGNED, SIGNED, REAL, ASCII, UNICODE;
	
	public static DataType fromString(String input) {
		for (DataType dataType : DataType.values()) {
			if (dataType.toString().equals(input)) {
				return dataType;
			}
		}
		return null;
	}
}
