package gui.bank.chips;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import gui.bank.BankWindow;

import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class ChipsWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private BankWindow bankWindow;

	private JPanel pnBalance;
	private JPanel pnChips;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JLabel lblChips;
	private JPanel pnChipsSelector;
	private JLabel lblFiveChipIcon;
	private JSpinner spinnerFiveChip;
	private JLabel lblTenChipIcon;
	private JSpinner spinnerTenChip;
	private JLabel lblTwentyChipIcon;
	private JSpinner spinnerTwentyChip;
	private JLabel lblFiftyChipIcon;
	private JSpinner spinnerFiftyChip;
	private JLabel lblOneHundredChipIcon;
	private JSpinner spinnerOneHundredChip;
	private JPanel pnBtns;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Create the dialog.
	 */
	public ChipsWindow(BankWindow bankWindow) {
		setTitle("Roulette: Chips");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnBalance(), BorderLayout.NORTH);
		getContentPane().add(getPnChips(), BorderLayout.CENTER);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);

		// Business logic
		this.bankWindow = bankWindow;
	}

	private JPanel getPnBalance() {
		if (pnBalance == null) {
			pnBalance = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBalance.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnBalance.add(getLblBalance());
			pnBalance.add(getTxtBalance());
		}
		return pnBalance;
	}

	private JPanel getPnChips() {
		if (pnChips == null) {
			pnChips = new JPanel();
			pnChips.setLayout(new GridLayout(0, 1, 0, 0));
			pnChips.add(getLblChips());
			pnChips.add(getPnChipsSelector());
		}
		return pnChips;
	}

	private JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("Current balance:");
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

	private JLabel getLblChips() {
		if (lblChips == null) {
			lblChips = new JLabel("Get chips:");
			lblChips.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblChips;
	}

	private JPanel getPnChipsSelector() {
		if (pnChipsSelector == null) {
			pnChipsSelector = new JPanel();
			pnChipsSelector.setLayout(new GridLayout(0, 2, 0, 0));
			pnChipsSelector.add(getLblFiveChipIcon());
			pnChipsSelector.add(getSpinnerFiveChip());
			pnChipsSelector.add(getLblTenChipIcon());
			pnChipsSelector.add(getSpinnerTenChip());
			pnChipsSelector.add(getLblTwentyChipIcon());
			pnChipsSelector.add(getSpinnerTwentyChip());
			pnChipsSelector.add(getLblFiftyChipIcon());
			pnChipsSelector.add(getSpinnerFiftyChip());
			pnChipsSelector.add(getLblOneHundredChipIcon());
			pnChipsSelector.add(getSpinnerOneHundredChip());
		}
		return pnChipsSelector;
	}

	private JLabel getLblFiveChipIcon() {
		if (lblFiveChipIcon == null) {
			lblFiveChipIcon = new JLabel("5 Chip Icon");
			lblFiveChipIcon.setLabelFor(getSpinnerFiveChip());
			lblFiveChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiveChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerFiveChip() {
		if (spinnerFiveChip == null) {
			spinnerFiveChip = new JSpinner();
			spinnerFiveChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFiveChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerFiveChip;
	}

	private JLabel getLblTenChipIcon() {
		if (lblTenChipIcon == null) {
			lblTenChipIcon = new JLabel("10 Chip Icon");
			lblTenChipIcon.setLabelFor(getSpinnerTenChip());
			lblTenChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTenChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerTenChip() {
		if (spinnerTenChip == null) {
			spinnerTenChip = new JSpinner();
			spinnerTenChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerTenChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerTenChip;
	}

	private JLabel getLblTwentyChipIcon() {
		if (lblTwentyChipIcon == null) {
			lblTwentyChipIcon = new JLabel("20 Chip Icon");
			lblTwentyChipIcon.setLabelFor(getSpinnerTwentyChip());
			lblTwentyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTwentyChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerTwentyChip() {
		if (spinnerTwentyChip == null) {
			spinnerTwentyChip = new JSpinner();
			spinnerTwentyChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerTwentyChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerTwentyChip;
	}

	private JLabel getLblFiftyChipIcon() {
		if (lblFiftyChipIcon == null) {
			lblFiftyChipIcon = new JLabel("50 Chip Icon");
			lblFiftyChipIcon.setLabelFor(getSpinnerFiftyChip());
			lblFiftyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiftyChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerFiftyChip() {
		if (spinnerFiftyChip == null) {
			spinnerFiftyChip = new JSpinner();
			spinnerFiftyChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFiftyChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerFiftyChip;
	}

	private JLabel getLblOneHundredChipIcon() {
		if (lblOneHundredChipIcon == null) {
			lblOneHundredChipIcon = new JLabel("100 Chip Icon");
			lblOneHundredChipIcon.setLabelFor(getSpinnerOneHundredChip());
			lblOneHundredChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblOneHundredChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerOneHundredChip() {
		if (spinnerOneHundredChip == null) {
			spinnerOneHundredChip = new JSpinner();
			spinnerOneHundredChip
					.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerOneHundredChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerOneHundredChip;
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
}
