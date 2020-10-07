package com.bookManagementAPI.program;

enum TrafficSignal {
	RED("STOP"),
	GREEN("GO");
	
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private TrafficSignal(String action) {
		this.action = action;
	}
	
}
