/**
 * Created by Matthew Weppler on 10/17/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.YahooFinanceMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class YahooStockBuilder {

	public static List<YahooStock> retrieveYahooStocks(String symbol) {
		//URL yahooFinanceUrl1 = null;
		URL yahooFinanceUrl2 = null;
		URLConnection urlConnection;
		List<YahooStock> yahooStockList = null;
		try {
			//yahooFinanceUrl1 = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sl1d1t1c1ohgv&e=.csv");
			yahooFinanceUrl2 = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sl1d1t1c1ohgv&e=.csv");
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}  
		try {
			urlConnection = yahooFinanceUrl2.openConnection();
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
			String inputLine;  
			yahooStockList = new ArrayList<YahooStock>();
			while ((inputLine = dataIn.readLine()) != null) {
				String[] yahooStockInfo = inputLine.split(",");
				YahooStock yahooStock = new YahooStock();
				yahooStock.setSymbol(yahooStockInfo[0].replaceAll("\"", ""));
				yahooStock.setLastTrade(Double.valueOf(yahooStockInfo[1]));
				yahooStock.setTradeDate(yahooStockInfo[2]);
				yahooStock.setTradeTime(yahooStockInfo[3]);
				yahooStock.setChange(Double.valueOf(yahooStockInfo[4]));
				yahooStock.setOpen(Double.valueOf(yahooStockInfo[5]));
				yahooStock.setHigh(Double.valueOf(yahooStockInfo[6]));
				yahooStock.setLow(Double.valueOf(yahooStockInfo[7]));
				yahooStock.setVolume(Double.valueOf(yahooStockInfo[8]));
				yahooStock.setSmallChartUrl("http://ichart.finance.yahoo.com/t?s=" + yahooStock.getSymbol());
				yahooStock.setLargeChartUrl("http://chart.finance.yahoo.com/w?s=" + yahooStock.getSymbol());
				yahooStockList.add(yahooStock);
			}  
			dataIn.close();  
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}  
		return yahooStockList;  	
	}

}
