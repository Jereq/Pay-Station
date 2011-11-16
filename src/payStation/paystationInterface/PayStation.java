package payStation.paystationInterface;

public interface PayStation {
void addPayment(int coinValue);
int getPayment();
int getMinutes();

void cancel();
}
