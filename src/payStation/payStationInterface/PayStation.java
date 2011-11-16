package payStation.payStationInterface;

import payStation.payStationInterface.exception.IllegalCoinException;

public interface PayStation {
	/**
	 * adds to the payment as coins are added.
	 * 
	 * @param coinValue
	 * @throws IllegalCoinException
	 *             This exception is thrown if this payStation consider the
	 *             input <code>coinValue</code> to be invalid.
	 */
	void addPayment(int coinValue) throws IllegalCoinException;

	/**
	 * returns the amount paid in cents
	 * 
	 * @return the amount paid in cents
	 */
	int getPayment();

	/**
	 * returns the parking time in minutes
	 * 
	 * @return the parking time in minutes
	 */
	int getMinutes();

	/**
	 * acknowledges the purchase and prints a receipt.
	 * 
	 * @return a receipt
	 */
	Receipt buy();

	/**
	 * Resets the Paystation
	 */
	void cancel();
}
