package payStation.impl;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;

/**
 * The class <code>CoinImpl</code> implements <code>Coin</code>.
 */
public class CoinImpl implements Coin {

	private int value;
	private Currency currency;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            the coins value in the coins currency
	 * @param currency
	 *            the currency of the coin
	 */
	public CoinImpl(int value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public Currency getCurrency() {
		return currency;
	}

	@Override
	public boolean isValid() {
		return currency.checkValidCoinValue(value);
	}

}
