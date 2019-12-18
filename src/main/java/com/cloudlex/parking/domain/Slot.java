package com.cloudlex.parking.domain;

public class Slot {

	private int slotNo;
	private long timeInHours;

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public long getTimeInHours() {
		return timeInHours;
	}

	public void setTimeInHours(long timeInHours) {
		this.timeInHours = timeInHours;
	}

	@Override
	public String toString() {
		return "Slot [slotNo=" + slotNo + ", timeInHours=" + timeInHours + "]";
	}
	
	

}
