package payStation.impl;

import payStation.paystationInterface.Receipt;

public class ReceiptImpl implements Receipt {

	private int minutes;
	private int payment;
	
	public ReceiptImpl(int minutes, int payment){
		this.minutes = minutes;
		this.payment = payment;
	}
	
	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override
	public int getPayment() {
		return payment;
	}

}
