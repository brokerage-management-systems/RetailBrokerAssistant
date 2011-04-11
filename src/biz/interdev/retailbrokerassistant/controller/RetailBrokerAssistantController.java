/**
 * Created by Matthew Weppler on 10/17/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import biz.interdev.retailbrokerassistant.YahooFinanceMethods.BadSymbolException;
import biz.interdev.retailbrokerassistant.YahooFinanceMethods.YahooStock;
import biz.interdev.retailbrokerassistant.YahooFinanceMethods.YahooStockBuilder;
import biz.interdev.retailbrokerassistant.model.RetailBrokerAssistantModel;
import biz.interdev.retailbrokerassistant.view.RetailBrokerAssistantView;

public class RetailBrokerAssistantController {

	private RetailBrokerAssistantModel model;
	private RetailBrokerAssistantView view;

	private boolean validCurrentPrice = false;
	private boolean validPurchasePrice = false;
	private boolean validShares = false;
	private boolean validSymbol = false;

	public RetailBrokerAssistantController(RetailBrokerAssistantModel m, RetailBrokerAssistantView v) {
		model = m;
		view = v;
		
		view.addCurrentPriceListener(new CurrentPriceListener());
		view.addPurchasePriceListener(new PurchasePriceListener());
		view.addSharesListener(new SharesListener());
		view.addSymbolListener(new SymbolListener());
	}
	
	private void preformCalculations() {
		if (validCurrentPrice && validPurchasePrice && validShares) {
			double mktval = model.calculateMarketValue(Double.parseDouble(view.getShares()), Double.parseDouble(view.getCurrentPrice()));
			view.setMarketValue("$"+Double.toString(mktval));

			double pgl = model.calculatePercentageGainLoss(Double.parseDouble(view.getShares()), Double.parseDouble(view.getCurrentPrice()), Double.parseDouble(view.getPurchasePrice()));
			if (pgl > 0) {
				view.setGainLossPercentage("%"+Double.toString(pgl), new Color(0x00, 0x80, 0x00));
			} else if (pgl < 0) {
				view.setGainLossPercentage("%"+Double.toString(pgl), Color.RED);
			}
			
			double valgl = model.calculateValueGainLoss(Double.parseDouble(view.getShares()), Double.parseDouble(view.getCurrentPrice()), Double.parseDouble(view.getPurchasePrice()));
			if (valgl > 0) {
				view.setGainLossValue("$"+Double.toString(valgl), new Color(0x00, 0x80, 0x00));
			} else if (valgl < 0) {
				view.setGainLossValue("$"+Double.toString(valgl), Color.RED);
			}
			
			view.setCommissionTable(model.buildCommissionTableData(view.getCurrentPrice(), view.getShares()), model.buildCommissionTableNames());
		} else {
			System.out.println("Not ok to Calculate.");
		}
	}
	
	private void preformYahooStockBuilder() {
		ArrayList<YahooStock> yahooStockList = new ArrayList<YahooStock>(YahooStockBuilder.retrieveYahooStocks(view.getSymbol()));
		for (YahooStock yahooStock : yahooStockList) {
			System.out.println(yahooStock.toString());
		}
		view.setCurrentPrice(Double.toString(yahooStockList.get(0).getLastTrade()));
		//ImageIcon icon = new ImageIcon(yahooStockList.get(0).getSmallChartUrl());
		//graphLabel = new JLabel(icon);
	}
	
	private void validateCurrentPrice(FocusEvent event) {
		try {
			Double.parseDouble(view.getCurrentPrice());
			validCurrentPrice = true;
			preformCalculations();
		} catch (NumberFormatException nfe) {
			validCurrentPrice = false;
			view.setCurrentPrice("Please enter a valid number!");
		}
	}
	
	private void validatePurchasePrice(FocusEvent event) {
		try {
			Double.parseDouble(view.getPurchasePrice());
			validPurchasePrice = true;
			preformCalculations();
		} catch (NumberFormatException nfe) {
			validPurchasePrice = false;
			view.setPurchasePrice("Please enter a valid number!");
		}
	}
	
	private void validateShares(FocusEvent event) {
		try {
			Double.parseDouble(view.getShares());
			validShares = true;
			preformCalculations();
		} catch (NumberFormatException nfe) {
			validShares = false;
			view.setShares("Please enter a valid number!");
		}
	}
	
	private void validateSymbol(FocusEvent event) {
		try {
			BadSymbolException.validateSymbol(view.getSymbol());
			validSymbol = true;
			validCurrentPrice = true;
			preformYahooStockBuilder();
			preformCalculations();
		} catch (BadSymbolException bse) {
			bse.printStackTrace();
			validSymbol = false;
			view.setSymbol("Please enter a valid symbol.");
		}
	}

	public class CurrentPriceListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// Ignore focus gained for now...
		}
		@Override
		public void focusLost(FocusEvent e) {
			validateCurrentPrice(e);
		}
	}
	
	public class PurchasePriceListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// Ignore focus gained for now...
		}
		@Override
		public void focusLost(FocusEvent e) {
			validatePurchasePrice(e);
		}
	}
	
	public class SharesListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// Ignore focus gained for now...
		}
		@Override
		public void focusLost(FocusEvent e) {
			validateShares(e);
		}
	}
	
	public class SymbolListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// Ignore focus gained for now...
		}
		@Override
		public void focusLost(FocusEvent e) {
			validateSymbol(e);
		}
	}

}
