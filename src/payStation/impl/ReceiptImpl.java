package payStation.impl;

import payStation.payStationInterface.Receipt;

/**
 * The class <code>ReceiptImpl</code> implements <code>Receipt</code> as a
 * parking ticket.
 */
public class ReceiptImpl implements Receipt {

	private int minutes;
	private int payment;

	/**
	 * Constructor.
	 * 
	 * @param minutes
	 *            number of minutes of parking time
	 * @param payment
	 *            number of cents paid
	 */
	public ReceiptImpl(int minutes, int payment) {
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
