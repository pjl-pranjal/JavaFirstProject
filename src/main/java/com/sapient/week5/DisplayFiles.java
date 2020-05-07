package com.sapient.week5;

import java.io.File;

public class DisplayFiles {
	public static void main(String[] args) {
		System.out.println("Enter path to directory:");
		String pathToDirectory = Reader.read.nextLine();
		File folder = new File(pathToDirectory);
		
		System.out.println("Files at this location are:");
        String[] files = folder.list();
        for (String file : files)
        {
            System.out.println(file);
        }
	}
}
