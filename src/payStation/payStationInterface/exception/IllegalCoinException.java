package payStation.payStationInterface.exception;

import payStation.payStationInterface.Coin;

/**
 * The class <code>IllegalCoinException</code> is an <code>Exception</code> used
 * to indicate that a invalid coin value has been used, or that the currency is
 * not the right one.
 */
public class IllegalCoinException extends Exception {
	/**
	 * Silence warning about <code>serialVersionUID</code> not present
	 */
	private static final long serialVersionUID = 1L;

	private Coin coin;

	/**
	 * Constructor passing the coin that caused this exception.
	 * 
	 * @param coin
	 *            the invalid coin
	 */
	public IllegalCoinException(Coin coin) {
		this.coin = coin;
	}

	/**
	 * Gets the invalid coin that caused this exception.
	 * 
	 * @return the invalid coin
	 */
	public Coin getCoin() {
		return coin;
	}
}
