package com.serjer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Currency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Currency currency = new Currency();

		System.out.println("Please enter a currency abbreviation");
		String currAbb = sc.next();
		System.out.println("Please enter a period start date");
		String startDate = sc.next();
		System.out.println("Please enter a period end date");
		String endDate = sc.next();
		sc.close();

		currency.showCurrencyRatesAndChange(currAbb, startDate, endDate);

	}

	public void showCurrencyRatesAndChange(String currAbb, String startDate, String endDate) {

		final String COMMA_DELIMITER = ";";
		List<String> exchRates = new ArrayList<>();

		String urlString = "https://www.lb.lt/lt/currency/exportlist/?csv=1&currency=" + currAbb
				+ "&ff=1&class=Eu&type=day&date_from_day=" + startDate + "&date_to_day=" + endDate;
		URL url = null;
		try {
			url = new URL(urlString);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			String line = null;
			int countLines = 0;
			String[] infoFromUrl = null;

			while ((line = br.readLine()) != null) {
				if (countLines == 0) {
					countLines++;
					continue;
				}
				infoFromUrl = line.split(COMMA_DELIMITER);

				if (countLines == 1) {
					System.out.println("Currency name: " + infoFromUrl[0].replaceAll("\"", ""));
					System.out.println("Currency code: " + infoFromUrl[1].replaceAll("\"", ""));
					countLines++;
				}
				String date = infoFromUrl[3].replaceAll("\"", "");
				String rate = infoFromUrl[2].replaceAll(",", ".").replaceAll("\"", "");
				System.out.println("Date: " + date + " " + "Rate: " + rate);
				exchRates.add(rate);
			}
			BigDecimal rateOfEnd = new BigDecimal(exchRates.get(0));
			BigDecimal rateOfStart = new BigDecimal(exchRates.get(exchRates.size() - 1));
			System.out.println("Currency change during the period: " + rateOfEnd.subtract(rateOfStart));

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

