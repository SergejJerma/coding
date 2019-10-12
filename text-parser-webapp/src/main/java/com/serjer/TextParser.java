package com.serjer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextParser extends Thread {
	private String text;

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public static String removeMultiSpaces(String text) {
		text = text.strip().replaceAll(" +", " ");
		return text;
	}

	public static boolean isStringOnlyAlphabet(String word) {
		return ((word != null) && (!word.equals("")) && (word.matches("^[a-zA-Z]*$")));
	}

	public String countWordsByLastLetter(String text) {

		Map<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();
		
		//latin alphabet generating and putting as hasmap keys
		char[] latinAlphabet = new char[26];
		for (int i = 0; i < 26; i++) {
			latinAlphabet[i] = (char) (97 + i);
			words.put(String.valueOf(latinAlphabet[i]), new ArrayList<String>());
		}
		
		//parsing words by last letter and putting as hashmap values by key
		for (String word : removeMultiSpaces(text).split(" ")) {
			if (isStringOnlyAlphabet(word)) {
				words.get(String.valueOf(word.charAt(word.length() - 1)).toLowerCase()).add(word);
			}
		}
		
		return words.entrySet().stream().filter(entry -> !entry.getValue().isEmpty())
				.map(e -> (e.getKey() + " " + e.getValue().size() + " " + e.getValue()) + "\n")
				.collect(Collectors.joining(""));
	}

}
