package v1.example.Domain;

public interface StockManager {
	boolean hasStock(Product product, int amount);
	void minusStock(Product product,int amount);

	void showInfo();
}
