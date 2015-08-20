package com.nacco.can.model;

public enum Baudrate {
	K10, K20, K50, K125, K250, K500, K800, K1000;
	
	public static Baudrate fromString(String input) {
		for (Baudrate baudrate : Baudrate.values()) {
			if (baudrate.toString().equals(input)) {
				return baudrate;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString().substring(1) + "K";
	}
}
