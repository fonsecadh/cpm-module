package gui.bank.chips;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;

public class ChipsWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
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

	/**
	 * Create the dialog.
	 */
	public ChipsWindow() {
		setTitle("Roulette: Chips");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnBalance(), BorderLayout.NORTH);
		getContentPane().add(getPnChips(), BorderLayout.SOUTH);

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

	private JSpinner getSpinnerFiveChip() {
		if (spinnerFiveChip == null) {
			spinnerFiveChip = new JSpinner();
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

	private JSpinner getSpinnerTenChip() {
		if (spinnerTenChip == null) {
			spinnerTenChip = new JSpinner();
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

	private JSpinner getSpinnerTwentyChip() {
		if (spinnerTwentyChip == null) {
			spinnerTwentyChip = new JSpinner();
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

	private JSpinner getSpinnerFiftyChip() {
		if (spinnerFiftyChip == null) {
			spinnerFiftyChip = new JSpinner();
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

	private JSpinner getSpinnerOneHundredChip() {
		if (spinnerOneHundredChip == null) {
			spinnerOneHundredChip = new JSpinner();
			spinnerOneHundredChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerOneHundredChip;
	}
}
