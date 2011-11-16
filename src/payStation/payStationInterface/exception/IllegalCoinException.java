package payStation.payStationInterface.exception;

public class IllegalCoinException extends Exception {
	private int coinValue;
	
	public IllegalCoinException(int coinValue) {
		this.coinValue = coinValue;
	}
	
	public int getCoinValue() {
		return coinValue;
	}
}
