package v1.example.Infra;

import v1.example.Domain.Product;

public class ProductWithAmount {
	private final Product product;
	private Integer amount;

	public ProductWithAmount(Product product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}
	public Integer getAmount(){return  amount;}

	public Integer calculatePrice(){
		return product.calculatePrice(amount);
	}


}
