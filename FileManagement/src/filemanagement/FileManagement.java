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
		System.out.print(file.length());
	}
	
	private void findPath(){
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String[] args){
		
			try{
			//f.findSize();
			FileManagement f = new FileManagement();
			
			
			
			System.out.println("---------------------------------------------------");
			System.out.println("1. Find File Size");
			System.out.println("2  Find file path");
			System.out.println("3 Choose different file");
			System.out.println("4  Close");
			System.out.println("---------------------------------------------------");
			
			
			System.out.println("Select options from following: ");
			Scanner s = new Scanner(System.in);
			int opt = s.nextInt();
			
			while(s.hasNextLine()){			
				if(opt == 1){
					System.out.print("The size of file is " );
					f.findSize();
					System.out.println(" kb");
				}
				else if(opt == 2){
					System.out.print("The location of file is: ");
					f.findPath();
				}
				else if(opt == 3){
					f = new FileManagement();
				}
				else if(opt == 4){
					System.exit(0);
				}
				
				System.out.println("---------------------------------------------------");
				System.out.println("1. Find File Size");
				System.out.println("2  Find file path");
				System.out.println("3 Choose different file");
				System.out.println("4  Close");
				System.out.println("---------------------------------------------------");
			
				System.out.println("Select options from following: ");
				opt = s.nextInt();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
