import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;

/**
 * @author Stephen Smith
 */
public class Chickenizer {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Chickenizer <infile> <outfile>");
			System.exit(0);
		}
		Scanner lineScan = null;
		PrintStream outStream = null;
		try {
			lineScan = new Scanner(new File(args[0]));
			outStream = new PrintStream(new File(args[1]));
		}
		catch (FileNotFoundException e) {
			System.out.println("Coudn't read file derp.");
			System.exit(1);
		}
		while (lineScan.hasNextLine()) {
			outStream.println(chickenFilter(lineScan.nextLine()));
		}

	}

	public static String chickenFilter(String line) {
		String chicken = "";
		// Go through every character
		for (int i = 0; i < line.length(); i++) {
			// Check each character for alphabetical
			if (line.toLowerCase().charAt(i) >= 'a' && line.toLowerCase().charAt(i) <= 'z') {
				// We found a character
				int start = i;
				int length = 0;
				while (i < line.length()) {
					if (line.toLowerCase().charAt(i) >= 'a' && line.toLowerCase().charAt(i) <= 'z') {
						i++;
						length++;
					}
					else {
						i--;
						break;
					}
				}
				chicken += chickenize(line.substring(start, start + length));
			}
			else {
				chicken += line.substring(i, i + 1);
			}
		}
		return chicken;
	}

	public static String chickenize(String chicken) {
		int length = chicken.length();
		boolean allCaps = chicken.toUpperCase().equals(chicken);
		boolean firstCaps = chicken.toUpperCase().charAt(0) == chicken.charAt(0);
		boolean pluralize = chicken.toLowerCase().charAt(chicken.length() - 1) == 's';

		// c, cc, ch, ccc, chick, chicken
		// 1, 2, 3, 4, 5, >5
		String[] chickens = new String[] { "c", "cc", "ch", "chick", "chick", "chicken" };
		if (length == 1) {
			return (allCaps ? (chickens[0] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[0].substring(0, 1).toUpperCase()
					+ chickens[0].substring(1) + (pluralize ? "s" : "")) : chickens[0]));
		}
		if (length == 2) {
			return (allCaps ? (chickens[1] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[1].substring(0, 1).toUpperCase()
					+ chickens[1].substring(1) + (pluralize ? "s" : "")) : chickens[1]));
		}
		if (length == 3) {
			return (allCaps ? (chickens[2] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[2].substring(0, 1).toUpperCase()
					+ chickens[2].substring(1) + (pluralize ? "s" : "")) : chickens[2]));
		}
		if (length == 4) {
			return (allCaps ? (chickens[3] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[3].substring(0, 1).toUpperCase()
					+ chickens[3].substring(1) + (pluralize ? "s" : "")) : chickens[3]));
		}
		if (length == 5) {
			return (allCaps ? (chickens[4] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[4].substring(0, 1).toUpperCase()
					+ chickens[4].substring(1) + (pluralize ? "s" : "")) : chickens[4]));
		}
		else {
			return (allCaps ? (chickens[5] + (pluralize ? "s" : "")).toUpperCase() : (firstCaps ? (chickens[5].substring(0, 1).toUpperCase()
					+ chickens[5].substring(1) + (pluralize ? "s" : "")) : chickens[5]));
		}
	}
}
