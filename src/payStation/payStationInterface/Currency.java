package payStation.payStationInterface;

/**
 * Base for different currencies. To add another currency implement
 * <code>Currency</code>.
 * 
 */
public interface Currency {
	/**
	 * checks so that the coin has a valid value
	 * 
	 * @param coinValue
	 *            the value of the coin to check
	 * @return true if coinValue is a valid value in this currency, otherwise
	 *         false
	 */
	boolean checkValidCoinValue(int coinValue);

	/**
	 * Returns the coin value to second ratio
	 * 
	 * @param coin
	 * @return the coin to second rate
	 */
	int getStandardRate();

	/**
	 * gives the value as a string plus the currency signs
	 * 
	 * @param value
	 * @return the value string plus the currency signs
	 */
	String formatCoinValue(int value);
}
