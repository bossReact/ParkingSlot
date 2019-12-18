package com.cloudlex.parking.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtility {

	public static List<String> getListOfStatement() {
		
		Scanner sc=new Scanner(System.in);
		BufferedReader br = null;
		List<String> inputStatement=new ArrayList<String>();
	    System.out.println("Enter the full path of Input File");
	    String path=sc.nextLine();
	    try {
	    File file=new File(path);
	    System.out.println(file.getPath());
	     br = new BufferedReader(new FileReader(file)); 
	    String st; 
	    while ((st = br.readLine()) != null) 
	    	inputStatement.add(st);
	    }catch(FileNotFoundException ex ) {
	    	System.out.println("File Not Found");
	    }catch(IOException ex) {
	    	System.out.println("IO Exception Occur");
	    }catch(Exception ex) {
	    	System.out.println("Exception Occur");
	    }	
	    
	    sc.close();
		return inputStatement;
	}

}
