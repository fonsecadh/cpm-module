package gui.bank.chips;

import java.awt.BorderLayout;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import gui.bank.BankWindow;
import javax.swing.event.ChangeListener;

import business.facade.ChipFacade;
import business.player.Player;

import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;

public class ChipsWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private BankWindow bankWindow;
	private Player player;
	private double currentPlayerBalance;
	private ChipFacade chipFacade;

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
		this.player = Player.getInstance();
		this.currentPlayerBalance = player.getBalance();
		this.chipFacade = new ChipFacade();
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
			pnChips.setLayout(new BorderLayout(0, 0));
			pnChips.add(getLblChips(), BorderLayout.NORTH);
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
			lblFiveChipIcon = new JLabel("");
			lblFiveChipIcon.setIcon(new ImageIcon(ChipsWindow.class.getResource("/img/chipFive.png")));
			lblFiveChipIcon.setLabelFor(getSpinnerFiveChip());
			lblFiveChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiveChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerFiveChip() {
		if (spinnerFiveChip == null) {
			spinnerFiveChip = new JSpinner();
			spinnerFiveChip.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkMax(5, (Integer) spinnerFiveChip.getValue(), (Integer) spinnerFiveChip.getPreviousValue(),
							spinnerFiveChip);
				}
			});
			spinnerFiveChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFiveChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerFiveChip;
	}

	private JLabel getLblTenChipIcon() {
		if (lblTenChipIcon == null) {
			lblTenChipIcon = new JLabel("");
			lblTenChipIcon.setIcon(new ImageIcon(ChipsWindow.class.getResource("/img/chipTen.png")));
			lblTenChipIcon.setLabelFor(getSpinnerTenChip());
			lblTenChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTenChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerTenChip() {
		if (spinnerTenChip == null) {
			spinnerTenChip = new JSpinner();
			spinnerTenChip.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkMax(10, (Integer) spinnerTenChip.getValue(), (Integer) spinnerTenChip.getPreviousValue(),
							spinnerTenChip);
				}
			});
			spinnerTenChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerTenChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerTenChip;
	}

	private JLabel getLblTwentyChipIcon() {
		if (lblTwentyChipIcon == null) {
			lblTwentyChipIcon = new JLabel("");
			lblTwentyChipIcon.setIcon(new ImageIcon(ChipsWindow.class.getResource("/img/chipTwenty.png")));
			lblTwentyChipIcon.setLabelFor(getSpinnerTwentyChip());
			lblTwentyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTwentyChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerTwentyChip() {
		if (spinnerTwentyChip == null) {
			spinnerTwentyChip = new JSpinner();
			spinnerTwentyChip.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkMax(20, (Integer) spinnerTwentyChip.getValue(), (Integer) spinnerTwentyChip.getPreviousValue(),
							spinnerTwentyChip);
				}
			});
			spinnerTwentyChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerTwentyChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerTwentyChip;
	}

	private JLabel getLblFiftyChipIcon() {
		if (lblFiftyChipIcon == null) {
			lblFiftyChipIcon = new JLabel("");
			lblFiftyChipIcon.setIcon(new ImageIcon(ChipsWindow.class.getResource("/img/chipFifty.png")));
			lblFiftyChipIcon.setLabelFor(getSpinnerFiftyChip());
			lblFiftyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiftyChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerFiftyChip() {
		if (spinnerFiftyChip == null) {
			spinnerFiftyChip = new JSpinner();
			spinnerFiftyChip.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkMax(50, (Integer) spinnerFiftyChip.getValue(), (Integer) spinnerFiftyChip.getPreviousValue(),
							spinnerFiftyChip);
				}
			});
			spinnerFiftyChip.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFiftyChip.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerFiftyChip;
	}

	private JLabel getLblOneHundredChipIcon() {
		if (lblOneHundredChipIcon == null) {
			lblOneHundredChipIcon = new JLabel("");
			lblOneHundredChipIcon.setIcon(new ImageIcon(ChipsWindow.class.getResource("/img/chipOneHundred.png")));
			lblOneHundredChipIcon.setLabelFor(getSpinnerOneHundredChip());
			lblOneHundredChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblOneHundredChipIcon;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerOneHundredChip() {
		if (spinnerOneHundredChip == null) {
			spinnerOneHundredChip = new JSpinner();
			spinnerOneHundredChip.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkMax(100, (Integer) spinnerOneHundredChip.getValue(),
							(Integer) spinnerOneHundredChip.getPreviousValue(), spinnerOneHundredChip);
				}
			});
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
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateBalanceAndChipsAndClose();
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
	private void updateBalanceAndChipsAndClose() {
		addChipsToPlayer();		
		this.player.setBalance(currentPlayerBalance);
		this.bankWindow.updateCurrentBalanceTxt();
		dispose();
	}

	private void addChipsToPlayer() {
		int fiveChipUnits = (int) getSpinnerFiveChip().getValue();
		for (int i = 0; i < fiveChipUnits; i++) {
			this.player.addChip(chipFacade.makeChipFive());
		}
		
		int tenChipUnits = (int) getSpinnerTenChip().getValue();
		for (int i = 0; i < tenChipUnits; i++) {
			this.player.addChip(chipFacade.makeChipTen());
		}
		
		int twentyChipUnits = (int) getSpinnerTwentyChip().getValue();
		for (int i = 0; i < twentyChipUnits; i++) {
			this.player.addChip(chipFacade.makeChipTwenty());
		}
		
		int fiftyChipUnits = (int) getSpinnerFiftyChip().getValue();
		for (int i = 0; i < fiftyChipUnits; i++) {
			this.player.addChip(chipFacade.makeChipFifty());
		}
		
		int oneHundredChipUnits = (int) getSpinnerOneHundredChip().getValue();
		for (int i = 0; i < oneHundredChipUnits; i++) {
			this.player.addChip(chipFacade.makeChipOneHundred());
		}
	}

	private void checkMax(int amount, int units, int prevUnits, JSpinner spinner) {
		if (prevUnits > units) {
			double prevChipsAmount = amount * prevUnits;
			double newChipsAmount = amount * units;
			this.currentPlayerBalance += prevChipsAmount;
			this.currentPlayerBalance -= newChipsAmount;
			updatePlayerBalance();
		} else {
			double prevChipsAmount = amount * prevUnits;
			double newChipsAmount = amount * units;
			double aux = this.currentPlayerBalance;
			aux += prevChipsAmount;
			aux -= newChipsAmount;
			if (aux < 0) {
				JOptionPane.showMessageDialog(this, "Exceeded balance", "Error", JOptionPane.ERROR_MESSAGE);
				spinner.setValue(prevUnits);
			} else {
				this.currentPlayerBalance = aux;
				updatePlayerBalance();
			}
		}
	}

	private void updatePlayerBalance() {
		this.getTxtBalance().setText(String.valueOf(this.currentPlayerBalance));
	}
}
