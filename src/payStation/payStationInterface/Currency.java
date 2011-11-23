package payStation.payStationInterface;

/**
 * Base for different currencies.
 * To add another currency implement <code>Currency</code>.
 *
 */
public interface Currency {
	/**
	 * checks so that the coin has a valid value
	 * 
	 * @param coin
	 * @return valid or unvalid as true or false
	 */
	boolean checkValidCoin(Coin coin);
	/**
	 * Gets the standard coin to second rate for the currency
	 * 
	 * @param coin2
	 * @return the coin to second rate
	 */
	int getStandardRate(Coin coin);
	/**
	 * gives the value as a string plus the currency signs
	 * 
	 * @param value
	 * @return the value string plus the currency signs
	 */
	String formatCoinValue(int value);
}
