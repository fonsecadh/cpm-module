package gui.credentials.bank;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.bank.balance.RechargeWindow;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankCredentialsWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private RechargeWindow rechargeWindow;
	
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
	public BankCredentialsWindow() {
		setTitle("Roulette: Bank Credentials");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(getLblBankCardNumber());
		getContentPane().add(getTxtBankCardNumber());
		getContentPane().add(getLblSecretCode());
		getContentPane().add(getPfSecretCode());
		getContentPane().add(getPnBtn());
	}

	private JLabel getLblBankCardNumber() {
		if (lblBankCardNumber == null) {
			lblBankCardNumber = new JLabel("Bank card number:");
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
			JOptionPane.showMessageDialog(this, "Some of the fields are empty", 
					"Empty fields", JOptionPane.ERROR_MESSAGE);
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
}
