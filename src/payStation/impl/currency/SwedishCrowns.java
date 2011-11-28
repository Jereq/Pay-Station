package payStation.impl.currency;

import payStation.payStationInterface.Currency;

/**
 * The SwedishCrowns implementation of the currency class The coins allowed are
 * 1kr, 5kr, 10kr.
 */
public class SwedishCrowns implements Currency {

	@Override
	public boolean checkValidCoinValue(int coinValue) {
		if (coinValue == 1 || coinValue == 5 || coinValue == 10)
			return true;
		else
			return false;
	}

	@Override
	public float getStandardRate() {
		return 300; // 60*5=300 meaning 300 seconds per SEK
	}

	@Override
	public String formatCoinValue(int value) {
		String x = value + " kr";
		return x;
	}

}
