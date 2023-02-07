package v1.example.Domain;

import java.util.Objects;

public abstract class Product {
	protected int price;
	protected String name;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	abstract public boolean isAvailableBy(Customer customer);

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return price == product.price && Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, name);
	}

	public int getPrice() {
		return price;
	}
	
//	public void showInfo(){
//		System.out.println("Product " + name+ price+"원");
//	}
}
