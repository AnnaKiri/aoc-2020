package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		
		final String [] passports = Files.readString(Path.of(path)).split("\r\n\r\n");
		
		int counter = 0;
		for (String passport : passports) {
			boolean allOk = true;
			allOk = allOk && Pattern.compile("(byr:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(iyr:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(eyr:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(hgt:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(hcl:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(ecl:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(byr:)").matcher(passport).find();
			allOk = allOk && Pattern.compile("(pid:)").matcher(passport).find();

			if (allOk) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
