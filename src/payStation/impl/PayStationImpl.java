package payStation.impl;

import payStation.payStationInterface.PayStation;
import payStation.payStationInterface.Receipt;
import payStation.payStationInterface.exception.IllegalCoinException;

public class PayStationImpl implements PayStation {

	/**
	 * The current amount of coins payed. Previously, minutes was stored in the
	 * same way, but is now calculated on demand
	 */
	private int payment;

	@Override
	public void addPayment(int coinValue) throws IllegalCoinException {
		//Business constraint, only these coins are accepted
		if (coinValue == 5 || coinValue == 10 || coinValue == 25)
			payment += coinValue;
		else
			throw new IllegalCoinException(coinValue);
	}

	@Override
	public int getPayment() {
		return payment;
	}

	@Override
	public int getMinutes() {
		return payment / 5 * 2; // Two minutes parking time per five cents
	}

	@Override
	public Receipt buy() {
		Receipt receipt = new ReceiptImpl(getMinutes(), getPayment());
		reset();

		return receipt;
	}

	@Override
	public void cancel() {
		reset();
	}

	/**
	 * Reset the pay-station to prepare it for the next customer
	 */
	private void reset() {
		payment = 0;
	}
}
