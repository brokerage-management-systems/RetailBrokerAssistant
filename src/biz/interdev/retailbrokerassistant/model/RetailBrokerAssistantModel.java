/**
 * Created by Matthew Weppler on 10/13/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */

package biz.interdev.retailbrokerassistant.model;


public class RetailBrokerAssistantModel {

	private double commission;
	private double currentPrice;
	private double difference;
	private double gainLoss;
	private double purchasePrice;
	private double shares;
	private String symbol;

	private final int ROWS = 8;
	private final int COLS = 8;
	
	/**
	 * METHOD: CALCULATE COMMISSION
	 * @return commission
	 */
	public double calculateCommission() {
		commission = currentPrice * shares;
		return commission;
	}

	
	public Object[][] buildCommissionTableData(String cp, String sh) {
		Object[][] rowData = new Object[ROWS][ROWS]; // rows than columns
		double currentPrice = Double.parseDouble(cp);
		double shares = Double.parseDouble(sh);
		double priceIncrement = 0.0;
		double priceIncrementAmount = 0.5;
		for (int i = 0; i < COLS; i++) {
			double commissionIncrement = .02;
			double commissionIncrementAmount = .005;
			
			rowData[i][0] = new String("+" + priceIncrement + " = " + newRound(currentPrice * shares, 2));
			rowData[i][1] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][2] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][3] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][4] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][5] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][6] = newRound((currentPrice * shares * commissionIncrement), 2);
			commissionIncrement += commissionIncrementAmount;
			rowData[i][7] = newRound((currentPrice * shares * commissionIncrement), 2);
			
			priceIncrement += priceIncrementAmount;
			currentPrice += priceIncrementAmount;
		};
		
		return rowData;
	}

	public Object[] buildCommissionTableNames() {
		Object[] columnNames = new Object[COLS];
		columnNames[0] = "Market Value +";
		columnNames[1] = "2.0%";
		columnNames[2] = "2.5%";
		columnNames[3] = "3.0%";
		columnNames[4] = "3.5%";
		columnNames[5] = "4.0%";
		columnNames[6] = "4.5%";
		columnNames[7] = "5.0%";
		return columnNames;
	}
	
	public double calculateMarketValue(double s, double cp) {
		return newRound(s*cp,4);
	}

	public double calculatePercentageGainLoss(double s, double cp, double pp) {
		difference = (cp*s) - (pp*s);
		double gainLoss = (difference/(pp*s))*100;
		gainLoss = newRound(gainLoss,4);
		return gainLoss;
	}

	public double calculateValueGainLoss(double s, double cp, double pp) {
		difference = (cp*s) - (pp*s);
		difference = newRound(difference,2);
		return difference;
	}

	private double newRound(double Rval, int Rpl) {
		double p = (double)Math.pow(10,Rpl);
		Rval = Rval * p;
		double tmp = Math.round(Rval);
		return (double)tmp/p;
	}

}
