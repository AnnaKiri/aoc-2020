package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		try {
			Scanner scan = new Scanner(file);
			List<String> passwordsList = new ArrayList <>();
			
			while (scan.hasNextLine()) {
				passwordsList.add(scan.nextLine());
			}
			
			scan.close();
			
			int result = 0;
			for (int i = 0; i < passwordsList.size(); i++) {
				String[] password = passwordsList.get(i).split(" ");
				String [] positions = password[0].split("-");
				int firstPos = Integer.parseInt(positions[0]) - 1;
				int secondPos = Integer.parseInt(positions[1]) - 1;
				
				char letter = password[1].charAt(0);
				
//				if ((password[2].charAt(firstPos) == letter || password[2].charAt(secondPos) == letter) && !(password[2].charAt(firstPos) == letter && password[2].charAt(secondPos) == letter)) {
				if (password[2].charAt(firstPos) == letter ^ password[2].charAt(secondPos) == letter) {		// взаимоисключающее или, краткая запись строки выше	
					result++;
				}
			}
				
			
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
