package payStation.impl.currency;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;

/**
 * The SwedishCrowns implementation of the currency class
 * The coins allowed are 1kr, 5kr, 10kr.
 */
public class SwedishCrowns implements Currency {

	@Override
	public boolean checkValidCoin(Coin coin) {
		if (!(coin.getCurrency() instanceof SwedishCrowns))
			return false;
		int val = coin.getValue();
		if(val==1 || val==5 || val==10)
			return true;
		return false;
	}

	@Override
	public int getStandardRate(Coin coin) {
		return coin.getValue()*24; //24=(60*2)/5 in other words 24 seconds per cent.
	}

	@Override
	public String formatCoinValue(int value) {
		String x = value+"¢";
		return x;
	}

}
