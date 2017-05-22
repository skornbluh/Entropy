import java.io.BufferedReader;
import java.io.FileReader;

public class Entropy {

	private static String data;

	private static double entropy = 0;


	public static void countOccurrences() {
		char[] uniqueCharacters = new char[data.length()];
		for (int i = 0; i < data.length(); i++) {
			char letter = data.charAt(i);

			String substring = data.substring(0, i);

			if (substring.indexOf(letter) == -1) {
				uniqueCharacters[i] = letter;
				System.out.println(uniqueCharacters);
			}
		}

		for (int j = 0; j < uniqueCharacters.length; j++) {
			int counter = 0;
			for (int k = 0; k < data.length(); k++) {
				if (uniqueCharacters[j] == data.charAt(k)) {
					counter++;
				}
			}
			System.out.print(uniqueCharacters[j]);
			System.out.println(counter);

			computeEntropy(counter);

		}
	}

	public static void computeEntropy(double counter) {

		if (counter != 0) {
			System.out.println("Calling compute entryopy for " + counter);
			double probability = counter / data.length();
			System.out.println("letter probability is " + probability);

			double letterEntropy = probability * (Math.log(probability) / Math.log(2));
			entropy += letterEntropy;
		}
	}

	public static void main(String[] args) {
		data = args[0];

		countOccurrences();

		System.out.println(data);
		System.out.println("entropy = " + entropy * -1);

	}
}
