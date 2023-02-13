package v1.example.Domain;

public interface Customer {
	boolean hasIdCard();
	boolean affordableToBuy(int price);

	void buy(Product product, int amount);
}
