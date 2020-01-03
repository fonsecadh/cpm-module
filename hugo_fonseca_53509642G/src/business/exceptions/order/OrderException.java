package business.exceptions.order;

public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrderException() {
		
	}
	
	public OrderException(String message) {
		super(message);
	}

}
