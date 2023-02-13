package v1.example.Domain;


import v1.example.Infra.Cart;

public interface Kiosk {
	boolean sell(Product product, Customer customer, int amount);

	boolean sellMany(Cart cart, Customer customer);
}
