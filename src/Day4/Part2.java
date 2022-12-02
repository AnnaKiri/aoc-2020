package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		
		final String [] passports = Files.readString(Path.of(path)).split("\r\n\r\n");
		
		Pattern byr = Pattern.compile("(byr:)(\\d{4})");
		Pattern iyr = Pattern.compile("(iyr:)(\\d{4})");
		Pattern eyr = Pattern.compile("(eyr:)(\\d{4})");
		Pattern hgt = Pattern.compile("(hgt:)(\\d+)(cm|in)");
		Pattern hcl = Pattern.compile("(hcl:)(#[0-9a-f]{6})");
		Pattern ecl = Pattern.compile("(ecl:)(amb|blu|brn|gry|grn|hzl|oth)");
		Pattern pid = Pattern.compile("(pid:)(\\d{9})(\\s|$)");
		
		int counter = 0;
		for (String passport : passports) {
			Matcher byrMatcher = byr.matcher(passport);
			Matcher iyrMatcher = iyr.matcher(passport);
			Matcher eyrMatcher = eyr.matcher(passport);
			Matcher hgtMatcher = hgt.matcher(passport);
			Matcher hclMatcher = hcl.matcher(passport);
			Matcher eclMatcher = ecl.matcher(passport);
			Matcher pidMatcher = pid.matcher(passport);
			
			if (byrMatcher.find() && iyrMatcher.find() && eyrMatcher.find() 
					&& hgtMatcher.find() && hclMatcher.find()
					&& eclMatcher.find() && pidMatcher.find()) 
				{
				
				int birthYear = Integer.parseInt(byrMatcher.group(2));
				int issueYear = Integer.parseInt(iyrMatcher.group(2));
				int expirationYear = Integer.parseInt(eyrMatcher.group(2));
				String height = hgtMatcher.group(3);
				int heightValue = Integer.parseInt(hgtMatcher.group(2));
			
				boolean allOk = true;
				allOk = allOk && (birthYear >= 1920  && birthYear <=2002);
				allOk = allOk && (issueYear >= 2010 && issueYear <= 2020);
				allOk = allOk && (expirationYear >= 2020 && expirationYear <= 2030);
				
				if (height.equals("cm")) {
					allOk = allOk && (heightValue >= 150 && heightValue <= 193);
				} else {
					allOk = allOk && (heightValue >= 59 && heightValue <= 76);
				}
				
				if (allOk) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
