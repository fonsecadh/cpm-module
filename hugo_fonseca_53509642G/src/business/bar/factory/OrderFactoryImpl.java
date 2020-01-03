package business.bar.factory;

import business.bar.Order;
import business.bar.OrderImpl;

public class OrderFactoryImpl implements OrderFactory {

	@Override
	public Order makeOrder() {
		return new OrderImpl();
	}

}
