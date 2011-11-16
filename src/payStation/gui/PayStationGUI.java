package payStation.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PayStationGUI {

	private JFrame frmPayStation;
	private JTextField textField;

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
		frmPayStation.setBounds(100, 100, 418, 167);
		frmPayStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPayStation.getContentPane().setLayout(new MigLayout("", "[][][][][][][grow][][]", "[][][][][]"));
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		frmPayStation.getContentPane().add(horizontalStrut, "cell 3 0");
		
		JLabel lblInsertCoin = new JLabel("Insert coin");
		lblInsertCoin.setFont(new Font("Tahoma", Font.BOLD, 11));
		frmPayStation.getContentPane().add(lblInsertCoin, "cell 6 0");
		
		JLabel lblYouHavePaid = new JLabel("You have paid:");
		frmPayStation.getContentPane().add(lblYouHavePaid, "cell 1 1");
		
		JLabel label = new JLabel("0");
		frmPayStation.getContentPane().add(label, "cell 3 1");
		
		JLabel lblCents = new JLabel("cent");
		frmPayStation.getContentPane().add(lblCents, "cell 4 1");
		
		JLabel lblYouHavePaid_1 = new JLabel("Your parking time:");
		frmPayStation.getContentPane().add(lblYouHavePaid_1, "cell 1 2");
		
		JLabel label_1 = new JLabel("0");
		frmPayStation.getContentPane().add(label_1, "cell 3 2");
		
		JLabel lblMinutes = new JLabel("minutes");
		frmPayStation.getContentPane().add(lblMinutes, "cell 4 2");
		
		textField = new JTextField();
		frmPayStation.getContentPane().add(textField, "cell 6 2,alignx left");
		textField.setColumns(10);
		
		JLabel lblCents_1 = new JLabel("cent");
		frmPayStation.getContentPane().add(lblCents_1, "cell 7 2,alignx left");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		frmPayStation.getContentPane().add(horizontalStrut_1, "cell 8 2");
		
		JButton btnBuy = new JButton("Buy");
		frmPayStation.getContentPane().add(btnBuy, "cell 1 4");
		
		JButton btnCancel = new JButton("Cancel");
		frmPayStation.getContentPane().add(btnCancel, "cell 2 4 3 1");
	}
}
