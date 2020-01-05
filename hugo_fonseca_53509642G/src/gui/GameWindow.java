package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import business.bets.types.FailPassType;
import business.bets.types.OddEvenType;
import business.bets.types.RedBlackType;
import business.chips.Chip;
import business.facade.BetFacade;
import business.facade.ChipFacade;
import business.facade.ImageFacade;
import business.player.Player;
import business.roulette.Roulette;
import gui.bank.BankWindow;
import gui.credentials.users.LogOutWindow;
import gui.credentials.users.SignInWindow;

public class GameWindow extends JFrame {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private Roulette roulette;
	private Player player;
	private SignInWindow signInWindow;
	private LogOutWindow logOutWindow;
	private BankWindow bankWindow;
	private ImageFacade imgFacade;
	private BetFacade betFacade;
	private ChipFacade chipFacade;
	private Chip currentBetChip;

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
					Properties props = new Properties();
					props.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/img/roulette.jpg")));
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
		this.roulette = Roulette.getInstance();
		this.player = Player.getInstance();
		this.imgFacade = new ImageFacade();
		this.betFacade = new BetFacade();
		this.chipFacade = new ChipFacade();
		createNumberButtons();
		openUserCredentialsWindow();
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
			pnBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
			lblBarIcon = new JLabel("");
			lblBarIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/barIcon.png")));
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
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openLogOutWindow();
				}
			});
			btnLogOut.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnLogOut;
	}

	private JButton getBtnRoulette() {
		if (btnRoulette == null) {
			btnRoulette = new JButton("");
			
			ImageIcon imageIcon = new ImageIcon(GameWindow.class.getResource("/img/roulette.jpg"));
			Image img = imageIcon.getImage();
			Image newImg = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newImg);
			btnRoulette.setIcon(imageIcon);
			btnRoulette.setDisabledIcon(imageIcon);
			btnRoulette.setEnabled(false);
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
			pnChips.setLayout(new BorderLayout(0, 0));
			pnChips.add(getPnChipsInfo(), BorderLayout.CENTER);
			pnChips.add(getPnChipsBtn(), BorderLayout.SOUTH);
			pnChips.add(getLblPlayerChips(), BorderLayout.NORTH);
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
			pnChipsInfo.add(getPnPlayerChips());
		}
		return pnChipsInfo;
	}

	private JPanel getPnChipsBtn() {
		if (pnChipsBtn == null) {
			pnChipsBtn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnChipsBtn.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnChipsBtn.add(getBtnGetChips());
		}
		return pnChipsBtn;
	}

	private JButton getBtnGetChips() {
		if (btnGetChips == null) {
			btnGetChips = new JButton("Chips");
			btnGetChips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openBankWindow();
				}
			});
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
			lblFiveChipIcon = new JLabel("");
			lblFiveChipIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/chipFive.png")));
			lblFiveChipIcon.setLabelFor(getTxtFiveChipUnits());
			lblFiveChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
			lblFiveChipIcon.addMouseListener(new ProcessDragChipFive());
			lblFiveChipIcon.setTransferHandler(new TransferHandler("foreground"));
			lblFiveChipIcon.setForeground(Color.BLUE);
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
			lblTenChipIcon = new JLabel("");
			lblTenChipIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/chipTen.png")));
			lblTenChipIcon.setLabelFor(getTxtTenChipUnits());
			lblTenChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
			lblTenChipIcon.addMouseListener(new ProcessDragChipTen());
			lblTenChipIcon.setTransferHandler(new TransferHandler("foreground"));
			lblTenChipIcon.setForeground(Color.BLUE);
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
			lblTwentyChipIcon = new JLabel("");
			lblTwentyChipIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/chipTwenty.png")));
			lblTwentyChipIcon.setLabelFor(getTxtTwentyChipUnits());
			lblTwentyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
			lblTwentyChipIcon.addMouseListener(new ProcessDragChipTwenty());
			lblTwentyChipIcon.setTransferHandler(new TransferHandler("foreground"));
			lblTwentyChipIcon.setForeground(Color.BLUE);
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
			lblFiftyChipIcon = new JLabel("");
			lblFiftyChipIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/chipFifty.png")));
			lblFiftyChipIcon.setLabelFor(getTxtFiftyChipUnits());
			lblFiftyChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
			lblFiftyChipIcon.addMouseListener(new ProcessDragChipFifty());
			lblFiftyChipIcon.setTransferHandler(new TransferHandler("foreground"));
			lblFiftyChipIcon.setForeground(Color.BLUE);
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
			lblOneHundredChipIcon = new JLabel("");
			lblOneHundredChipIcon.setIcon(new ImageIcon(GameWindow.class.getResource("/img/chipOneHundred.png")));
			lblOneHundredChipIcon.setLabelFor(getTxtOneHundredChipUnits());
			lblOneHundredChipIcon.setFont(new Font("Dialog", Font.BOLD, 14));
			lblOneHundredChipIcon.addMouseListener(new ProcessDragChipOneHundred());
			lblOneHundredChipIcon.setTransferHandler(new TransferHandler("foreground"));
			lblOneHundredChipIcon.setForeground(Color.BLUE);
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
			pnTopBoard.setLayout(new BoxLayout(pnTopBoard, BoxLayout.X_AXIS));
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
			btnBoardZero.addPropertyChangeListener(new ProcessButtonNumber(0));
			btnBoardZero.setTransferHandler(new TransferHandler("foreground"));
			btnBoardZero.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardZero.setHorizontalTextPosition(SwingConstants.CENTER);
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
			btnBoardThirdCol.setFont(new Font("Dialog", Font.BOLD, 14));
			btnBoardThirdCol.addPropertyChangeListener(new ProcessButtonColumn(3));
			btnBoardThirdCol.setTransferHandler(new TransferHandler("foreground"));
			btnBoardThirdCol.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardThirdCol.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardThirdCol;
	}

	private JButton getBtnBoardSecCol() {
		if (btnBoardSecCol == null) {
			btnBoardSecCol = new JButton("2nd Col");
			btnBoardSecCol.setFont(new Font("Dialog", Font.BOLD, 14));
			btnBoardSecCol.addPropertyChangeListener(new ProcessButtonColumn(2));
			btnBoardSecCol.setTransferHandler(new TransferHandler("foreground"));
			btnBoardSecCol.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardSecCol.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardSecCol;
	}

	private JButton getBtnBoardFirstCol() {
		if (btnBoardFirstCol == null) {
			btnBoardFirstCol = new JButton("1st Col");
			btnBoardFirstCol.setFont(new Font("Dialog", Font.BOLD, 14));
			btnBoardFirstCol.addPropertyChangeListener(new ProcessButtonColumn(1));
			btnBoardFirstCol.setTransferHandler(new TransferHandler("foreground"));
			btnBoardFirstCol.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardFirstCol.setHorizontalTextPosition(SwingConstants.CENTER);
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
			btnBoardFirstDozen.addPropertyChangeListener(new ProcessButtonDozen(1));
			btnBoardFirstDozen.setTransferHandler(new TransferHandler("foreground"));
			btnBoardFirstDozen.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardFirstDozen.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardFirstDozen;
	}

	private JButton getBtnBoardSecDozen() {
		if (btnBoardSecDozen == null) {
			btnBoardSecDozen = new JButton("2nd Dozen");
			btnBoardSecDozen.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardSecDozen.addPropertyChangeListener(new ProcessButtonDozen(2));
			btnBoardSecDozen.setTransferHandler(new TransferHandler("foreground"));
			btnBoardSecDozen.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardSecDozen.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardSecDozen;
	}

	private JButton getBtnBoardThirdDozen() {
		if (btnBoardThirdDozen == null) {
			btnBoardThirdDozen = new JButton("3rd Dozen");
			btnBoardThirdDozen.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardThirdDozen.addPropertyChangeListener(new ProcessButtonDozen(3));
			btnBoardThirdDozen.setTransferHandler(new TransferHandler("foreground"));
			btnBoardThirdDozen.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardThirdDozen.setHorizontalTextPosition(SwingConstants.CENTER);
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
			btnBoardFail.addPropertyChangeListener(new ProcessButtonFailPass(FailPassType.FAIL));
			btnBoardFail.setTransferHandler(new TransferHandler("foreground"));
			btnBoardFail.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardFail.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardFail;
	}

	private JButton getBtnBoardEven() {
		if (btnBoardEven == null) {
			btnBoardEven = new JButton("Even");
			btnBoardEven.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardEven.addPropertyChangeListener(new ProcessButtonOddEven(OddEvenType.EVEN));
			btnBoardEven.setTransferHandler(new TransferHandler("foreground"));
			btnBoardEven.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardEven.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardEven;
	}

	private JButton getBtnBoardBlack() {
		if (btnBoardBlack == null) {
			btnBoardBlack = new JButton("Black");
			btnBoardBlack.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardBlack.addPropertyChangeListener(new ProcessButtonRedBlack(RedBlackType.BLACK));
			btnBoardBlack.setTransferHandler(new TransferHandler("foreground"));
			btnBoardBlack.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardBlack.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardBlack;
	}

	private JButton getBtnBoardRed() {
		if (btnBoardRed == null) {
			btnBoardRed = new JButton("Red");
			btnBoardRed.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardRed.addPropertyChangeListener(new ProcessButtonRedBlack(RedBlackType.RED));
			btnBoardRed.setTransferHandler(new TransferHandler("foreground"));
			btnBoardRed.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardRed.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardRed;
	}

	private JButton getBtnBoardOdd() {
		if (btnBoardOdd == null) {
			btnBoardOdd = new JButton("Odd");
			btnBoardOdd.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardOdd.addPropertyChangeListener(new ProcessButtonOddEven(OddEvenType.ODD));
			btnBoardOdd.setTransferHandler(new TransferHandler("foreground"));
			btnBoardOdd.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardOdd.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardOdd;
	}

	private JButton getBtnBoardPass() {
		if (btnBoardPass == null) {
			btnBoardPass = new JButton("19-36");
			btnBoardPass.setFont(new Font("Dialog", Font.BOLD, 18));
			btnBoardPass.addPropertyChangeListener(new ProcessButtonFailPass(FailPassType.PASS));
			btnBoardPass.setTransferHandler(new TransferHandler("foreground"));
			btnBoardPass.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBoardPass.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBoardPass;
	}

	// Auxiliary methods
	private void spinRoulette() {
		roulette.spin();
		writeInResultsTextArea();			
		updatePlayerBalance();
		updateShownPlayerBalance();
		roulette.detachAllBets();
		updatePlayerChips();
		resetButtons();
		getBtnRoulette().setEnabled(false);
	}

	private void updatePlayerBalance() {
		double newBalance = roulette.getResults().stream().map(r -> r.getBetBenefit()).reduce(0.0, (a, b) -> a + b);
		double oldBalance = player.getBalance();
		player.setBalance(oldBalance + newBalance);
	}

	private void writeInResultsTextArea() {
		StringBuilder sb = new StringBuilder();
		roulette.getResults().parallelStream().forEach(b -> sb.append(b.toString() + "\n"));
		taResults.setText(sb.toString());
	}

	private JButton createNumberButton(int number, int pos) {
		JButton btn = new JButton(String.valueOf(number));
		if (checkRed(number) == true) {
			btn.setForeground(Color.RED);
		} else {
			btn.setForeground(Color.WHITE);
		}
		btn.setFont(new Font("Dialog", Font.BOLD, 14));
		btn.setActionCommand(String.valueOf(pos));
		btn.addPropertyChangeListener(new ProcessButtonNumber(number));
		btn.setTransferHandler(new TransferHandler("foreground"));
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		return btn;
	}

	private boolean checkRed(int number) {
		for (Integer n : roulette.getRedNumbers()) {
			if (number == n) {
				return true;
			}
		}
		return false;
	}

	private void createNumberButtons() {
		int pos = 0;
		for (int k = 3; k >= 1; k--) {
			for (int i = k; i <= 33 + k; i += 3) {
				getPnBoardNumbers().add(createNumberButton(i, pos));
				pos++;
			}
		}
	}

	public void onUserLogged() {
		initializeRoulette();
		updateShownPlayerBalance();
	}

	public void updateShownPlayerBalance() {
		getTxtBalance().setText(String.valueOf(player.getBalance()));
	}

	private void initializeRoulette() {
		restartPlayerChips();
	}

	private void restartPlayerChips() {
		getTxtFiveChipUnits().setText("0");
		getTxtTenChipUnits().setText("0");
		getTxtTwentyChipUnits().setText("0");
		getTxtFiftyChipUnits().setText("0");
		getTxtOneHundredChipUnits().setText("0");
	}

	public void updatePlayerChips() {
		int chipsFive = player.getChips().stream().filter(c -> c.getAmount() == 5).collect(Collectors.toList()).size();
		int chipsTen = player.getChips().stream().filter(c -> c.getAmount() == 10).collect(Collectors.toList()).size();
		int chipsTwenty = player.getChips().stream().filter(c -> c.getAmount() == 20).collect(Collectors.toList()).size();
		int chipsFifty = player.getChips().stream().filter(c -> c.getAmount() == 50).collect(Collectors.toList()).size();
		int chipsOneHundred = player.getChips().stream().filter(c -> c.getAmount() == 100).collect(Collectors.toList()).size();

		getTxtFiveChipUnits().setText(String.valueOf(chipsFive));
		getTxtTenChipUnits().setText(String.valueOf(chipsTen));
		getTxtTwentyChipUnits().setText(String.valueOf(chipsTwenty));
		getTxtFiftyChipUnits().setText(String.valueOf(chipsFifty));
		getTxtOneHundredChipUnits().setText(String.valueOf(chipsOneHundred));
	}

	private void openUserCredentialsWindow() {
		this.signInWindow = new SignInWindow(this);
		this.signInWindow.setModal(true);
		this.signInWindow.setLocationRelativeTo(this);
		this.signInWindow.setVisible(true);
	}
	
	private class ProcessDragChipFive extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int playerChipsFive = player.getChips().stream().filter(c -> c.getAmount() == 5).collect(Collectors.toList()).size();
			if (playerChipsFive > 0) {
				currentBetChip = chipFacade.makeChipFive();
				JComponent c = (JComponent) e.getSource();
				TransferHandler handler = c.getTransferHandler();
				handler.exportAsDrag(c, e, TransferHandler.COPY);
			}
		}
	}
	
	private class ProcessDragChipTen extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int playerChipsTen = player.getChips().stream().filter(c -> c.getAmount() == 10).collect(Collectors.toList()).size();
			if (playerChipsTen > 0) {
				currentBetChip = chipFacade.makeChipTen();
				JComponent c = (JComponent) e.getSource();
				TransferHandler handler = c.getTransferHandler();
				handler.exportAsDrag(c, e, TransferHandler.COPY);
			}
		}
	}
	
	private class ProcessDragChipTwenty extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int playerChipsTwenty = player.getChips().stream().filter(c -> c.getAmount() == 20).collect(Collectors.toList()).size();
			if (playerChipsTwenty > 0) {
				currentBetChip = chipFacade.makeChipTwenty();
				JComponent c = (JComponent) e.getSource();
				TransferHandler handler = c.getTransferHandler();
				handler.exportAsDrag(c, e, TransferHandler.COPY);
			}
		}
	}
	
	private class ProcessDragChipFifty extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int playerChipsFifty = player.getChips().stream().filter(c -> c.getAmount() == 50).collect(Collectors.toList()).size();
			if (playerChipsFifty > 0) {
				currentBetChip = chipFacade.makeChipFifty();
				JComponent c = (JComponent) e.getSource();
				TransferHandler handler = c.getTransferHandler();
				handler.exportAsDrag(c, e, TransferHandler.COPY);
			}
		}
	}
	
	private class ProcessDragChipOneHundred extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int playerChipsOneHundred = player.getChips().stream().filter(c -> c.getAmount() == 100).collect(Collectors.toList()).size();
			if (playerChipsOneHundred > 0) {
				currentBetChip = chipFacade.makeChipOneHundred();
				JComponent c = (JComponent) e.getSource();
				TransferHandler handler = c.getTransferHandler();
				handler.exportAsDrag(c, e, TransferHandler.COPY);
			}
		}
	}
	
	private class ProcessButtonNumber implements PropertyChangeListener {
		
		// Attribute
		private int number;
		
		public ProcessButtonNumber(int number) {
			this.number = number;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeNumberBet(currentBetChip.getAmount(), number));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}
	
	private class ProcessButtonColumn implements PropertyChangeListener {
		
		// Attributes
		private int column;
		
		public ProcessButtonColumn(int column) {
			this.column = column;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeColumnBet(currentBetChip.getAmount(), column));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}
	
	private class ProcessButtonDozen implements PropertyChangeListener {
		
		// Attributes
		private int dozen;
		
		public ProcessButtonDozen(int dozen) {
			this.dozen = dozen;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeDozenBet(currentBetChip.getAmount(), dozen));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}
	
	private class ProcessButtonFailPass implements PropertyChangeListener {
		
		// Attributes
		private boolean pass;
		
		public ProcessButtonFailPass(boolean pass) {
			this.pass = pass;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeFailPassBet(currentBetChip.getAmount(), pass));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}
	
	private class ProcessButtonOddEven implements PropertyChangeListener {
		
		// Attributes
		private boolean even;
		
		public ProcessButtonOddEven(boolean even) {
			this.even = even;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeOddEvenBet(currentBetChip.getAmount(), even));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}
	
	private class ProcessButtonRedBlack implements PropertyChangeListener {
		
		// Attributes
		private boolean red;
		
		public ProcessButtonRedBlack(boolean red) {
			this.red = red;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground") && e.getNewValue().equals(Color.BLUE)) {
				JButton btn = (JButton) e.getSource();
				setChipIconOnButton(btn, currentBetChip);				
				roulette.attachBet(betFacade.makeRedBlackBet(currentBetChip.getAmount(), red));
				player.removeChipOfType(currentBetChip.getAmount()); 
				getBtnRoulette().setEnabled(true);
				updatePlayerChips();
			}
		}
	}

	private void setChipIconOnButton(JButton btn, Chip chip) {
		btn.setIcon(imgFacade.getImageForChip(chip));
	}
	
	private void resetButtons() {
		getBtnBoardZero().setIcon(null);
		getBtnBoardZero().setForeground(Color.WHITE);
		for (int i = 0; i < getPnBoardColumns().getComponents().length; i++) {
			((JButton) getPnBoardColumns().getComponents()[i]).setIcon(null);
			((JButton) getPnBoardColumns().getComponents()[i]).setForeground(Color.WHITE);
		}
		for (int i = 0; i < getPnBoardDozens().getComponents().length; i++) {
			((JButton) getPnBoardDozens().getComponents()[i]).setIcon(null);
			((JButton) getPnBoardDozens().getComponents()[i]).setForeground(Color.WHITE);
		}
		for (int i = 0; i < getPnBoardOther().getComponents().length; i++) {
			((JButton) getPnBoardOther().getComponents()[i]).setIcon(null);
			((JButton) getPnBoardOther().getComponents()[i]).setForeground(Color.WHITE);
		}
		for (int i = 0; i < getPnBoardNumbers().getComponents().length; i++) {
			((JButton) getPnBoardNumbers().getComponents()[i]).setIcon(null);
			if (checkRed(Integer.parseInt(((JButton) getPnBoardNumbers().getComponents()[i]).getText())) == true) {
				((JButton) getPnBoardNumbers().getComponents()[i]).setForeground(Color.RED);
			} else {
				((JButton) getPnBoardNumbers().getComponents()[i]).setForeground(Color.WHITE);
			}
		}
	}
	
	private void openLogOutWindow() {
		this.logOutWindow = new LogOutWindow(this);
		this.logOutWindow.setModal(true);
		this.logOutWindow.setLocationRelativeTo(this);
		this.logOutWindow.setVisible(true);
	}
	
	private void openBankWindow() {
		this.bankWindow = new BankWindow(this);
		this.bankWindow.setModal(true);
		this.bankWindow.setLocationRelativeTo(this);
		this.bankWindow.setVisible(true);
	}
	
}
