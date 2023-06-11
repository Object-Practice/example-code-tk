package v1.example.Domain;

public abstract class AdultRequiredProduct extends Product {
	public AdultRequiredProduct(String name, int price) {
		super(name, price);
	}

	@Override
	public boolean isAvailableBy(Customer customer) {
		return customer.hasIdCard() && customer.affordableToBuy(this.price);
	}
}
