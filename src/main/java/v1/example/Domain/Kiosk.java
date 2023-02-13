package v1.example.Domain;


import v1.example.Infra.Cart;

public interface Kiosk {

	boolean sell(Cart cart, Customer customer);
}
