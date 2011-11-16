package payStation.payStationInterface.exception;

/**
 * The class <code>IllegalCoinException</code> is an <code>Exception</code>
 * used to indicate that a invalid coin value has been used.
 */
public class IllegalCoinException extends Exception {
	/**
	 * Silence warning about <code>serialVersionUID</code> not present
	 */
	private static final long serialVersionUID = 1L;
	
	private int coinValue;
	
	/**
	 * Constructor passing the illegal coin value that caused this exception.
	 * 
	 * @param coinValue the illegal coin value
	 */
	public IllegalCoinException(int coinValue) {
		this.coinValue = coinValue;
	}
	
	/**
	 * Gets the illegal coin value that caused this exception.
	 * 
	 * @return the illegal coin value
	 */
	public int getCoinValue() {
		return coinValue;
	}
}
