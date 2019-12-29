package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameWindow extends JFrame {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
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
			pnLogOut.add(getBtnLogOut());
		}
		return pnLogOut;
	}

	private JPanel getPnBar() {
		if (pnBar == null) {
			pnBar = new JPanel();
			pnBar.add(getLblBarIcon());
			pnBar.add(getBtnBar());
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
		}
		return pnBets;
	}

	private JPanel getPnChips() {
		if (pnChips == null) {
			pnChips = new JPanel();
		}
		return pnChips;
	}
}
