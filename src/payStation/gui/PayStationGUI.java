package payStation.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * Automatically created by WindowBuilder in Eclipse
 */
public class PayStationGUI {

	private JFrame frmPayStation;
	private JTextField coinInputTextField;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPayStation = new JFrame();
		frmPayStation.setTitle("Pay Station");
		frmPayStation.setBounds(100, 100, 419, 194);
		frmPayStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPayStation.getContentPane().setLayout(new MigLayout("", "[][][][][][][grow][][]", "[][][][][]"));
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		frmPayStation.getContentPane().add(horizontalStrut, "cell 3 0");
		
		JLabel lblYouHavePaid = new JLabel("You have paid:");
		frmPayStation.getContentPane().add(lblYouHavePaid, "cell 1 1");
		
		JLabel centLabel = new JLabel("0");
		frmPayStation.getContentPane().add(centLabel, "cell 3 1");
		
		JLabel lblCents = new JLabel("cent");
		frmPayStation.getContentPane().add(lblCents, "cell 4 1");
		
		JLabel lblInsertCoin = new JLabel("Insert coin");
		lblInsertCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmPayStation.getContentPane().add(lblInsertCoin, "cell 6 1");
		
		JLabel lblYouHavePaid_1 = new JLabel("Your parking time:");
		frmPayStation.getContentPane().add(lblYouHavePaid_1, "cell 1 2");
		
		JLabel minutesLabel = new JLabel("0");
		frmPayStation.getContentPane().add(minutesLabel, "cell 3 2");
		
		JLabel lblMinutes = new JLabel("minutes");
		frmPayStation.getContentPane().add(lblMinutes, "cell 4 2");
		
		coinInputTextField = new JTextField();
		frmPayStation.getContentPane().add(coinInputTextField, "cell 6 2,growx");
		coinInputTextField.setColumns(10);
		
		JLabel lblCents_1 = new JLabel("cent");
		frmPayStation.getContentPane().add(lblCents_1, "cell 7 2,alignx left");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		frmPayStation.getContentPane().add(horizontalStrut_1, "cell 8 2");
		
		JButton buyButton = new JButton("Buy");
		frmPayStation.getContentPane().add(buyButton, "cell 1 4");
		
		JButton cancelButton = new JButton("Cancel");
		frmPayStation.getContentPane().add(cancelButton, "cell 2 4 3 1");
	}
}
