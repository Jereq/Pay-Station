package payStation.payStationInterface;

/**
 * The interface <code>Coin</code> provides a base for a coin with a certain
 * currency.
 */
public interface Coin {
	/**
	 * Returns the value of the coin in the coins currency.
	 * 
	 * @return the value of the coin
	 */
	int getValue();

	/**
	 * Returns the currency of the coin
	 * 
	 * @return the currency of the coin
	 */
	Currency getCurrency();
}