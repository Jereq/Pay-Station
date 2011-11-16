package payStation.payStationInterface;

import payStation.payStationInterface.exception.IllegalCoinException;

/**
 * The interface <code>PayStation</code> represents a pay station for parking
 * tickets. Money is added with <code>addPayment</code> and the transaction is
 * completed with <code>buy</code>.
 */
public interface PayStation {
	/**
	 * Adds a certain value to the payment. Implementations are to verify that
	 * the coin value is valid, and throw <code>IllegalCoinException</code> if
	 * it is not.
	 * 
	 * @param coinValue
	 *            value of the inserted coin, may be any (possibly invalid)
	 *            number
	 * @throws IllegalCoinException
	 *             This exception may be thrown if the implemented payStation
	 *             consider the input <code>coinValue</code> to be invalid.
	 */
	void addPayment(int coinValue) throws IllegalCoinException;

	/**
	 * Returns the current payment in cents.
	 * 
	 * @return the amount paid in cents
	 */
	int getPayment();

	/**
	 * Returns the current parking time in minutes.
	 * 
	 * @return the parking time in minutes
	 */
	int getMinutes();

	/**
	 * Acknowledges the purchase and returns a receipt.
	 * 
	 * @return a receipt providing parking time and payment
	 */
	Receipt buy();

	/**
	 * Resets this <code>PayStation</code> in preparation for the next
	 * transaction
	 */
	void cancel();
}
