package testing;

import java.util.ArrayList;
import java.util.List;

public class Macaw1 {
	static ArrayList<String> count(ArrayList<String> texts) {
		ArrayList<String> textsNew = new ArrayList<>();
		int max = 0;
		int num = 0; // besikartuojanciu raidziu skaicius

		for (String text : texts) { // nustato maksimalu besikartojanciu
			num = Macaw.count(text); // raidziu skaiciu
			if (num > max) {
				max = num;
			}
		}
		for (String text : texts) { // atrenka masyvo elementus atitinkacius max pozymi
			num = Macaw.count(text);
			if (num == max) {
				textsNew.add(text);
			}
		}

		return textsNew;
	}

	public static void main(String[] args) {

		ArrayList<String> texts = new ArrayList<>(
				List.of("aaaa", "aaaa", "aaaa", "aa"));

		System.out.println(
				"Masyvo tekstas(-ai) su daugiausiai is eiles besikartuojanciu " + 
		"raidziu skaiciumi: " + count(texts));

	}

}