package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			List<Integer> measurements = new ArrayList <>();
			
			while (scan.hasNextInt()) {
				measurements.add(scan.nextInt());
			}
			
			scan.close();
			
			int result = 0;
			for (int i = 0; i < measurements.size(); i++) {
				int number1 = measurements.get(i);
				for (int j = i + 1; j < measurements.size(); j++) {
					int number2 = measurements.get(j);
					for (int k = j + 1; k < measurements.size(); k++) {
						int number3 = measurements.get(k);
						if (number1 + number2 + number3 == 2020) {
							result = number1 * number2 * number3;
							break;
						}
					}
				}
			}
			
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
