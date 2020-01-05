package business.facade;

import java.util.List;

import business.bar.Order;
import business.bar.factory.BarManagerFactory;
import business.bar.factory.BarManagerFactoryImpl;
import business.bar.factory.OrderFactory;
import business.bar.factory.OrderFactoryImpl;
import business.bar.managers.BarManager;
import business.bar.products.Product;
import business.exceptions.order.OrderException;

public class BarFacade {
	
	// Attributes
	private OrderFactory orderFactory = new OrderFactoryImpl();
	private Order order;
	private BarManagerFactory bmFactory = new BarManagerFactoryImpl();
	private BarManager bm;
	
	public BarFacade() {
		this.order = orderFactory.makeOrder();
		this.bm = bmFactory.makeBarManager();
	}

	public boolean isDeletionPossible(Product product, int units) {
		try {
			return order.canDeleteUnitsFromProduct(product, units);
		} catch (OrderException e) {
			return false;
		}
	}

	public void addProduct(Product selectedProduct, int units) throws OrderException {
		order.addProduct(selectedProduct, units);
	}

	public void removeProduct(Product selectedProduct, int units) throws OrderException {
		order.removeProduct(selectedProduct, units);
	}

	public double calculateTotalPrice() {
		return order.getTotal();
	}

	public void addComment(String comment) {
		order.addComment(comment);
	}

	public Product[] getProductAsArray() {
		return bm.loadProductsAsArray();
	}
	
	public List<Product> getProductsAsList() {
		return bm.loadProductsAsList(); 
	}
	
	public Product[] filterProductByType(int type) {
		return bm.filterProductByType(type);
	}

	public String getOrderInfo() {
		return order.toString();
	}

	public boolean noProductsInOrder() {
		return order.getTotal() == 0.0 ? true : false;
	}

}
