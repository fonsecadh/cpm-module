package gui.credentials.users;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.facade.UserFacade;
import business.player.Player;
import gui.GameWindow;

public class LogOutWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private Player player;
	private UserFacade userFacade;
	private GameWindow gameWindow;
	
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
	public LogOutWindow(GameWindow gameWindow) {
		setTitle("Roulette: Log Out");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnInfo(), BorderLayout.NORTH);
		getContentPane().add(getPnBtn(), BorderLayout.SOUTH);
		getContentPane().add(getPnAction(), BorderLayout.CENTER);
		
		// Business logic
		this.player = Player.getInstance();
		this.gameWindow = gameWindow;
		this.userFacade = new UserFacade();
		convertChipsToBalance();
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
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logOutAndClose();
				}
			});
			btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnExit;
	}

	private JButton getBtnMoveBank() {
		if (btnMoveBank == null) {
			btnMoveBank = new JButton("Transfer Balance to Bank");
			btnMoveBank.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					moveToBank();
				}
			});
			btnMoveBank.setMnemonic('T');
			btnMoveBank.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnMoveBank;
	}
	
	// Auxiliary methods
	private void moveToBank() {
		player.setBalance(0);
	}
	
	private void convertChipsToBalance() {
		double amountChips = player.getChips().stream().map(c -> c.getAmount()).reduce(0.0, (a, b) -> a + b);
		player.removeAllChips();
		double oldBalance = player.getBalance();
		player.setBalance(oldBalance + amountChips);
		getTxtBalance().setText(String.valueOf(player.getBalance()));
	}
	
	private void logOutAndClose() {
		userFacade.logOutUser(player.getAssociatedUser());
		player.setAssociatedUser(null);
		gameWindow.dispose();
		dispose();
	}
	
}
