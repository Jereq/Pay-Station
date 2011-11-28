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
	 * the coin is valid, and throw <code>IllegalCoinException</code> if it is
	 * not.
	 * 
	 * @param coin
	 *            the inserted coin, different implementations determine
	 *            currency
	 * @throws IllegalCoinException
	 *             This exception may be thrown if the implemented payStation
	 *             consider the input <code>coin</code> to be invalid.
	 */
	void addPayment(Coin coin) throws IllegalCoinException;

	/**
	 * Returns the current payment in the current currency.
	 * 
	 * @return the amount paid in the current currency
	 */
	int getPayment();

	/**
	 * Returns the current currency used in the payStation.
	 * 
	 * @return the current currency, <code>getPayment</code> returns the value
	 *         in this currency.
	 */
	Currency getCurrency();

	/**
	 * Sets the currency used by the pay station. Should reset the pay station.
	 * 
	 * @param currency
	 *            the new currency to be used by the pay station
	 */
	void setCurrency(Currency currency);

	/**
	 * Returns the current pay rate used by the pay station.
	 * 
	 * @return the current pay rate, should affect <code>getMinutes</code>.
	 */
	PayRate getPayRate();

	/**
	 * Sets the pay rate used to calculate parking time. Should reset the pay
	 * station.
	 * 
	 * @param payRate
	 *            the new pay rate to be used by the pay station
	 */
	void setPayRate(PayRate payRate);

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
