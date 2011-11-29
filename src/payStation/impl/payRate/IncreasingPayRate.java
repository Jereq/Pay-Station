package payStation.impl.payRate;

import payStation.payStationInterface.PayRate;

/**
 * Implements a progressing pay rate, where longer parking times are more
 * expensive per minute than shorter.
 */
public class IncreasingPayRate implements PayRate {

	@Override
	public int calculateTime(int totalSeconds) {
		if (totalSeconds < 3600)
			//The first hour is according to standard rate
			return totalSeconds / 60;
			
		else if (totalSeconds < 8400)
			//The second hour is 3/4 the time of the standard rate. 
			//return 60 + (totalSeconds - 3600) * 3 / 4 / 60;
			return totalSeconds / 80 + 15;	//Optimized version
			
		else
			//The third hour and forward is 1/2 the time of the standard rate.
			//return 120 + (totalSeconds - 8400) / 2 / 60;
			return totalSeconds / 120 + 50;	//Optimized version
	}

}
