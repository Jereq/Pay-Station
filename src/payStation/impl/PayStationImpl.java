package payStation.impl;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;
import payStation.payStationInterface.PayRate;
import payStation.payStationInterface.PayStation;
import payStation.payStationInterface.Receipt;
import payStation.payStationInterface.exception.IllegalCoinException;

/**
 * The class <code>PayStationImpl</code> implements a parking ticket pay
 * station. The business model is that 5, 10 and 25 cent coins are accepted and
 * for every 5 cent you get 2 minutes of parking time.
 */
public class PayStationImpl implements PayStation {

	/**
	 * The current amount of coins paid. Previously, minutes was stored in the
	 * same way, but is now calculated on demand
	 */
	private int payment;
	private Currency currency;
	private PayRate payRate;

	/**
	 * Constructor. Creates a pay payStation with a given currency and a given
	 * payRate.
	 * 
	 * @param currency
	 *            The currency the payStation will accept. Can later be changed
	 *            with <code>setCurrency</code>.
	 * @param payRate
	 *            The payRate the payStation will use to calculate parking time.
	 *            Can later be changed with <code>setPayRate</code>.
	 */
	public PayStationImpl(Currency currency, PayRate payRate) {
		payment = 0;
		this.currency = currency;
		this.payRate = payRate;
	}

	@Override
	public void addPayment(Coin coin) throws IllegalCoinException {
		if (coin.getCurrency() == currency && coin.isValid())
			payment += coin.getValue();
		else
			throw new IllegalCoinException(coin.getValue());
	}

	@Override
	public int getPayment() {
		return payment;
	}

	@Override
	public int getMinutes() {
		int secondsStandardRate = (int)(payment * currency.getStandardRate());
		return payRate.calculateTime(secondsStandardRate);
	}

	@Override
	public Receipt buy() {
		Receipt receipt = new ReceiptImpl(getMinutes(), getPayment());
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
	private void reset() {
		payment = 0;
	}

	@Override
	public Currency getCurrency() {
		return currency;
	}

	@Override
	public void setCurrency(Currency currency) {
		this.currency = currency;
		reset();
	}

	@Override
	public PayRate getPayRate() {
		return payRate;
	}

	@Override
	public void setPayRate(PayRate payRate) {
		this.payRate = payRate;
		reset();
	}
}
