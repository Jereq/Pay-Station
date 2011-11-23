package payStation.payStationInterface;

/**
 * The interface <code>PayRate</code> provides a base for a pay rate
 * implementation allowing for different payment rates in different pay
 * stations.
 */
public interface PayRate {
	/**
	 * Calculates the parking time in minutes based on the number of second in
	 * the standard rate.
	 * 
	 * @param totalSeconds number of seconds in base rate
	 * @return number of minutes of parking time using this pay rate
	 */
	int calculateTime(int totalSeconds);
}
