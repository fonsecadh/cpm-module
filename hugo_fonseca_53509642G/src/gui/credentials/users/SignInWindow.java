package gui.credentials.users;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class SignInWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private JLabel lblUsername;
	private JLabel lblSignIn;
	private JTextField txtUsername;
	private JLabel lblPasswd;
	private JPasswordField pfPasswd;
	private JButton btnSignIn;
	private JLabel lblNewUser;
	private JButton btnNewUser;
	private JPanel pnSignIn;
	private JPanel pnSignUp;

	/**
	 * Create the dialog.
	 */
	public SignInWindow() {
		setTitle("Roulette: Sign In");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(getLblSignIn());
		getContentPane().add(getLblUsername());
		getContentPane().add(getTxtUsername());
		getContentPane().add(getLblPasswd());
		getContentPane().add(getPfPasswd());
		getContentPane().add(getPnSignIn());
		getContentPane().add(getLblNewUser());
		getContentPane().add(getPnSignUp());
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("User Name:");
			lblUsername.setLabelFor(getTxtUsername());
			lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblUsername;
	}

	private JLabel getLblSignIn() {
		if (lblSignIn == null) {
			lblSignIn = new JLabel("Sign In");
			lblSignIn.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblSignIn;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JLabel getLblPasswd() {
		if (lblPasswd == null) {
			lblPasswd = new JLabel("Password:");
			lblPasswd.setLabelFor(getPfPasswd());
			lblPasswd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblPasswd;
	}

	private JPasswordField getPfPasswd() {
		if (pfPasswd == null) {
			pfPasswd = new JPasswordField();
			pfPasswd.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return pfPasswd;
	}

	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("Sign In");
			btnSignIn.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnSignIn;
	}

	private JLabel getLblNewUser() {
		if (lblNewUser == null) {
			lblNewUser = new JLabel("New User");
			lblNewUser.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblNewUser;
	}

	private JButton getBtnNewUser() {
		if (btnNewUser == null) {
			btnNewUser = new JButton("Sign Up");
			btnNewUser.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnNewUser;
	}

	private JPanel getPnSignIn() {
		if (pnSignIn == null) {
			pnSignIn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnSignIn.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnSignIn.add(getBtnSignIn());
		}
		return pnSignIn;
	}

	private JPanel getPnSignUp() {
		if (pnSignUp == null) {
			pnSignUp = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnSignUp.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnSignUp.add(getBtnNewUser());
		}
		return pnSignUp;
	}
}
