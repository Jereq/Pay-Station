package payStation.impl.payRate;

import payStation.payStationInterface.PayRate;

/**
 * Implements a progressing pay rate, where longer parking times are less
 * expensive per minute than shorter.
 */
public class DecreasingPayRate implements PayRate {

	@Override
	public int calculateTime(int totalSeconds) {
		if (totalSeconds < 3600)
			//The first hour is according to standard rate
			return totalSeconds / 60;
			
		else if (totalSeconds < 6000)
			//The second hour is 3/2 the time of the standard rate. 
			//return 60 + (totalSeconds - 3600) * 3 / 2 / 60;
			return totalSeconds / 40 - 30;	//Optimized version
			
		else
			//The third hour and forward is twice the time of the standard rate.
			//return 120 + (totalSeconds - 6000) * 2 / 60;
			return totalSeconds / 30 - 80;	//Optimized version
	}

}
