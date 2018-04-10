package crackCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CountLineWordsFromFile {

	public static void main(String args[]) {
		HashMap<String, String> map = CountLineWordsDuplicateWords();
		System.out.println(" Map contains ..");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static HashMap<String, String> CountLineWordsDuplicateWords() {
		String sentenceInfo;
		String stringLine = "";
		int counLine = 0;
		String[] stringArray;
		HashMap<String, String> map = new HashMap<String, String>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File("sentence.txt")))) {

			while ((stringLine = br.readLine()) != null) {
				if (stringLine.isEmpty() || stringLine.trim().equals("") || stringLine.trim().equals("\n")
						|| stringLine.length() == 0) {
					continue; // Skip blank lines
				}
				stringArray = stringLine.split(" ");
				counLine++;
				for (int i = 0; i < stringArray.length; i++) {
					String word = stringArray[i];
					if (word != null && !word.isEmpty()) {
						if (map.containsKey(word)) {
							sentenceInfo = map.get(word);
							map.put(word, sentenceInfo + "," + counLine);
						} else {
							map.put(word, "" + counLine);
						}
					}
				}

			}

			System.out.println("Total number of lines: " + counLine);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}