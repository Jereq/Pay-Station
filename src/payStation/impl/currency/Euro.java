package payStation.impl.currency;

import payStation.payStationInterface.Currency;

/**
 * the Euro implementation of currency the coins allowed are 1c, 2c, 5c, 10c,
 * 20c, 50c and 100c
 */
public class Euro implements Currency {

	@Override
	public boolean checkValidCoinValue(int coinValue) {
		if (coinValue == 1 || coinValue == 2 || coinValue == 5
				|| coinValue == 10 || coinValue == 20 || coinValue == 50
				|| coinValue == 100)
			return true;
		else
			return false;
	}

	@Override
	public float getStandardRate() {
		return 36; // 36=(60*3)/5 in other words 24 seconds
					// per cent.
	}

	@Override
	public String formatCoinValue(int value) {
		String x = value + "c";
		return x;

	}

}
