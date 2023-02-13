package v1.example.Domain;

public abstract class NormalProduct extends Product{
	public NormalProduct(String name, int price) {
		super(name, price);
	}

	@Override
	public boolean isAvailableBy(Customer customer) {
		return customer.affordableToBuy(this.price);
	}
}
