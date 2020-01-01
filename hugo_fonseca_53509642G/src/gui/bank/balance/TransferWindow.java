package gui.bank.balance;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class TransferWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private JPanel pnForm;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JLabel lblTransfer;
	private JSpinner spinTransfer;
	private JPanel pnBtns;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Create the dialog.
	 */
	public TransferWindow() {
		setTitle("Roulette: Transfer Balance");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnForm(), BorderLayout.CENTER);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);

	}

	private JPanel getPnForm() {
		if (pnForm == null) {
			pnForm = new JPanel();
			pnForm.setLayout(new GridLayout(0, 1, 0, 0));
			pnForm.add(getLblAmount());
			pnForm.add(getTxtAmount());
			pnForm.add(getLblBalance());
			pnForm.add(getTxtBalance());
			pnForm.add(getLblTransfer());
			pnForm.add(getSpinTransfer());
		}
		return pnForm;
	}

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount in account:");
			lblAmount.setLabelFor(getTxtAmount());
			lblAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblAmount;
	}

	private JTextField getTxtAmount() {
		if (txtAmount == null) {
			txtAmount = new JTextField();
			txtAmount.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtAmount.setEditable(false);
			txtAmount.setColumns(10);
		}
		return txtAmount;
	}

	private JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("In-game balance:");
			lblBalance.setLabelFor(getTxtBalance());
			lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblBalance;
	}

	private JTextField getTxtBalance() {
		if (txtBalance == null) {
			txtBalance = new JTextField();
			txtBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtBalance.setEditable(false);
			txtBalance.setColumns(10);
		}
		return txtBalance;
	}

	private JLabel getLblTransfer() {
		if (lblTransfer == null) {
			lblTransfer = new JLabel("Transfer back to bank:");
			lblTransfer.setLabelFor(getSpinTransfer());
			lblTransfer.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTransfer;
	}

	private JSpinner getSpinTransfer() {
		if (spinTransfer == null) {
			spinTransfer = new JSpinner();
			spinTransfer.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinTransfer;
	}

	private JPanel getPnBtns() {
		if (pnBtns == null) {
			pnBtns = new JPanel();
			FlowLayout fl_pnBtns = (FlowLayout) pnBtns.getLayout();
			fl_pnBtns.setAlignment(FlowLayout.RIGHT);
			pnBtns.add(getBtnOk());
			pnBtns.add(getBtnCancel());
		}
		return pnBtns;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnOk;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnCancel;
	}
}
