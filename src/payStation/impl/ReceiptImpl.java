package payStation.impl;

import payStation.payStationInterface.Currency;
import payStation.payStationInterface.Receipt;

/**
 * The class <code>ReceiptImpl</code> implements <code>Receipt</code> as a
 * parking ticket.
 */
public class ReceiptImpl implements Receipt {

	private int minutes;
	private int payment;
	private Currency currency;

	/**
	 * Constructor.
	 * 
	 * @param minutes
	 *            number of minutes of parking time
	 * @param payment
	 *            number of cents paid
	 * @param currency
	 *            the currency of payment
	 */
	public ReceiptImpl(int minutes, int payment, Currency currency) {
		this.minutes = minutes;
		this.payment = payment;
		this.currency = currency;
	}

	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override
	public int getPayment() {
		return payment;
	}

	@Override
	public Currency getCurrency() {
		return currency;
	}

}
