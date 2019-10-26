package com.serjer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Store {
	public static Scanner sc = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {

		Store store = new Store();
		boolean running = true;

		List<Item> itemList = store.generateStoreWithoutDublicates();

		while (running) {
			System.out.println("\nIveskite pagal ka norite tikrinti sandeli: \n" 
					+ "[1] - pagal prekiu likuti\n"
					+ "[2] - pagal prekiu galiojimo data \n" 
					+ "[x] - baigti darba");
			String command = sc.next();
			switch (command) {
			case "1":
				store.checkQuantity(itemList);
				break;
			case "2":
				store.checkExpirationDate(itemList);
				break;
			case "x":
				running = false;
				System.out.println("Darbas baigtas");
				break;
			default:
				System.out.println("Ivedete neteisinga veiksma. Bandykite dar karta");
			}
		}
		sc.close();

	}

	public void checkQuantity(List<Item> itemList) {

		boolean input = true;
		while (input) {
			System.out.println("\nIveskite minimalu prekiu likuti");
			String minQuntityTemp = sc.next();
			try {
				int minQuntity = Integer.parseInt(minQuntityTemp);
				System.out.println("\nPrekiu sarasas, kuriu kiekis mazeznis uz ivesta likuti:");
				itemList.stream().filter(e -> (e.getQuantity() < minQuntity))
						.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList())
						.forEach(System.out::println);
				input = false;
			} catch (Exception e) {
				System.out.println("Neteisingas ivedimas, turi buti skaicius.");
			}
		}

	}

	public void checkExpirationDate(List<Item> itemList) {
		boolean input = true;
		while (input) {
			System.out.println("\nIveskite data prekiu galiojimui patikrinti");
			try {
				Date checkDate = sdf.parse(sc.next());
				System.out.println("\nPrekiu sarasas, kuriu galiojimas mazesnis uz ivesta data:");
				itemList.stream().filter(e -> e.getExpiration_Date().before(checkDate))
						.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList())
						.forEach(System.out::println);
						input = false;
			} catch (ParseException e) {
				System.out.println("Neteisingas datos ivedimo formatas.\n"
						+ "Teisingo datos ivedimo formato pavyzdys: 2019-01-01");
			}
		}
	}

	public List<Item> generateStoreWithoutDublicates() throws NumberFormatException, IOException, ParseException {
		final String COMMA_DELIMITER = ",";
		File file = new File("C:/Users/User/Desktop/store/sample.csv");
		List<Item> itemList = new ArrayList<>();

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Programa neranda sandelio failo. Ikelkite pagal instrukcija");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		int countLines = 0;
		
		while ((line = br.readLine()) != null) {
			if (countLines == 0) {
				countLines++;
				continue;
			}
			String[] a = line.split(COMMA_DELIMITER);
			Item item = new Item(a[0], Long.valueOf(a[1]), Integer.valueOf(a[2]), sdf.parse(a[3]));
			itemList.add(item);
		}
		br.close();
		
		for (int i = 0; i < itemList.size(); i++) {
			for (int j = i + 1; j < itemList.size(); j++) {
				if (itemList.get(j).equals(itemList.get(i))) {
					itemList.get(i).setQuantity(itemList.get(i).getQuantity() + itemList.get(j).getQuantity());
					itemList.remove(j);

				}
			}
		}
		return itemList;
	}

}
