package payStation.impl.currency;

import payStation.payStationInterface.Coin;
import payStation.payStationInterface.Currency;

/**
 * the Euro implementation of currency
 * the coins allowed are 1c, 2c, 5c, 10c, 20c, 50c and 100c
 */
public class Euro implements Currency {

	@Override
	public boolean checkValidCoin(Coin coin) {
		if (!(coin.getCurrency() instanceof Euro))
			return false;
		int val = coin.getValue();
		if(val==1 || val==2 || val==5 || val==10 || val==20 || val==50|| val==100)
			return true;
		return false;
	}

	@Override
	public int getStandardRate(Coin coin) {
		return coin.getValue()*36; //36=(60*3)/5 in other words 24 seconds per cent.
		
	}

	@Override
	public String formatCoinValue(int value) {
		String x = value+"c";
		return x;
		
	}

}
