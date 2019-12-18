package com.cloudlex.parking;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.cloudlex.parking.service.ParkingService;
import com.cloudlex.parking.util.FileUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("***Welcome To Parking Slot****");

		List<String> statements = FileUtility.getListOfStatement();
		statements = statements.stream().map(String::trim).collect(Collectors.toList());
		System.out.println(statements);
		ParkingService service = null;
		/**
		 * create a slot for parking based on statements
		 */
		try {
			service = new ParkingService(statements);
		} catch (Exception ex) {
			System.out.println("Check With your file Contents:" + ex.getMessage());
			throw new RuntimeException("Check With your file Contents:" + ex.getMessage());
		}
		
		/**
		 * process the other statements
		 */
		service.processOtherStatments(statements);

	}
}
