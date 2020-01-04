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

	public Product[] getProductAsArray() {
		return bm.loadProductsAsArray();
	}
	
	public List<Product> getProductsAsList() {
		return bm.loadProductsAsList(); 
	}
	
	public Product[] filterProductByType(int type) {
		return bm.filterProductByType(type);
	}

}
