package payStation.payStationInterface;

/**
 * The interface <code>Receipt</code> provides a base for a parking ticket
 * receipt.
 */
public interface Receipt {
	/**
	 * Returns the number of minutes in the receipt
	 * 
	 * @return the number of minutes in the receipt
	 */
	public int getMinutes();

	/**
	 * Returns the value of the payment in the receipt
	 * 
	 * @return the value of the payment in the receipt
	 */
	public int getPayment();

	/**
	 * Returns the currency used to pay with. Used together with getPayment to
	 * know the full value of the payment.
	 * 
	 * @return the currency in which the value returned by getPayment is to be
	 *         considered
	 */
	public Currency getCurrency();
}
