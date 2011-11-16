package payStation.paystationInterface;

public interface Receipt {
	/**
	 * Returns the number of minutes in the receipt
	 * 
	 * @return the number of minutes in the receipt
	 */
	public int getMinutes();
	
	/**
	 * Returns the number of cents in the receipt
	 * 
	 * @return the number of cents in the receipt
	 */
	public int getPayment();
}
