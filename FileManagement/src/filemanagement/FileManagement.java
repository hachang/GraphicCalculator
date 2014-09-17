package filemanagement;

import java.util.*;
import java.io.*;

public class FileManagement {

	private File file;
	
	FileManagement(){
		
		System.out.print("Selec the file you want to get info about: " );
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		System.out.println("You have selected " + filename);
		file = new File(filename);
		//sc.close();
		
	
	}
	
	private void findSize(){
		System.out.println(file.length());
	}
	
	private void findPath(){
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String[] args){
		
		
		//f.findSize();
		FileManagement f = new FileManagement();
		System.out.println("Select options from following: ");
		
		
		System.out.println("---------------------------------------------------");
		System.out.println("1. Find File Size");
		System.out.println("2  Find file path");
		System.out.println("3  Close");
		System.out.println("---------------------------------------------------");
		
		Scanner s = new Scanner(System.in);
		int opt = s.nextInt();
		
		while(s.hasNext()){			
			if(opt == 1){
				System.out.print("The size of file is " );
				f.findSize();
			}
			
			opt = s.nextInt();
		}
	
	}
}
