package payStation.gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import payStation.payStationInterface.*;
import payStation.payStationInterface.exception.IllegalCoinException;
import payStation.impl.*;
import payStation.impl.currency.Dollar;
import payStation.impl.currency.Euro;
import payStation.impl.currency.SwedishCrowns;
import payStation.impl.payRate.DecreasingPayRate;
import payStation.impl.payRate.IncreasingPayRate;
import payStation.impl.payRate.LinearPayRate;

import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * Most of this is automatically created by WindowBuilder in Eclipse
 */
public class PayStationGUI {

	private JFrame frmPayStation;
	private JTextField coinInputTextField;
	private JLabel paidAmountLabel;
	private JLabel minutesLabel;

	private static Currency sek = new SwedishCrowns();
	private static Currency dollar = new Dollar();
	private static Currency euro = new Euro();
	private Currency selectedInputCurrency = sek;
	
	private static PayRate linear = new LinearPayRate();
	private static PayRate increasing = new IncreasingPayRate();
	private static PayRate decreasing = new DecreasingPayRate();

	private PayStation payStation = new PayStationImpl(sek, linear);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayStationGUI window = new PayStationGUI();
					window.frmPayStation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayStationGUI() {
		initialize();
		
		updateLabels();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPayStation = new JFrame();
		frmPayStation.setTitle("Pay Station");
		frmPayStation.setBounds(100, 100, 537, 296);
		frmPayStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPayStation.getContentPane().setLayout(
				new MigLayout("", "[grow][grow]", "[][][]"));

		{
			JPanel status = new JPanel();
			status.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Current status",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			frmPayStation.getContentPane().add(status, "cell 0 0,grow");
			status.setLayout(new MigLayout("", "[][][]", "[][]"));

			JLabel paidLabel = new JLabel("You have paid:");
			status.add(paidLabel, "cell 0 0");

			paidAmountLabel = new JLabel("A lot of money");
			status.add(paidAmountLabel, "cell 2 0");

			JLabel parkingTimeLabel = new JLabel("Your parking time:");
			status.add(parkingTimeLabel, "cell 0 1");

			minutesLabel = new JLabel("Until end of time");
			status.add(minutesLabel, "cell 2 1");
		}

		{
			JPanel insertCoin = new JPanel();
			insertCoin.setBorder(new TitledBorder(null, "Insert coin",
					TitledBorder.CENTER, TitledBorder.TOP, null, null));
			frmPayStation.getContentPane().add(insertCoin, "cell 1 0,grow");
			insertCoin.setLayout(new MigLayout("", "[][][]", "[][]"));

			coinInputTextField = new JTextField();
			insertCoin.add(coinInputTextField, "cell 0 0 3 1,growx");
			coinInputTextField.addActionListener(new ActionListener() {
				/*
				 * (non-Javadoc) When enter is pressed after a number has been
				 * input, we try to get the number and send it to the
				 * payStation. If the coin is deemed invalid by the pay station,
				 * an IllegalCoinException is thrown
				 */
				public void actionPerformed(ActionEvent arg0) {
					try {
						int coinValue;
						coinValue = Integer.parseInt(coinInputTextField
								.getText());
						coinInputTextField.setText(null);
						payStation.addPayment(new CoinImpl(coinValue,
								selectedInputCurrency));
						updateLabels();
					} catch (NumberFormatException ex) {
						// User entered something other than a number, do
						// nothing
					} catch (IllegalCoinException ex) {
						JOptionPane.showInternalMessageDialog(
								frmPayStation.getContentPane(),
								"Invalid coin inserted: coin returned",
								"Invalid coin", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			coinInputTextField.setColumns(10);

			JRadioButton sekButton = new JRadioButton("SEK");
			insertCoin.add(sekButton, "cell 0 1");
			sekButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedInputCurrency = sek;
				}
			});
			sekButton.setSelected(true);

			// Group the radio buttons.
			ButtonGroup inputCoinGroup = new ButtonGroup();
			inputCoinGroup.add(sekButton);

			JRadioButton dollarButton = new JRadioButton("Dollar (cent)");
			insertCoin.add(dollarButton, "cell 1 1");
			dollarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedInputCurrency = dollar;
				}
			});
			inputCoinGroup.add(dollarButton);

			JRadioButton euroButton = new JRadioButton("Euro (cent)");
			insertCoin.add(euroButton, "cell 2 1");
			euroButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedInputCurrency = euro;
				}
			});
			inputCoinGroup.add(euroButton);
		}

		{
			JPanel settings = new JPanel();
			settings.setBorder(new TitledBorder(null, "Settings",
					TitledBorder.CENTER, TitledBorder.TOP, null, null));
			frmPayStation.getContentPane().add(settings,
					"cell 0 1 2 1,alignx left,aligny top");
			settings.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			{
				JPanel currency = new JPanel();
				currency.setBorder(new TitledBorder(null, "Currency",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				settings.add(currency);

				ButtonGroup currencySettingsGroup = new ButtonGroup();

				JRadioButton sekSettingsButton = new JRadioButton("SEK");
				sekSettingsButton.setSelected(true);
				sekSettingsButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeCurrency(sek);
					}
				});
				currency.add(sekSettingsButton);
				currencySettingsGroup.add(sekSettingsButton);

				JRadioButton dollarSettingsButton = new JRadioButton("Dollar");
				dollarSettingsButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeCurrency(dollar);
					}
				});
				currency.add(dollarSettingsButton);
				currencySettingsGroup.add(dollarSettingsButton);

				JRadioButton euroSettingsButton = new JRadioButton("Euro");
				euroSettingsButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeCurrency(euro);
					}
				});
				currency.add(euroSettingsButton);
				currencySettingsGroup.add(euroSettingsButton);
			}

			{
				JPanel paymentPlan = new JPanel();
				paymentPlan.setBorder(new TitledBorder(null, "Payment Plan",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				settings.add(paymentPlan);

				ButtonGroup payRateSettingsGroup = new ButtonGroup();

				JRadioButton linearButton = new JRadioButton("Linear");
				linearButton.setSelected(true);
				linearButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changePayRate(linear);
					}
				});
				paymentPlan.add(linearButton);
				payRateSettingsGroup.add(linearButton);

				JRadioButton increasingButton = new JRadioButton("Increasing");
				increasingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changePayRate(increasing);
					}
				});
				paymentPlan.add(increasingButton);
				payRateSettingsGroup.add(increasingButton);

				JRadioButton decreasingButton = new JRadioButton("Decreasing");
				decreasingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changePayRate(decreasing);
					}
				});
				paymentPlan.add(decreasingButton);
				payRateSettingsGroup.add(decreasingButton);
			}
		}

		Box buttonBox = Box.createHorizontalBox();
		frmPayStation.getContentPane().add(buttonBox,
				"flowx,cell 1 2,alignx center");

		JButton buyButton = new JButton("Buy");
		buttonBox.add(buyButton);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		buttonBox.add(horizontalStrut);

		JButton cancelButton = new JButton("Cancel");
		buttonBox.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc) When the cancel button is pressed, the payStation
			 * is reset and the labels are updated
			 */
			public void actionPerformed(ActionEvent arg0) {
				payStation.cancel();
				updateLabels();
			}
		});
		buyButton.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc) When the buy button is clicked, we request a
			 * receipt from the payStation and display it
			 */
			public void actionPerformed(ActionEvent arg0) {
				Receipt receipt = payStation.buy();
				updateLabels();
				JOptionPane.showInternalMessageDialog(
						frmPayStation.getContentPane(),
						"Payment: " + receipt.getPayment() + "\nParking Time: "
								+ receipt.getMinutes(), "Receipt",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * Updates the cent and the minutes labels with their current value in
	 * payStation
	 */
	private void updateLabels() {
		paidAmountLabel.setText(Integer.toString(payStation.getPayment()));
		minutesLabel.setText(Integer.toString(payStation.getMinutes()));
	}
	
	private void changeCurrency(Currency currency) {
		if (currency != payStation.getCurrency()) {
			payStation.setCurrency(currency);
			updateLabels();
		}
	}
	
	private void changePayRate(PayRate payRate) {
		if (payRate != payStation.getPayRate())  {
			payStation.setPayRate(payRate);
			updateLabels();
		}
	}
}
