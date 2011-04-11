/**
 * Created by Matthew Weppler on 10/14/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.YahooFinanceMethods;


/*
 * Yahoo Finance Quote csv url
 * http://download.finance.yahoo.com/d/quotes.csv?s=GOOG&f=sl1d1t1c1ohgv&e=.csv
 * List of tags:
 * 
 */
public class YahooStock {

	private String symbol;
	private double lastTrade;
	private String tradeDate;
	private String tradeTime;
	private double change;
	private double open;
	private double high;
	private double low;
	private double volume;
	
	private String smallChartUrl;
	private String largeChartUrl;	
	
	/**
	 * CONSTRUCTOR: YAHOO STOCK
	 * Empty YahooStock Object.
	 */
	public YahooStock() {
	}
	
	/**
	 * CONSTRUCTOR: YAHOO STOCK
	 * @param symbol
	 * @param lastTrade
	 * @param tradeDate
	 * @param tradeTime
	 * @param change
	 * @param open
	 * @param high
	 * @param low
	 * @param volume
	 * Default YahooStock Object. Called if no tags are passed to url.
	 */
	public YahooStock(String symbol, double lastTrade, String tradeDate,
			String tradeTime, double change, double open, double high,
			double low, double volume) {
		super();
		this.symbol = symbol;
		this.lastTrade = lastTrade;
		this.tradeDate = tradeDate;
		this.tradeTime = tradeTime;
		this.change = change;
		this.open = open;
		this.high = high;
		this.low = low;
		this.volume = volume;
	}

	/**
	 * @return the smallChartUrl
	 */
	public String getSmallChartUrl() {
		return smallChartUrl;
	}

	/**
	 * @return the largeChartUrl
	 */
	public String getLargeChartUrl() {
		return largeChartUrl;
	}

	/**
	 * @param smallChartUrl the smallChartUrl to set
	 */
	public void setSmallChartUrl(String smallChartUrl) {
		this.smallChartUrl = smallChartUrl;
	}

	/**
	 * @param largeChartUrl the largeChartUrl to set
	 */
	public void setLargeChartUrl(String largeChartUrl) {
		this.largeChartUrl = largeChartUrl;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return the lastTrade
	 */
	public double getLastTrade() {
		return lastTrade;
	}

	/**
	 * @return the tradeDate
	 */
	public String getTradeDate() {
		return tradeDate;
	}

	/**
	 * @return the tradeTime
	 */
	public String getTradeTime() {
		return tradeTime;
	}

	/**
	 * @return the change
	 */
	public double getChange() {
		return change;
	}

	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}

	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param lastTrade the lastTrade to set
	 */
	public void setLastTrade(double lastTrade) {
		this.lastTrade = lastTrade;
	}

	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	/**
	 * @param tradeTime the tradeTime to set
	 */
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	/**
	 * @param change the change to set
	 */
	public void setChange(double change) {
		this.change = change;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(double open) {
		this.open = open;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(double high) {
		this.high = high;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(double low) {
		this.low = low;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YahooStock [symbol=");
		builder.append(symbol);
		builder.append(", lastTrade=");
		builder.append(lastTrade);
		builder.append(", tradeDate=");
		builder.append(tradeDate);
		builder.append(", tradeTime=");
		builder.append(tradeTime);
		builder.append(", change=");
		builder.append(change);
		builder.append(", open=");
		builder.append(open);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", smallChartUrl=");
		builder.append(smallChartUrl);
		builder.append(", largeChartUrl=");
		builder.append(largeChartUrl);
		builder.append("]");
		return builder.toString();
	}
	
}