package com.serjer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextParser {
	
	public static boolean isStringOnlyAlphabet(String word) 
    { 
        return ((word != null) 
                && (!word.equals("")) 
                && (word.matches("^[a-zA-Z]*$"))); 
    } 
	
	public static String count(String text){
	
		Map<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();
		char[] alphabet = new char[26];
				for(int i = 0; i < 26; i++){
				    alphabet[i] = (char)(97 + i);
				    words.put(String.valueOf(alphabet[i]), new ArrayList<String>());
				}
		String multiBlank =" ";
		int countBlank = 2;
		
		while (text.contains(multiBlank.repeat(countBlank))) {
			text = text.replace(multiBlank.repeat(countBlank), " ");
			countBlank++;
		}
		String [] wordsTemp = text.split(" ");

		for (String word : wordsTemp) {
			if(isStringOnlyAlphabet(word)) {
			words.get(String.valueOf(word.charAt(word.length()-1)).toLowerCase()).add(word);
			}
		}
		words.values().removeIf(ArrayList::isEmpty);
		//words.forEach((k,v) -> System.out.println(k + " " + v.size() + " " + v)); 
		String result = words.entrySet().stream()
				   .map(e -> (e.getKey() + " "+ e.getValue().size() + " " +
						   e.getValue())+"\n")
				   .collect(Collectors.joining(""));	
		return result;
	}

}
