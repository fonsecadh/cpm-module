package gui.credentials.users;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private SignInWindow signInWindow;
	
	private JLabel lblSignUp;
	private JLabel lblUsername;
	private JLabel lblPasswd;
	private JLabel lblRePasswd;
	private JLabel lblUserID;
	private JLabel lblFullname;
	private JTextField txtUsername;
	private JPasswordField pfPasswd;
	private JPasswordField pfRePasswd;
	private JTextField txtUserID;
	private JTextField txtFullname;
	private JPanel pnSignUp;
	private JButton btnSignUp;
	private JButton btnCancel;

	/**
	 * Create the dialog.
	 */
	public SignUpWindow(SignInWindow signInWindow) {
		setTitle("Roulette: Sign Up");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(getLblSignUp());
		getContentPane().add(getLblUsername());
		getContentPane().add(getTxtUsername());
		getContentPane().add(getLblPasswd());
		getContentPane().add(getPfPasswd());
		getContentPane().add(getLblRePasswd());
		getContentPane().add(getPfRePasswd());
		getContentPane().add(getLblUserID());
		getContentPane().add(getTxtUserID());
		getContentPane().add(getLblFullname());
		getContentPane().add(getTxtFullname());
		getContentPane().add(getPnSignUp());
		
		// Business logic
		this.signInWindow = signInWindow;
	}

	private JLabel getLblSignUp() {
		if (lblSignUp == null) {
			lblSignUp = new JLabel("Sign Up");
			lblSignUp.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblSignUp;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("User Name:");
			lblUsername.setLabelFor(getTxtUsername());
			lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblUsername;
	}

	private JLabel getLblPasswd() {
		if (lblPasswd == null) {
			lblPasswd = new JLabel("Password:");
			lblPasswd.setLabelFor(getPfPasswd());
			lblPasswd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblPasswd;
	}

	private JLabel getLblRePasswd() {
		if (lblRePasswd == null) {
			lblRePasswd = new JLabel("Repeat password:");
			lblRePasswd.setLabelFor(getPfRePasswd());
			lblRePasswd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblRePasswd;
	}

	private JLabel getLblUserID() {
		if (lblUserID == null) {
			lblUserID = new JLabel("National ID:");
			lblUserID.setLabelFor(getTxtUserID());
			lblUserID.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblUserID;
	}

	private JLabel getLblFullname() {
		if (lblFullname == null) {
			lblFullname = new JLabel("Full Name:");
			lblFullname.setLabelFor(getTxtFullname());
			lblFullname.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblFullname;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JPasswordField getPfPasswd() {
		if (pfPasswd == null) {
			pfPasswd = new JPasswordField();
			pfPasswd.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return pfPasswd;
	}

	private JPasswordField getPfRePasswd() {
		if (pfRePasswd == null) {
			pfRePasswd = new JPasswordField();
			pfRePasswd.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return pfRePasswd;
	}

	private JTextField getTxtUserID() {
		if (txtUserID == null) {
			txtUserID = new JTextField();
			txtUserID.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtUserID.setColumns(10);
		}
		return txtUserID;
	}

	private JTextField getTxtFullname() {
		if (txtFullname == null) {
			txtFullname = new JTextField();
			txtFullname.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtFullname.setColumns(10);
		}
		return txtFullname;
	}

	private JPanel getPnSignUp() {
		if (pnSignUp == null) {
			pnSignUp = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnSignUp.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnSignUp.add(getBtnSignUp());
			pnSignUp.add(getBtnCancel());
		}
		return pnSignUp;
	}

	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("SignUp");
			btnSignUp.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnSignUp;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnCancel;
	}
}
