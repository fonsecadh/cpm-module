package gui.bar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import business.bar.products.Product;
import business.exceptions.order.OrderException;
import business.facade.BarFacade;
import business.facade.ImageFacade;
import business.player.Player;

public class BarWindow extends JDialog {

	// Constants
	private static final long serialVersionUID = 1L;

	// Attributes
	private BarFacade barFacade;
	private ImageFacade imageFacade;
	private Player player;

	private JPanel pnFilter;
	private JButton btnAlcoholic;
	private JButton btnNonAlcoholic;
	private JLabel lblDrinkFilter;
	private JPanel pnBtns;
	private JButton btnOk;
	private JButton btnCancel;
	private JPanel pnOrdering;
	private JPanel pnOrderProducts;
	private JPanel pnOrderActions;
	private JLabel lblProducts;
	private JComboBox<Product> cbProducts;
	private JPanel pnProducts;
	private JLabel lblProductIcon;
	private JScrollPane spCart;
	private JTextArea taCart;
	private JLabel lblUnits;
	private JPanel pnActions;
	private JSpinner spinnerUnits;
	private JButton btnAdd;
	private JButton btnRemove;
	private JPanel pnOrderPrice;
	private JLabel lblOrderPrice;
	private JTextField txtOrderPrice;
	private JPanel pnBalance;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JLabel lblComments;
	private JScrollPane spComments;
	private JTextArea taComments;

	/**
	 * Create the dialog.
	 */
	public BarWindow() {
		setTitle("Roulette: Bar");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnFilter(), BorderLayout.WEST);
		getContentPane().add(getPnBtns(), BorderLayout.SOUTH);
		getContentPane().add(getPnOrdering(), BorderLayout.CENTER);

		// Business logic
		this.barFacade = new BarFacade();
		this.imageFacade = new ImageFacade();
		this.player = Player.getInstance();

	}

	private JPanel getPnFilter() {
		if (pnFilter == null) {
			pnFilter = new JPanel();
			pnFilter.setLayout(new GridLayout(0, 1, 0, 0));
			pnFilter.add(getLblDrinkFilter());
			pnFilter.add(getBtnAlcoholic());
			pnFilter.add(getBtnNonAlcoholic());
		}
		return pnFilter;
	}

	private JButton getBtnAlcoholic() {
		if (btnAlcoholic == null) {
			btnAlcoholic = new JButton("Alcoholic");
			btnAlcoholic.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnAlcoholic;
	}

	private JButton getBtnNonAlcoholic() {
		if (btnNonAlcoholic == null) {
			btnNonAlcoholic = new JButton("Non Alcoholic");
			btnNonAlcoholic.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnNonAlcoholic;
	}

	private JLabel getLblDrinkFilter() {
		if (lblDrinkFilter == null) {
			lblDrinkFilter = new JLabel("Drink filter:");
			lblDrinkFilter.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblDrinkFilter;
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
					saveAndClose();
				}
			});
			btnOk.setEnabled(false);
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

	private JPanel getPnOrdering() {
		if (pnOrdering == null) {
			pnOrdering = new JPanel();
			pnOrdering.setLayout(new GridLayout(1, 0, 0, 0));
			pnOrdering.add(getPnOrderProducts());
			pnOrdering.add(getPnOrderActions());
		}
		return pnOrdering;
	}

	private JPanel getPnOrderProducts() {
		if (pnOrderProducts == null) {
			pnOrderProducts = new JPanel();
			pnOrderProducts.setLayout(new GridLayout(0, 1, 0, 0));
			pnOrderProducts.add(getLblProducts());
			pnOrderProducts.add(getPnProducts());
			pnOrderProducts.add(getLblProductIcon());
			pnOrderProducts.add(getSpCart());
		}
		return pnOrderProducts;
	}

	private JPanel getPnOrderActions() {
		if (pnOrderActions == null) {
			pnOrderActions = new JPanel();
			pnOrderActions.setLayout(new GridLayout(0, 1, 0, 0));
			pnOrderActions.add(getLblUnits());
			pnOrderActions.add(getPnActions());
			pnOrderActions.add(getPnOrderPrice());
			pnOrderActions.add(getPnBalance());
			pnOrderActions.add(getLblComments());
			pnOrderActions.add(getSpComments());
		}
		return pnOrderActions;
	}

	private JLabel getLblProducts() {
		if (lblProducts == null) {
			lblProducts = new JLabel("Products:");
			lblProducts.setLabelFor(getCbProducts());
			lblProducts.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblProducts;
	}

	private JComboBox<Product> getCbProducts() {
		if (cbProducts == null) {
			cbProducts = new JComboBox<Product>();
			cbProducts.setModel(new DefaultComboBoxModel<Product>(barFacade.getProductAsArray()));
			cbProducts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPicture();
					isDeletionPossible();
				}
			});
			cbProducts.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return cbProducts;
	}

	private JPanel getPnProducts() {
		if (pnProducts == null) {
			pnProducts = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnProducts.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnProducts.add(getCbProducts());
		}
		return pnProducts;
	}

	private JLabel getLblProductIcon() {
		if (lblProductIcon == null) {
			lblProductIcon = new JLabel("Product Icon");
			lblProductIcon.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblProductIcon;
	}

	private JScrollPane getSpCart() {
		if (spCart == null) {
			spCart = new JScrollPane();
			spCart.setViewportView(getTaCart());
		}
		return spCart;
	}

	private JTextArea getTaCart() {
		if (taCart == null) {
			taCart = new JTextArea();
			taCart.setFont(new Font("Dialog", Font.PLAIN, 14));
			taCart.setEditable(false);
		}
		return taCart;
	}

	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setLabelFor(getSpinnerUnits());
			lblUnits.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblUnits;
	}

	private JPanel getPnActions() {
		if (pnActions == null) {
			pnActions = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnActions.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnActions.add(getSpinnerUnits());
			pnActions.add(getBtnAdd());
			pnActions.add(getBtnRemove());
		}
		return pnActions;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerUnits() {
		if (spinnerUnits == null) {
			spinnerUnits = new JSpinner();
			spinnerUnits.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerUnits.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					isDeletionPossible();
				}
			});
			spinnerUnits.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return spinnerUnits;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addProductToOrder();
					updateShownOrderPrice();
					updateCurrentOrderInfo();
					enableNextButton();
					isDeletionPossible();
					resetSpinner();
				}
			});
			btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnAdd;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteFromProduct();
					updateShownOrderPrice();
					updateCurrentOrderInfo();
					enableNextButton();
					isDeletionPossible();
					resetSpinner();
				}
			});
			btnRemove.setEnabled(false);
			btnRemove.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnRemove;
	}

	private JPanel getPnOrderPrice() {
		if (pnOrderPrice == null) {
			pnOrderPrice = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnOrderPrice.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnOrderPrice.add(getLblOrderPrice());
			pnOrderPrice.add(getTxtOrderPrice());
		}
		return pnOrderPrice;
	}

	private JLabel getLblOrderPrice() {
		if (lblOrderPrice == null) {
			lblOrderPrice = new JLabel("Order price:");
			lblOrderPrice.setLabelFor(getTxtOrderPrice());
			lblOrderPrice.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblOrderPrice;
	}

	private JTextField getTxtOrderPrice() {
		if (txtOrderPrice == null) {
			txtOrderPrice = new JTextField();
			txtOrderPrice.setEditable(false);
			txtOrderPrice.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtOrderPrice.setColumns(10);
		}
		return txtOrderPrice;
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
			txtBalance.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtBalance.setEditable(false);
			txtBalance.setColumns(10);
		}
		return txtBalance;
	}

	private JLabel getLblComments() {
		if (lblComments == null) {
			lblComments = new JLabel("Comments:");
			lblComments.setLabelFor(getTaComments());
			lblComments.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return lblComments;
	}

	private JScrollPane getSpComments() {
		if (spComments == null) {
			spComments = new JScrollPane();
			spComments.setViewportView(getTaComments());
		}
		return spComments;
	}

	private JTextArea getTaComments() {
		if (taComments == null) {
			taComments = new JTextArea();
			taComments.setFont(new Font("Dialog", Font.PLAIN, 13));
		}
		return taComments;
	}

	// Auxiliary methods
	private void showPicture() {
		this.imageFacade.getImageForProduct((Product) getCbProducts().getSelectedItem());
	}

	private void isDeletionPossible() {
		Product selectedProduct = (Product) getCbProducts().getSelectedItem();
		int units = (int) getSpinnerUnits().getValue();
		if (barFacade.isDeletionPossible(selectedProduct, units)) {
			getBtnRemove().setEnabled(true);
		} else {
			getBtnRemove().setEnabled(false);
		}
	}

	private void addProductToOrder() {
		Product selectedProduct = (Product) getCbProducts().getSelectedItem();
		int units = (int) getSpinnerUnits().getValue();
		try {
			barFacade.addProduct(selectedProduct, units);
		} catch (OrderException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void resetSpinner() {
		getSpinnerUnits().setValue(1);
	}

	private void enableNextButton() {
		getBtnOk().setEnabled(true);
	}

	private void updateCurrentOrderInfo() {
		getTaCart().setText(barFacade.getOrderInfo());
	}

	@SuppressWarnings("deprecation")
	private void updateShownOrderPrice() {
		double total = barFacade.calculateTotalPrice();
		getTxtOrderPrice().setText(String.valueOf(BigDecimal.valueOf(total).setScale(2, BigDecimal.ROUND_HALF_UP)));
		updateShownPlayerCurrentBalance(total);
	}
	
	private void updateShownPlayerCurrentBalance(double orderTotal) {
		double currentBalance = player.getBalance() - orderTotal;
		getTxtBalance().setText(String.valueOf(currentBalance));
		if (currentBalance < 0) {
			getBtnOk().setEnabled(false);
		} else {
			getBtnOk().setEnabled(true);
		}
	}

	private void deleteFromProduct() {
		Product selectedProduct = (Product) getCbProducts().getSelectedItem();
		int units = (int) getSpinnerUnits().getValue();
		try {
			barFacade.removeProduct(selectedProduct, units);
		} catch (OrderException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void saveAndClose() {
		this.player.setBalance(Double.parseDouble(getTxtBalance().getText()));
		barFacade.addComment(getTaComments().getText());
		JOptionPane.showMessageDialog(this, barFacade.getOrderInfo(), "Order details", JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
}
