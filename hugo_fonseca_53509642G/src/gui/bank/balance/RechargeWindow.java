package gui.bank.balance;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class RechargeWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private JPanel pnForm;
	private JPanel pnBtns;
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblAmount;
	private JTextField tfAmount;
	private JLabel lblBalance;
	private JTextField tfBalance;
	private JLabel lblExtract;
	private JSpinner spinExtract;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeWindow dialog = new RechargeWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public RechargeWindow() {
		setTitle("Roulette: Recharge Balance");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnForm(), BorderLayout.CENTER);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);

	}

	private JPanel getPnForm() {
		if (pnForm == null) {
			pnForm = new JPanel();
			pnForm.setLayout(new GridLayout(0, 1, 0, 0));
			pnForm.add(getLblAmount());
			pnForm.add(getTfAmount());
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

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount in account:");
			lblAmount.setLabelFor(getTfAmount());
			lblAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblAmount;
	}

	private JTextField getTfAmount() {
		if (tfAmount == null) {
			tfAmount = new JTextField();
			tfAmount.setEditable(false);
			tfAmount.setFont(new Font("Dialog", Font.PLAIN, 14));
			tfAmount.setColumns(10);
		}
		return tfAmount;
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
			spinExtract.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinExtract;
	}
}
