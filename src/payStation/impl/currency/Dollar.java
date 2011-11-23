package payStation.impl.currency;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;

/**
 * the dollar implementation of the currency class
 * the coins allowed are 5¢, 10¢, 25¢ and 50¢ 
 */
public class Dollar implements Currency {

	@Override
	public boolean checkValidCoin(Coin coin) {
		if (!(coin.getCurrency() instanceof Dollar))
			return false;
		int val = coin.getValue();
		if(val==5 || val==10 || val==25 || val==50)
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
