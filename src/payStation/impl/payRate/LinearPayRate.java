package payStation.impl.payRate;

import payStation.payStationInterface.PayRate;

/**
 * Implements the standard pay rate, every 60 s gives one minute of parking
 * time.
 */
public class LinearPayRate implements PayRate {

	@Override
	public int calculateTime(int totalSeconds) {
		return totalSeconds / 60;
	}

}
