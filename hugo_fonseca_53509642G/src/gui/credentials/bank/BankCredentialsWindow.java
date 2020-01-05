package gui.credentials.bank;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.bank.BankWindow;
import gui.bank.balance.RechargeWindow;

public class BankCredentialsWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private RechargeWindow rechargeWindow;
	private BankWindow bankWindow;

	private JLabel lblBankCardNumber;
	private JTextField txtBankCardNumber;
	private JLabel lblSecretCode;
	private JPasswordField pfSecretCode;
	private JPanel pnBtn;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Create the dialog.
	 */
	public BankCredentialsWindow(BankWindow bankWindow) {
		setTitle("Roulette: Bank Credentials");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(getLblBankCardNumber());
		getContentPane().add(getTxtBankCardNumber());
		getContentPane().add(getLblSecretCode());
		getContentPane().add(getPfSecretCode());
		getContentPane().add(getPnBtn());
		
		// Business logic
		this.bankWindow = bankWindow;
	}

	private JLabel getLblBankCardNumber() {
		if (lblBankCardNumber == null) {
			lblBankCardNumber = new JLabel("Bank card number:");
			lblBankCardNumber.setDisplayedMnemonic('B');
			lblBankCardNumber.setLabelFor(getTxtBankCardNumber());
			lblBankCardNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblBankCardNumber;
	}

	private JTextField getTxtBankCardNumber() {
		if (txtBankCardNumber == null) {
			txtBankCardNumber = new JTextField();
			txtBankCardNumber.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtBankCardNumber.setColumns(10);
		}
		return txtBankCardNumber;
	}

	private JLabel getLblSecretCode() {
		if (lblSecretCode == null) {
			lblSecretCode = new JLabel("Secret code:");
			lblSecretCode.setDisplayedMnemonic('S');
			lblSecretCode.setLabelFor(getPfSecretCode());
			lblSecretCode.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblSecretCode;
	}

	private JPasswordField getPfSecretCode() {
		if (pfSecretCode == null) {
			pfSecretCode = new JPasswordField();
			pfSecretCode.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return pfSecretCode;
	}

	private JPanel getPnBtn() {
		if (pnBtn == null) {
			pnBtn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtn.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBtn.add(getBtnOk());
			pnBtn.add(getBtnCancel());
		}
		return pnBtn;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkForm();
				}
			});
			btnOk.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnOk;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('C');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnCancel;
	}

	// Auxiliary methods
	private void checkForm() {
		String bankAccountNumber = getTxtBankCardNumber().getText();
		String secretCode = String.valueOf(getPfSecretCode().getPassword());

		if (bankAccountNumber.equals("") || secretCode.equals("")) {
			JOptionPane.showMessageDialog(this, "Some of the fields are empty", "Empty fields",
					JOptionPane.ERROR_MESSAGE);
		} else {
			openRechargeWindow();
		}
	}

	private void openRechargeWindow() {
		this.rechargeWindow = new RechargeWindow(this);
		this.rechargeWindow.setModal(true);
		this.rechargeWindow.setLocationRelativeTo(this);
		this.rechargeWindow.setVisible(true);
	}

	public BankWindow getBankWindow() {
		return this.bankWindow;
	}
}
