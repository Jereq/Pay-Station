package payStation.paystationInterface;

public interface PayStation {
void addPayment(int coinValue);
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
 * 
 * @return
 */
Receipt buy();
void cancel();
}
