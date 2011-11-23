package payStation.impl.payRate;

import payStation.payStationInterface.PayRate;

/**
 * Implements a progressing pay rate, where longer parking times are more
 * expensive per minute than shorter.
 */
public class IncreasingPayRate implements PayRate {

	@Override
	public int calculateTime(int totalSeconds) {
		int hoursOfParking = totalSeconds / 3600;	//3600 seconds per hours
		
		switch (hoursOfParking) {
		case 0:
			//The first hour is according to standard rate
			return totalSeconds / 60;
			
		case 1:
			//The second hour is 3/4 the time of the standard rate. 
			//return 60 + (totalSeconds - 3600) * 3 / 4 / 60;
			return totalSeconds / 80 + 15;	//Optimized version
			
		default:
			//The third hour and forward is 1/2 the time of the standard rate.
			//return 120 + (totalSeconds - 8400) / 2 / 60;
			return totalSeconds / 120 + 50;	//Optimized version
		}
	}

}
