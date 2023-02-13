package v1.example.Domain;


public interface Kiosk {
	boolean sell(Product product, Customer customer, int amount);
	Integer calculateProduct(Product product, Integer amount);
}
