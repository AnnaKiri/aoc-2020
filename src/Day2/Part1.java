package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
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
				String [] minMaxValue = password[0].split("-");
				int min = Integer.parseInt(minMaxValue[0]);
				int max = Integer.parseInt(minMaxValue[1]);
				
				char letter = password[1].charAt(0);
				
				int counter = 0;
				for (int j = 0; j < password[2].length(); j++) {
					if (password[2].charAt(j) == letter) {
						counter++;
					}
				}
				
				if (counter >= min && counter <= max) {
					result ++;
				}
			}
			
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
