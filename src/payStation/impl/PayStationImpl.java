package payStation.impl;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;
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
	
	
	@Override
	public void addPayment(Coin coin) throws IllegalCoinException {
		if (currency.checkValidCoin(coin)==true)
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
		return payment / 5 * 2; // Two minutes parking time per five cents
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
}
