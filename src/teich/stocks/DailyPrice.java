package teich.stocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyPrice {

	private String exchange;
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	private double adjustedClosePrice;

	public DailyPrice(String exchange, String symbol, String date, double open,
			double high, double low, double close, int volume, double adjstd)
			throws ParseException {
		this.exchange = exchange;
		this.symbol = symbol;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyy");
		this.date = formatter.parse(date);
		openPrice = open;
		highPrice = high;
		lowPrice = low;
		closePrice = close;
		this.volume = volume;
		adjustedClosePrice = adjstd;
	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public int getVolume() {
		return volume;
	}

	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}
}
