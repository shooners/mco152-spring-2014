package teich.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private String exchange;
	private String symbol;
	private String date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	private double adjustedClosePrice;
	private List<DailyPrice> set;
	private String[] fileName = new String[] { "AMEX_daily_prices_A.csv",
			"AMEX_daily_prices_B.csv", "AMEX_daily_prices_C.csv",
			"AMEX_daily_prices_D.csv" };

	public AmexData() throws IOException {
		set = new ArrayList<DailyPrice>();
		CSVReader reader;
		for (String s : fileName) {
			reader = new CSVReader(new FileReader("./resources/amex/" + s));
			reader.readNext();
			String[] line;
			while ((line = reader.readNext()) != null) {
				exchange = line[0];
				symbol = line[1];
				date = line[2];
				openPrice = Double.parseDouble(line[3]);
				highPrice = Double.parseDouble(line[4]);
				lowPrice = Double.parseDouble(line[5]);
				closePrice = Double.parseDouble(line[6]);
				volume = Integer.parseInt(line[7]);
				adjustedClosePrice = Double.parseDouble(line[8]);
				try {
					set.add(new DailyPrice(exchange, symbol, date, openPrice,
							highPrice, lowPrice, closePrice, volume,
							adjustedClosePrice));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public boolean contains(String symbol) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i).getSymbol().equalsIgnoreCase(symbol)) {
				return true;
			}
		}
		return false;
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		for (DailyPrice p : set) {
			if (p.getSymbol().equalsIgnoreCase(symbol)) {
				list.add(p);
			}
		}
		return sort(list);
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();

		for (DailyPrice d : set) {
			if (d.getSymbol().equalsIgnoreCase(symbol)
					&& (d.getDate().compareTo(startDate) >= 0 || d.getDate()
							.compareTo(endDate) <= 0)) {
				list.add(d);
			}
		}
		return sort(list);
	}

	public List<DailyPrice> sort(List<DailyPrice> list) {
		if (list.isEmpty()) {
			return list;
		} else {
			for (int i = 0; i < list.size(); i++) {
				int l = list.size() - i;

				for (int j = 0; j < l - 1; j++) {
					if (list.get(j).getDate()
							.compareTo(list.get(j + 1).getDate()) > 0) {
						DailyPrice temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			}
		}
		return list;
	}
}
