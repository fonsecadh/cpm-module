package business.bar.products;

public class Drink implements Product {
	
	// Attributes
	private String code;
	private int type;
	private String name;
	private double price;
	private int units;
	
	

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int getUnits() {
		return units;
	}

	@Override
	public void setUnits(int units) {
		this.units = units;
	}

}
