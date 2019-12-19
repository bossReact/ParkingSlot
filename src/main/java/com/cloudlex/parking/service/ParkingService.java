package com.cloudlex.parking.service;

import java.util.List;
import java.util.stream.Collectors;
import com.cloudlex.parking.domain.ParkingSlot;
import com.cloudlex.parking.domain.Slot;

public class ParkingService {
	
	private ParkingSlot[] slots;
	private int size=0;
	
	/**
	 * take the input for parking slot
	 * as per the rule input contains only one string create_parking_lot
	 */
	public ParkingService(List<String> statements)throws NumberFormatException {
		
		//create Parking Slot
		String parkingLotString=statements.stream().
		filter(state ->state.contains("create_parking_lot")).
		collect(Collectors.toList()).get(0);
		slots=createLotSize(Integer.parseInt(parkingLotString.replace("create_parking_lot", "").trim()));
	}

	private ParkingSlot[] createLotSize(int parkingLotSize) {
		 ParkingSlot[] slots = new ParkingSlot[parkingLotSize];
		 System.out.println("Created Parking lot with: "+parkingLotSize+" slots");
		return slots;
	}
	
	private int slotCapacity() {
		return slots.length;
	}
	
	private int slotSize() {
		return size;
	}

	public void processOtherStatments(List<String> statements) {
		
		/**
		 * already we used these statement
		 */
		statements.remove(0);
		for(String str:statements) {
			if(str.contains("park")) {
				
				if(slotCapacity()==size) {
					System.out.println("Sorry, Parking lot is full");
				}else {
					
					//make object 
					ParkingSlot parking=makeParkingSlot(str);
					Slot lot=new Slot();
					lot.setSlotNo(slotSize()+1);
					parking.setSlot(lot);
					slots[slotSize()]=parking;
					
					//we need to search free slot
					System.out.println("Allocated Slot Number: "+parking.getSlot().getSlotNo());
					size++;
				}
			}
			else if(str.contains("leave")) {
				boolean carFound=false;
				String[] strArray=str.split(" ");
				String carNumber=strArray[1].trim();
				String hour=strArray[2].trim();
				
					if(size==0)
						System.out.println("Sorry There is No Car for Leave");
					else {
						for(ParkingSlot lot:slots) {
							if(lot!=null && lot.getRegistrationNo().equals(carNumber)) {
								carFound=true;
								slots[lot.getSlot().getSlotNo()-1]=null;
								System.out.println("Registration number "+carNumber+" with slot "+ lot.getSlot()+" is free with Charge"+ chargeByHour(Integer.parseInt(hour)));
								size--;
							}
						}	
					}
					
					if(!carFound)
						System.out.println("Sorry Car Not Found for registration: "+carNumber);
			}
			else if(str.contains("status")) {
				System.out.println("Slot No.   Registration No.");
				int count=1;
				for(ParkingSlot lot:slots) {
					if(lot!=null) {
					System.out.println(count +"    "+lot.getRegistrationNo());
					count=count+1;
					}
				}
			}
		}
	}

	private int chargeByHour(int hour) {
		if(hour==0)
			return 0;
		else if(hour<2)
			return hour*10;
		else {
			hour=hour-2;
			return (hour*10)+10;
			}
	}

	private ParkingSlot makeParkingSlot(String str) {
		ParkingSlot parkinglot=new ParkingSlot();
		parkinglot.setRegistrationNo(str.replace("park", "").trim());
		return parkinglot;
	}

	
	
	

}
