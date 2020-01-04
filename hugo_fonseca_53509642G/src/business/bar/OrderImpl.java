package business.bar;

import java.util.HashMap;
import java.util.Map;

import business.bar.products.Product;
import business.exceptions.order.OrderException;

public class OrderImpl implements Order {

	// Attributes
	private String comment;
	private Map<Product, Integer> products;

	// Constructor
	public OrderImpl() {
		this.products = new HashMap<Product, Integer>();
	}

	// Methods

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void addComment(String comment) {
		this.comment = comment;
	}

	@Override
	public void addProduct(Product product, int units) throws OrderException {
		if (units < 0) {
			throw new OrderException("Invalid number of units!");
		}

		Integer productUnits = products.get(product);

		if (productUnits != null) {
			product.setUnits(productUnits + units);
			products.replace(product, productUnits, product.getUnits());
		} else {
			product.setUnits(units);
			products.put(product, product.getUnits());
		}
	}

	@Override
	public void removeProduct(Product product, int units) throws OrderException {
		if (units < 0) {
			throw new OrderException("Invalid number of units!");
		}

		if (canDeleteUnitsFromProduct(product, units)) {
			Integer productUnits = products.get(product);

			if (productUnits == null) {
				throw new OrderException("Product does not exist!");
			} else {
				if (productUnits == units) {
					product.setUnits(0);
					products.remove(product);
				} else {
					product.setUnits(productUnits - units);
					products.replace(product, productUnits, product.getUnits());
				}
			}
		} else {
			throw new OrderException("Cannot delete that number of units!");
		}
	}

	@Override
	public boolean canDeleteUnitsFromProduct(Product product, int units) throws OrderException {
		Integer productUnits = products.get(product);

		if (productUnits == null) {
			throw new OrderException("Product does not exist!");
		} else if (productUnits < units) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public double getTotal() {
		return products
				.entrySet()
				.parallelStream()
				.map(e -> e.getKey().getPrice() * e.getValue())
				.reduce(0.0, (a, b) -> a + b);
	}

	@Override
	public void initialize() {
		this.products.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sbInfo = new StringBuilder();
		sbInfo.append("This is the information regarding your order:\n");
		sbInfo.append("Type - Name - Price (n units)\n");
		
		// We append the elements of the dictionary
		products.entrySet().forEach(p -> sbInfo.append(p.getKey() + "\n"));
		
		if (!comment.equals("")) {
			sbInfo.append("Customer's comments: \n");
			sbInfo.append(comment + "\n");
		}
		return sbInfo.toString();
	}

}
