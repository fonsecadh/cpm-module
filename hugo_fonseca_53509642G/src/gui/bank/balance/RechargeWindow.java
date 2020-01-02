package gui.bank.balance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import gui.credentials.bank.BankCredentialsWindow;
import javax.swing.SpinnerNumberModel;

import business.player.Player;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RechargeWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private BankCredentialsWindow bankCredentialsWindow;
	private Player player;
	
	private JPanel pnForm;
	private JPanel pnBtns;
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblBalance;
	private JTextField tfBalance;
	private JLabel lblExtract;
	private JSpinner spinExtract;

	/**
	 * Create the dialog.
	 */
	public RechargeWindow(BankCredentialsWindow bankCredentialsWindow) {
		setTitle("Roulette: Recharge Balance");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnForm(), BorderLayout.CENTER);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);
		
		// Business logic
		this.bankCredentialsWindow = bankCredentialsWindow;
		this.player = Player.getInstance();

	}

	private JPanel getPnForm() {
		if (pnForm == null) {
			pnForm = new JPanel();
			pnForm.setLayout(new GridLayout(0, 1, 0, 0));
			pnForm.add(getLblBalance());
			pnForm.add(getTfBalance());
			pnForm.add(getLblExtract());
			pnForm.add(getSpinExtract());
		}
		return pnForm;
	}

	private JPanel getPnBtns() {
		if (pnBtns == null) {
			pnBtns = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtns.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBtns.add(getBtnOk());
			pnBtns.add(getBtnCancel());
		}
		return pnBtns;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rechargeBalance();
				}
			});
			btnOk.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnOk;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bankCredentialsWindow.dispose();
					dispose();
				}
			});
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnCancel;
	}

	private JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("In-game balance:");
			lblBalance.setLabelFor(getTfBalance());
			lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblBalance;
	}

	private JTextField getTfBalance() {
		if (tfBalance == null) {
			tfBalance = new JTextField();
			tfBalance.setEditable(false);
			tfBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
			tfBalance.setColumns(10);
		}
		return tfBalance;
	}

	private JLabel getLblExtract() {
		if (lblExtract == null) {
			lblExtract = new JLabel("Amount to extract:");
			lblExtract.setLabelFor(getSpinExtract());
			lblExtract.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblExtract;
	}

	private JSpinner getSpinExtract() {
		if (spinExtract == null) {
			spinExtract = new JSpinner();
			spinExtract.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(10)));
			spinExtract.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinExtract;
	}
	
	
	// Auxiliary methods
	private void rechargeBalance() {
		try {
			getSpinExtract().commitEdit();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			if ((Double) getSpinExtract().getValue() >= 1) {
				double oldBalance = player.getBalance();
				double rechargeAmount = (Double) getSpinExtract().getValue();
				player.setBalance(oldBalance + rechargeAmount);
				this.bankCredentialsWindow.dispose();
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Not a valid number", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ClassCastException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
