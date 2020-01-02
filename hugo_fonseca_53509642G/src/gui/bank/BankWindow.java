package gui.bank;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private JPanel pnCurrentBalance;
	private JPanel pnBtn;
	private JPanel pnActions;
	private JLabel lblCurrentBalance;
	private JTextField txtCurrentBalance;
	private JButton btnFinish;
	private JPanel pnActBalance;
	private JPanel pnActChips;
	private JLabel lblActBalance;
	private JPanel pnActBalBtns;
	private JButton btnRechargeBal;
	private JLabel lblActChips;
	private JPanel pnActChipsBtns;
	private JButton btnGetChips;

	/**
	 * Create the dialog.
	 */
	public BankWindow() {
		setTitle("Roulette: Bank");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnCurrentBalance(), BorderLayout.NORTH);
		getContentPane().add(getPnBtn(), BorderLayout.SOUTH);
		getContentPane().add(getPnActions(), BorderLayout.CENTER);

	}

	private JPanel getPnCurrentBalance() {
		if (pnCurrentBalance == null) {
			pnCurrentBalance = new JPanel();
			pnCurrentBalance.add(getLblCurrentBalance());
			pnCurrentBalance.add(getTxtCurrentBalance());
		}
		return pnCurrentBalance;
	}

	private JPanel getPnBtn() {
		if (pnBtn == null) {
			pnBtn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtn.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBtn.add(getBtnFinish());
		}
		return pnBtn;
	}

	private JPanel getPnActions() {
		if (pnActions == null) {
			pnActions = new JPanel();
			pnActions.setLayout(new GridLayout(1, 0, 0, 0));
			pnActions.add(getPnActBalance());
			pnActions.add(getPnActChips());
		}
		return pnActions;
	}

	private JLabel getLblCurrentBalance() {
		if (lblCurrentBalance == null) {
			lblCurrentBalance = new JLabel("Current balance:");
			lblCurrentBalance.setLabelFor(getTxtCurrentBalance());
			lblCurrentBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblCurrentBalance;
	}

	private JTextField getTxtCurrentBalance() {
		if (txtCurrentBalance == null) {
			txtCurrentBalance = new JTextField();
			txtCurrentBalance.setEditable(false);
			txtCurrentBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtCurrentBalance.setColumns(10);
		}
		return txtCurrentBalance;
	}

	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnFinish;
	}

	private JPanel getPnActBalance() {
		if (pnActBalance == null) {
			pnActBalance = new JPanel();
			pnActBalance.setLayout(new GridLayout(0, 1, 0, 0));
			pnActBalance.add(getLblActBalance());
			pnActBalance.add(getPnActBalBtns());
		}
		return pnActBalance;
	}

	private JPanel getPnActChips() {
		if (pnActChips == null) {
			pnActChips = new JPanel();
			pnActChips.setLayout(new GridLayout(0, 1, 0, 0));
			pnActChips.add(getLblActChips());
			pnActChips.add(getPnActChipsBtns());
		}
		return pnActChips;
	}

	private JLabel getLblActBalance() {
		if (lblActBalance == null) {
			lblActBalance = new JLabel("Balance:");
			lblActBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblActBalance;
	}

	private JPanel getPnActBalBtns() {
		if (pnActBalBtns == null) {
			pnActBalBtns = new JPanel();
			pnActBalBtns.add(getBtnRechargeBal());
		}
		return pnActBalBtns;
	}

	private JButton getBtnRechargeBal() {
		if (btnRechargeBal == null) {
			btnRechargeBal = new JButton("Recharge Balance");
			btnRechargeBal.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnRechargeBal;
	}

	private JLabel getLblActChips() {
		if (lblActChips == null) {
			lblActChips = new JLabel("Chips:");
			lblActChips.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblActChips;
	}

	private JPanel getPnActChipsBtns() {
		if (pnActChipsBtns == null) {
			pnActChipsBtns = new JPanel();
			pnActChipsBtns.add(getBtnGetChips());
		}
		return pnActChipsBtns;
	}

	private JButton getBtnGetChips() {
		if (btnGetChips == null) {
			btnGetChips = new JButton("Get Chips");
			btnGetChips.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnGetChips;
	}
}
