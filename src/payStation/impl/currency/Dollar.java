package payStation.impl.currency;

import payStation.payStationInterface.Currency;

/**
 * the dollar implementation of the currency class the coins allowed are 5¢,
 * 10¢, 25¢ and 50¢
 */
public class Dollar implements Currency {

	@Override
	public boolean checkValidCoinValue(int coinValue) {
		if (coinValue == 5 || coinValue == 10 || coinValue == 25
				|| coinValue == 50)
			return true;
		else
			return false;
	}

	@Override
	public int getStandardRate() {
		return 24; // 24=(60*2)/5 in other words 24 seconds per cent.

	}

	@Override
	public String formatCoinValue(int value) {
		String x = value + "¢";
		return x;
	}

}
