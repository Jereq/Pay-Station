package payStation.payStationInterface;

public interface PayStation {
/**
 * adds to the payment as coins are added.
 * @param coinValue
 */
void addPayment(int coinValue) throws IllegalCoinException;
/**
 * returns the amount paid in cents
 * @return the amount paid in cents
 */
int getPayment();
/**
 * returns the parking time in minutes 
 * @return the parking time in minutes
 */
int getMinutes();
/**
 * acknowledges the purchase and prints a receipt. 
 * @return a receipt
 */
Receipt buy();
/**
 * Resets the Paystation
 */
void cancel();
}
