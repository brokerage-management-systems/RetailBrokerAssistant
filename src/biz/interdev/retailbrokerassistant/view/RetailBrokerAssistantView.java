/**
 * Created by Matthew Weppler on 10/28/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.view;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import biz.interdev.retailbrokerassistant.model.RetailBrokerAssistantModel;

public class RetailBrokerAssistantView {

	private final int textFieldHeight = 28;
	private final int textFieldWidth = 150;
	private final int labelHeight = 28;
	private final int labelWidth = 150;
	private final int screenHeight = 450;
	private final int screenWidth = 900;

	private RetailBrokerAssistantModel model;

	private JFrame mainFrame;
	private TableLayout layout;
	private JLabel gainLossLabel;
	private JLabel graphLabel;
	private JLabel marketValueLabel;
	private JLabel valueGainLossLabel;
	private JLabel errorLabel;
	private JTextField symbolField;
	private JTextField currentPriceField;
	private JTextField purchasePriceField;
	private JTextField sharesField;
	private JTable commissionTable;


	public RetailBrokerAssistantView(RetailBrokerAssistantModel m) {
		model = m;

		createFrameAndLayout();
		initializeAndAssembleInputComponents();
		initializeAndAssembleOutputComponents();
		
		mainFrame.setPreferredSize(new Dimension(screenWidth, screenHeight));
		mainFrame.pack();
	}

	private void createFrameAndLayout() {
		mainFrame = new JFrame("Broker Calculator.");
		//mainFrame.setBounds(100, 100, 300, 300);
		mainFrame.setVisible(true);
		double size[][] = {
				{textFieldWidth, textFieldWidth, TableLayout.FILL},
				{textFieldHeight, textFieldHeight, textFieldHeight, textFieldHeight, textFieldHeight, textFieldHeight, textFieldHeight, }
		};
		layout = new TableLayout(size);
		mainFrame.setLayout(layout);
		//mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void initializeAndAssembleInputComponents() {
		JLabel symbolLabel = new JLabel("Symbol: ");
		symbolLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		symbolField = new JTextField();
		symbolField.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));

		JLabel currentPriceLabel = new JLabel("Current Price: ");
		currentPriceLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		currentPriceField = new JTextField();
		currentPriceField.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));

		JLabel purchasePriceLabel = new JLabel("Purchase Price: ");
		purchasePriceLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		purchasePriceField = new JTextField();
		purchasePriceField.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));

		JLabel sharesLabel = new JLabel("Shares:");
		sharesLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		sharesField = new JTextField();
		sharesField.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));

		mainFrame.add(symbolLabel, "0, 0");
		mainFrame.add(symbolField, "1, 0");
		mainFrame.add(currentPriceLabel, "0, 1");
		mainFrame.add(currentPriceField, "1, 1");
		mainFrame.add(purchasePriceLabel, "0, 2");
		mainFrame.add(purchasePriceField, "1, 2");
		mainFrame.add(sharesLabel, "0, 3");
		mainFrame.add(sharesField, "1, 3");
	}

	private void initializeAndAssembleOutputComponents() {
		JLabel marketLabel = new JLabel("Market Value:");
		marketLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		marketValueLabel = new JLabel("");
		marketValueLabel.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));
		marketValueLabel.setBackground(Color.WHITE);

		JLabel gainLabel = new JLabel("Gain/Loss:");
		gainLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		gainLossLabel = new JLabel("");
		gainLossLabel.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));
		gainLossLabel.setBackground(Color.WHITE);

		JLabel valueLabel = new JLabel("Value Gain/Loss:");
		valueLabel.setPreferredSize(new java.awt.Dimension(labelWidth, labelHeight));
		valueGainLossLabel = new JLabel("");
		valueGainLossLabel.setPreferredSize(new java.awt.Dimension(textFieldWidth, textFieldHeight));
		valueGainLossLabel.setBackground(Color.WHITE);

		graphLabel = new JLabel("Graph will go here.");
		graphLabel.setPreferredSize(new java.awt.Dimension(screenWidth, labelHeight));
		errorLabel = new JLabel("");
		errorLabel.setPreferredSize(new java.awt.Dimension(screenWidth, labelHeight));

		mainFrame.add(marketLabel, "0, 4");
		mainFrame.add(marketValueLabel, "1, 4");

		mainFrame.add(gainLabel, "0, 5");
		mainFrame.add(gainLossLabel, "1, 5");

		mainFrame.add(valueLabel, "0, 6");
		mainFrame.add(valueGainLossLabel, "1, 6");
	}

	// REMOVE ME
//	private void initializeAndAssembleTableComponents() {
//		commissionTable = new JTable();
//		mainFrame.add(commissionTable, "2, 0");
//	}

	/*
	 * INPUTS
	 */

	public String getCurrentPrice() {
		return currentPriceField.getText();
	}

	public String getPurchasePrice() {
		return purchasePriceField.getText();
	}

	public String getShares() {
		return sharesField.getText();
	}

	public String getSymbol() {
		return symbolField.getText();
	}

	public void setCurrentPrice(String s) {
		currentPriceField.setText(s);
	}

	public void setPurchasePrice(String s) {
		purchasePriceField.setText(s);
	}

	public void setShares(String s) {
		sharesField.setText(s);
	}

	public void setSymbol(String s) {
		symbolField.setText(s);
	}

	public void addCurrentPriceListener(FocusListener focus) {
		currentPriceField.addFocusListener(focus);
	}

	public void addPurchasePriceListener(FocusListener focus) {
		purchasePriceField.addFocusListener(focus);
	}

	public void addSharesListener(FocusListener focus) {
		sharesField.addFocusListener(focus);
	}

	public void addSymbolListener(FocusListener focus) {
		symbolField.addFocusListener(focus);
	}

	/*
	 * OUTPUTS
	 */

	public String getMarketValue() {
		return marketValueLabel.getText();
	}

	public String getGainLossPercentage() {
		return gainLossLabel.getText();
	}

	public String getGainLossValue() {
		return valueGainLossLabel.getText();
	}

	public void setMarketValue(String s) {
		marketValueLabel.setText(s);
	}

	public void setGainLossPercentage(String s, Color c) {
		gainLossLabel.setText(s);
		gainLossLabel.setForeground(c);
	}

	public void setGainLossValue(String s, Color c) {
		valueGainLossLabel.setText(s);
		valueGainLossLabel.setForeground(c);
	}

	/*
	 * COMMISSION TABLE
	 */
	
	public void setCommissionTable(Object[][] rowData, Object[] columnNames) {
		JTable commissionTable = new JTable(rowData, columnNames);
		commissionTable.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(commissionTable);
		mainFrame.add(scrollPane, "2, 0, 2, 6");
	}
	
	
}
