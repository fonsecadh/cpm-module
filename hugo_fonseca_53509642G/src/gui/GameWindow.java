package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.roulette.Roulette;
import java.awt.FlowLayout;

public class GameWindow extends JFrame {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private Roulette roulette;

	private JPanel contentPane;
	private JPanel pnRound;
	private JPanel pnInfo;
	private JPanel pnLogOut;
	private JPanel pnBar;
	private JPanel pnGame;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JLabel lblBarIcon;
	private JButton btnBar;
	private JButton btnLogOut;
	private JButton btnRoulette;
	private JScrollPane spResults;
	private JTextArea taResults;
	private JPanel pnBets;
	private JPanel pnChips;
	private JPanel pnBarBtn;
	private JPanel pnChipsInfo;
	private JPanel pnChipsBtn;
	private JButton btnGetChips;
	private JLabel lblPlayerChips;
	private JPanel pnPlayerChips;
	private JPanel pnFiveChip;
	private JLabel lblFiveChipIcon;
	private JTextField txtFiveChipUnits;
	private JPanel pnTenChip;
	private JLabel lblTenChipIcon;
	private JTextField txtTenChipUnits;
	private JPanel pnTwentyChip;
	private JLabel lblTwentyChipIcon;
	private JTextField txtTwentyChipUnits;
	private JPanel pnFiftyChip;
	private JLabel lblFiftyChipIcon;
	private JTextField txtFiftyChipUnits;
	private JPanel pnOneHundredChip;
	private JLabel lblOneHundredChipIcon;
	private JTextField txtOneHundredChipUnits;
	private JPanel pnTopBoard;
	private JPanel pnBoardZero;
	private JButton btnBoardZero;
	private JPanel pnBoardNumbers;
	private JPanel pnBoardColumns;
	private JButton btnBoardThirdCol;
	private JButton btnBoardSecCol;
	private JButton btnBoardFirstCol;
	private JPanel pnBotBoard;
	private JPanel pnBoardDozens;
	private JButton btnBoardFirstDozen;
	private JButton btnBoardSecDozen;
	private JButton btnBoardThirdDozen;
	private JPanel pnBoardOther;
	private JButton btnBoardFail;
	private JButton btnBoardEven;
	private JButton btnBoardBlack;
	private JButton btnBoardRed;
	private JButton btnBoardOdd;
	private JButton btnBoardPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setTitle("Roulette");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnRound(), BorderLayout.WEST);
		contentPane.add(getPnInfo(), BorderLayout.NORTH);
		contentPane.add(getPnLogOut(), BorderLayout.SOUTH);
		contentPane.add(getPnBar(), BorderLayout.EAST);
		contentPane.add(getPnGame(), BorderLayout.CENTER);

		// Business logic
		this.roulette = Roulette.getInstance(); // Singleton
	}

	private JPanel getPnRound() {
		if (pnRound == null) {
			pnRound = new JPanel();
			pnRound.setLayout(new GridLayout(0, 1, 0, 0));
			pnRound.add(getBtnRoulette());
			pnRound.add(getSpResults());
		}
		return pnRound;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.add(getLblBalance());
			pnInfo.add(getTxtBalance());
		}
		return pnInfo;
	}

	private JPanel getPnLogOut() {
		if (pnLogOut == null) {
			pnLogOut = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnLogOut.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnLogOut.add(getBtnLogOut());
		}
		return pnLogOut;
	}

	private JPanel getPnBar() {
		if (pnBar == null) {
			pnBar = new JPanel();
			pnBar.setLayout(new GridLayout(0, 1, 0, 0));
			pnBar.add(getLblBarIcon());
			pnBar.add(getPnBarBtn());
		}
		return pnBar;
	}

	private JPanel getPnGame() {
		if (pnGame == null) {
			pnGame = new JPanel();
			pnGame.setLayout(new BorderLayout(0, 0));
			pnGame.add(getPnBets(), BorderLayout.CENTER);
			pnGame.add(getPnChips(), BorderLayout.WEST);
		}
		return pnGame;
	}

	private JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("Balance:");
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

	private JLabel getLblBarIcon() {
		if (lblBarIcon == null) {
			lblBarIcon = new JLabel("Bar Icon");
			lblBarIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblBarIcon;
	}

	private JButton getBtnBar() {
		if (btnBar == null) {
			btnBar = new JButton("Bar");
			btnBar.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnBar;
	}

	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log Out");
			btnLogOut.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnLogOut;
	}

	private JButton getBtnRoulette() {
		if (btnRoulette == null) {
			btnRoulette = new JButton("RouletteIcon");
			btnRoulette.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					spinRoulette();
				}
			});
			btnRoulette.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnRoulette;
	}

	private JScrollPane getSpResults() {
		if (spResults == null) {
			spResults = new JScrollPane();
			spResults.setViewportView(getTaResults());
		}
		return spResults;
	}

	private JTextArea getTaResults() {
		if (taResults == null) {
			taResults = new JTextArea();
			taResults.setEditable(false);
			taResults.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return taResults;
	}

	private JPanel getPnBets() {
		if (pnBets == null) {
			pnBets = new JPanel();
			pnBets.setLayout(new GridLayout(0, 1, 0, 0));
			pnBets.add(getPnTopBoard());
			pnBets.add(getPnBotBoard());
		}
		return pnBets;
	}

	private JPanel getPnChips() {
		if (pnChips == null) {
			pnChips = new JPanel();
			pnChips.setLayout(new GridLayout(0, 1, 0, 0));
			pnChips.add(getPnChipsInfo());
			pnChips.add(getPnChipsBtn());
		}
		return pnChips;
	}

	private JPanel getPnBarBtn() {
		if (pnBarBtn == null) {
			pnBarBtn = new JPanel();
			pnBarBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnBarBtn.add(getBtnBar());
		}
		return pnBarBtn;
	}

	private JPanel getPnChipsInfo() {
		if (pnChipsInfo == null) {
			pnChipsInfo = new JPanel();
			pnChipsInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnChipsInfo.add(getLblPlayerChips());
			pnChipsInfo.add(getPnPlayerChips());
		}
		return pnChipsInfo;
	}

	private JPanel getPnChipsBtn() {
		if (pnChipsBtn == null) {
			pnChipsBtn = new JPanel();
			pnChipsBtn.add(getBtnGetChips());
		}
		return pnChipsBtn;
	}

	private JButton getBtnGetChips() {
		if (btnGetChips == null) {
			btnGetChips = new JButton("Chips");
			btnGetChips.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnGetChips;
	}

	private JLabel getLblPlayerChips() {
		if (lblPlayerChips == null) {
			lblPlayerChips = new JLabel("Chips:");
			lblPlayerChips.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblPlayerChips;
	}

	private JPanel getPnPlayerChips() {
		if (pnPlayerChips == null) {
			pnPlayerChips = new JPanel();
			pnPlayerChips.setLayout(new GridLayout(0, 1, 0, 0));
			pnPlayerChips.add(getPnFiveChip());
			pnPlayerChips.add(getPnTenChip());
			pnPlayerChips.add(getPnTwentyChip());
			pnPlayerChips.add(getPnFiftyChip());
			pnPlayerChips.add(getPnOneHundredChip());
		}
		return pnPlayerChips;
	}

	private JPanel getPnFiveChip() {
		if (pnFiveChip == null) {
			pnFiveChip = new JPanel();
			pnFiveChip.add(getLblFiveChipIcon());
			pnFiveChip.add(getTxtFiveChipUnits());
		}
		return pnFiveChip;
	}

	private JLabel getLblFiveChipIcon() {
		if (lblFiveChipIcon == null) {
			lblFiveChipIcon = new JLabel("FiveChipIcon");
			lblFiveChipIcon.setLabelFor(getTxtFiveChipUnits());
			lblFiveChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiveChipIcon;
	}

	private JTextField getTxtFiveChipUnits() {
		if (txtFiveChipUnits == null) {
			txtFiveChipUnits = new JTextField();
			txtFiveChipUnits.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtFiveChipUnits.setEditable(false);
			txtFiveChipUnits.setColumns(10);
		}
		return txtFiveChipUnits;
	}

	private JPanel getPnTenChip() {
		if (pnTenChip == null) {
			pnTenChip = new JPanel();
			pnTenChip.add(getLblTenChipIcon());
			pnTenChip.add(getTxtTenChipUnits());
		}
		return pnTenChip;
	}

	private JLabel getLblTenChipIcon() {
		if (lblTenChipIcon == null) {
			lblTenChipIcon = new JLabel("TenChipIcon");
			lblTenChipIcon.setLabelFor(getTxtTenChipUnits());
			lblTenChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTenChipIcon;
	}

	private JTextField getTxtTenChipUnits() {
		if (txtTenChipUnits == null) {
			txtTenChipUnits = new JTextField();
			txtTenChipUnits.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtTenChipUnits.setEditable(false);
			txtTenChipUnits.setColumns(10);
		}
		return txtTenChipUnits;
	}

	private JPanel getPnTwentyChip() {
		if (pnTwentyChip == null) {
			pnTwentyChip = new JPanel();
			pnTwentyChip.add(getLblTwentyChipIcon());
			pnTwentyChip.add(getTxtTwentyChipUnits());
		}
		return pnTwentyChip;
	}

	private JLabel getLblTwentyChipIcon() {
		if (lblTwentyChipIcon == null) {
			lblTwentyChipIcon = new JLabel("TwentyChipIcon");
			lblTwentyChipIcon.setLabelFor(getTxtTwentyChipUnits());
			lblTwentyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblTwentyChipIcon;
	}

	private JTextField getTxtTwentyChipUnits() {
		if (txtTwentyChipUnits == null) {
			txtTwentyChipUnits = new JTextField();
			txtTwentyChipUnits.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtTwentyChipUnits.setEditable(false);
			txtTwentyChipUnits.setColumns(10);
		}
		return txtTwentyChipUnits;
	}

	private JPanel getPnFiftyChip() {
		if (pnFiftyChip == null) {
			pnFiftyChip = new JPanel();
			pnFiftyChip.add(getLblFiftyChipIcon());
			pnFiftyChip.add(getTxtFiftyChipUnits());
		}
		return pnFiftyChip;
	}

	private JLabel getLblFiftyChipIcon() {
		if (lblFiftyChipIcon == null) {
			lblFiftyChipIcon = new JLabel("FiftyChipIcon");
			lblFiftyChipIcon.setLabelFor(getTxtFiftyChipUnits());
			lblFiftyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFiftyChipIcon;
	}

	private JTextField getTxtFiftyChipUnits() {
		if (txtFiftyChipUnits == null) {
			txtFiftyChipUnits = new JTextField();
			txtFiftyChipUnits.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtFiftyChipUnits.setEditable(false);
			txtFiftyChipUnits.setColumns(10);
		}
		return txtFiftyChipUnits;
	}

	private JPanel getPnOneHundredChip() {
		if (pnOneHundredChip == null) {
			pnOneHundredChip = new JPanel();
			pnOneHundredChip.add(getLblOneHundredChipIcon());
			pnOneHundredChip.add(getTxtOneHundredChipUnits());
		}
		return pnOneHundredChip;
	}

	private JLabel getLblOneHundredChipIcon() {
		if (lblOneHundredChipIcon == null) {
			lblOneHundredChipIcon = new JLabel("OneHundredChipIcon");
			lblOneHundredChipIcon.setLabelFor(getTxtOneHundredChipUnits());
			lblOneHundredChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblOneHundredChipIcon;
	}

	private JTextField getTxtOneHundredChipUnits() {
		if (txtOneHundredChipUnits == null) {
			txtOneHundredChipUnits = new JTextField();
			txtOneHundredChipUnits.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtOneHundredChipUnits.setEditable(false);
			txtOneHundredChipUnits.setColumns(10);
		}
		return txtOneHundredChipUnits;
	}

	private JPanel getPnTopBoard() {
		if (pnTopBoard == null) {
			pnTopBoard = new JPanel();
			pnTopBoard.setLayout(new GridLayout(1, 3, 0, 0));
			pnTopBoard.add(getPnBoardZero());
			pnTopBoard.add(getPnBoardNumbers());
			pnTopBoard.add(getPnBoardColumns());
		}
		return pnTopBoard;
	}

	private JPanel getPnBoardZero() {
		if (pnBoardZero == null) {
			pnBoardZero = new JPanel();
			pnBoardZero.setLayout(new GridLayout(1, 0, 0, 0));
			pnBoardZero.add(getBtnBoardZero());
		}
		return pnBoardZero;
	}

	private JButton getBtnBoardZero() {
		if (btnBoardZero == null) {
			btnBoardZero = new JButton("0");
			btnBoardZero.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardZero;
	}

	private JPanel getPnBoardNumbers() {
		if (pnBoardNumbers == null) {
			pnBoardNumbers = new JPanel();
			pnBoardNumbers.setLayout(new GridLayout(3, 12, 0, 0));
		}
		return pnBoardNumbers;
	}

	private JPanel getPnBoardColumns() {
		if (pnBoardColumns == null) {
			pnBoardColumns = new JPanel();
			pnBoardColumns.setLayout(new GridLayout(0, 1, 0, 0));
			pnBoardColumns.add(getBtnBoardThirdCol());
			pnBoardColumns.add(getBtnBoardSecCol());
			pnBoardColumns.add(getBtnBoardFirstCol());
		}
		return pnBoardColumns;
	}

	private JButton getBtnBoardThirdCol() {
		if (btnBoardThirdCol == null) {
			btnBoardThirdCol = new JButton("3rd Col");
			btnBoardThirdCol.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardThirdCol;
	}

	private JButton getBtnBoardSecCol() {
		if (btnBoardSecCol == null) {
			btnBoardSecCol = new JButton("2nd Col");
			btnBoardSecCol.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardSecCol;
	}

	private JButton getBtnBoardFirstCol() {
		if (btnBoardFirstCol == null) {
			btnBoardFirstCol = new JButton("1st Col");
			btnBoardFirstCol.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardFirstCol;
	}

	private JPanel getPnBotBoard() {
		if (pnBotBoard == null) {
			pnBotBoard = new JPanel();
			pnBotBoard.setLayout(new GridLayout(2, 1, 0, 0));
			pnBotBoard.add(getPnBoardDozens());
			pnBotBoard.add(getPnBoardOther());
		}
		return pnBotBoard;
	}

	private JPanel getPnBoardDozens() {
		if (pnBoardDozens == null) {
			pnBoardDozens = new JPanel();
			pnBoardDozens.setLayout(new GridLayout(1, 3, 0, 0));
			pnBoardDozens.add(getBtnBoardFirstDozen());
			pnBoardDozens.add(getBtnBoardSecDozen());
			pnBoardDozens.add(getBtnBoardThirdDozen());
		}
		return pnBoardDozens;
	}

	private JButton getBtnBoardFirstDozen() {
		if (btnBoardFirstDozen == null) {
			btnBoardFirstDozen = new JButton("1st Dozen");
			btnBoardFirstDozen.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardFirstDozen;
	}

	private JButton getBtnBoardSecDozen() {
		if (btnBoardSecDozen == null) {
			btnBoardSecDozen = new JButton("2nd Dozen");
			btnBoardSecDozen.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardSecDozen;
	}

	private JButton getBtnBoardThirdDozen() {
		if (btnBoardThirdDozen == null) {
			btnBoardThirdDozen = new JButton("3rd Dozen");
			btnBoardThirdDozen.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardThirdDozen;
	}

	private JPanel getPnBoardOther() {
		if (pnBoardOther == null) {
			pnBoardOther = new JPanel();
			pnBoardOther.setLayout(new GridLayout(1, 6, 0, 0));
			pnBoardOther.add(getBtnBoardFail());
			pnBoardOther.add(getBtnBoardEven());
			pnBoardOther.add(getBtnBoardBlack());
			pnBoardOther.add(getBtnBoardRed());
			pnBoardOther.add(getBtnBoardOdd());
			pnBoardOther.add(getBtnBoardPass());
		}
		return pnBoardOther;
	}

	private JButton getBtnBoardFail() {
		if (btnBoardFail == null) {
			btnBoardFail = new JButton("1-18");
			btnBoardFail.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardFail;
	}

	private JButton getBtnBoardEven() {
		if (btnBoardEven == null) {
			btnBoardEven = new JButton("Even");
			btnBoardEven.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardEven;
	}

	private JButton getBtnBoardBlack() {
		if (btnBoardBlack == null) {
			btnBoardBlack = new JButton("Black");
			btnBoardBlack.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardBlack;
	}

	private JButton getBtnBoardRed() {
		if (btnBoardRed == null) {
			btnBoardRed = new JButton("Red");
			btnBoardRed.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardRed;
	}

	private JButton getBtnBoardOdd() {
		if (btnBoardOdd == null) {
			btnBoardOdd = new JButton("Odd");
			btnBoardOdd.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardOdd;
	}

	private JButton getBtnBoardPass() {
		if (btnBoardPass == null) {
			btnBoardPass = new JButton("19-36");
			btnBoardPass.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return btnBoardPass;
	}

	// Auxiliary methods
	private void spinRoulette() {
		roulette.spin();
		writeInResultsTextArea();
		roulette.detachAllBets();
	}

	private void writeInResultsTextArea() {
		StringBuilder sb = new StringBuilder();
		roulette.getResults().parallelStream().forEach(b -> sb.append(b.toString() + "\n"));
		taResults.setText(sb.toString());
	}
}
