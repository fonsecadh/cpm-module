package gui.credentials.users;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class LogOutWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private JPanel pnInfo;
	private JPanel pnBtn;
	private JPanel pnAction;
	private JLabel lblLogOut;
	private JLabel lblChipsConverted;
	private JPanel pnBalance;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JButton btnExit;
	private JButton btnMoveBank;

	/**
	 * Create the dialog.
	 */
	public LogOutWindow() {
		setTitle("Roulette: Log Out");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnInfo(), BorderLayout.NORTH);
		getContentPane().add(getPnBtn(), BorderLayout.SOUTH);
		getContentPane().add(getPnAction(), BorderLayout.CENTER);

	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfo.add(getLblLogOut());
			pnInfo.add(getLblChipsConverted());
			pnInfo.add(getPnBalance());
		}
		return pnInfo;
	}

	private JPanel getPnBtn() {
		if (pnBtn == null) {
			pnBtn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtn.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBtn.add(getBtnExit());
		}
		return pnBtn;
	}

	private JPanel getPnAction() {
		if (pnAction == null) {
			pnAction = new JPanel();
			pnAction.add(getBtnMoveBank());
		}
		return pnAction;
	}

	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("Log Out");
			lblLogOut.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblLogOut;
	}

	private JLabel getLblChipsConverted() {
		if (lblChipsConverted == null) {
			lblChipsConverted = new JLabel("All chips have been converted to balance");
			lblChipsConverted.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblChipsConverted;
	}

	private JPanel getPnBalance() {
		if (pnBalance == null) {
			pnBalance = new JPanel();
			pnBalance.add(getLblBalance());
			pnBalance.add(getTxtBalance());
		}
		return pnBalance;
	}

	private JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("Updated balance:");
			lblBalance.setLabelFor(getTxtBalance());
			lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblBalance;
	}

	private JTextField getTxtBalance() {
		if (txtBalance == null) {
			txtBalance = new JTextField();
			txtBalance.setEditable(false);
			txtBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtBalance.setColumns(10);
		}
		return txtBalance;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnExit;
	}

	private JButton getBtnMoveBank() {
		if (btnMoveBank == null) {
			btnMoveBank = new JButton("Transfer Balance to Bank");
			btnMoveBank.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnMoveBank;
	}
}
