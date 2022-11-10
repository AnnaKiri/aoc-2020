package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<String> map = new ArrayList<>();
		while (scan.hasNextLine()) {
			map.add(scan.nextLine());
		}
				
		scan.close();	
		
		System.out.print(countTrees(map));

	}
	
	public static int countTrees(List<String> map) {
		int counter = 0;
		int index = 0;
		for (int i = 0; i < map.size(); i++) {
			String str = map.get(i);
			if (str.charAt(index) == '#') {
				counter++;
			}
			
			index +=7;
			if (index > str.length() - 1) {
				index = index - str.length();
			}
		}
		
		return counter;
	
	}
}
