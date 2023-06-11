package v1.example.Infra;

import v1.example.Domain.Product;

public class Stock {
	private final Product product;
	private Integer amount;

	public Stock(Product product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public boolean hasStock(Bundle bundle) {
		return isSameProduct(bundle.getProduct()) && hasMoreStockThanDemand(bundle.getAmount());
	}

	private boolean hasMoreStockThanDemand(Integer demandAmount) {
		return this.amount >= demandAmount;
	}

	private boolean isSameProduct(Product demandProduct) {
		return demandProduct.equals(this.product);
	}

	public void minusStock(Integer amount) {
		this.amount -= amount;
	}

//	public showInfo(){
//		System.out.println();
//	}
}
