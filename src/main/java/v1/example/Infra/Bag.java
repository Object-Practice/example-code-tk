package v1.example.Infra;

import v1.example.Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	List<Product> products = new ArrayList<>();

	public void addProduct(Product product){
		products.add(product);
	}
}
