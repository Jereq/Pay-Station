package payStation.impl;

import payStation.paystationInterface.PayStation;
import payStation.paystationInterface.Receipt;

public class PayStationImpl implements PayStation {

	private int payment;
	private int minutes;
	
	@Override
	public void addPayment(int coinValue) {
		payment += coinValue;
	}

	@Override
	public int getPayment() {
		return payment;
	}

	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override
	public Receipt buy() {
		Receipt receipt = new ReceiptImpl(minutes, minutes);
		reset();
		
		return receipt;
	}

	@Override
	public void cancel() {
		reset();
	}

	/**
	 * Reset the pay-station to prepare it for the next customer
	 */
	private void reset(){
		payment = 0;
		minutes = 0;
	}
}
