/**
 * Created by Matthew Weppler on 10/14/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.YahooFinanceMethods;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class BadSymbolException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6813686137166935283L;
	private String mistake;
	private static String symbolLookupUrlString = "http://finance.yahoo.com/lookup?s="; // Append symbol.
	//private static String badSymbolMatchString = "There are no All Markets results for ";
	private static String badSymbolMatchString = "class=\"error\"><h2>There";
	
	public BadSymbolException() {
		super();
		mistake = "Unknown";
	}

	public BadSymbolException(String err) {
		super(err); // Call super class constructor
		mistake = err;
	}

	public String getError() {
		return mistake;
	}

	public static void validateSymbol(String symbol) throws BadSymbolException {
		URL url = null;
		Scanner scanner = null;
		try {
			url = new URL(symbolLookupUrlString.concat(symbol));
            URLConnection site = url.openConnection();
            InputStream is = site.getInputStream();
            scanner = new Scanner(new BufferedInputStream(is));
			// read one string at a time from URL
			System.out.println("Reading Data from URL: " + symbolLookupUrlString + symbol);
			System.out.println("---------------------------------------------------------------------------");
			while (scanner.hasNext()) {
				String s = scanner.next();
				if (s.equals(badSymbolMatchString)) {
					throw new BadSymbolException("There are no All Markets results for: " + symbol);
				}
			}
        }
        catch (IOException ioe) {
            System.err.println("Could not open " + url);
        }
	}
	
}
