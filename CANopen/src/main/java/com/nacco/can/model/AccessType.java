package com.nacco.can.model;

public enum AccessType {
	RO, WO, RW;	
	
	public static AccessType fromString(String input) {
		for (AccessType accessType : AccessType.values()) {
			if (accessType.toString().equals(input)) {
				return accessType;
			}
		}
		return null;
	}

}
