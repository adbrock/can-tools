package com.nacco.can.model;

public enum Endianness {
	BIG_ENDIAN,
	LITTLE_ENDIAN;
	
	public static Endianness fromString(String input) {
		for (Endianness endianness : Endianness.values()) {
			if (endianness.toString().equals(input)) {
				return endianness;
			}
		}
		return null;
	}
}
