package com.cloudlex.parking.domain;

public class ParkingSlot {

	private String registrationNo;
	private String carColor;
	private Slot slot;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "ParkingSlot [registrationNo=" + registrationNo + ", carColor=" + carColor + ", slot=" + slot + "]";
	}

	
}
