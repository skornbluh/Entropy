import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Entropy {
	private static String data;
	private static HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
	
	/**
	 * gets data from file and stores in data
	 */
	public static void getData() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test_entropy_02.txt"));
			StringBuilder sb = new StringBuilder();
			String line = "";
			do {
				line = br.readLine();
				if (line != null) {
					sb.append(line);
				}
			} while (line != null);
			data = sb.toString();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} 
	}
	
	public static double computeEntropy() {
		int n = data.length();

		for (int i = 0; i < n; i++) { // count occurrences of letters
			char ch = data.charAt(i);
			countOccurrences(ch);
		}
		
		double entropy = 0.0;
		for (Map.Entry<Character, Integer> item : charCount.entrySet()) { // iterate over character count hashmap
			entropy += item.getValue();
		}
		return entropy/n;
	}
	
	private static int countOccurrences(char ch) {
		if (charCount.containsKey(ch)) {
			return -1;
		}
		int count = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ch) {
				count++;
			}
		}
		charCount.put((char)ch, (int)count); // store the character and its count in the hashmap
		return count;
	}

	/**
	 * run the program
	 * @param args
	 */
	public static void main(String[] args) {
		getData();
		System.out.println("Entropy for '" + data + "' is " + computeEntropy());
		
		for (Map.Entry<Character, Integer> item : charCount.entrySet()) { // iterate over character count hashmap
			System.out.println("key = " + item.getKey() + ", value = " + item.getValue());
		}
		

	}

}
