package v1.example.Infra;

import v1.example.Domain.Customer;
import v1.example.Domain.StockManager;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Cart {
	private List<ProductWithAmount> productsWithAmount;

	public Cart(List<ProductWithAmount> productsWithAmount) {
		this.productsWithAmount = productsWithAmount;
	}

	boolean isAffordableToSell(StockManager stockManager) {
		Optional<ProductWithAmount> found = productsWithAmount.stream().filter((productWithAmount -> {
			return !stockManager.hasStock(productWithAmount.getProduct(), productWithAmount.getAmount());
		})).findFirst();
		if (found.isPresent()) {
			System.out.println("재고가 부족하여 구매가 불가능합니다.");
			return false;
		}
		return true;
	}

	;

	boolean isAffordableToBuy(Customer customer) {
		return customer.affordableToBuy(calculateTotalPrice());
	}

	public Integer calculateTotalPrice() {
		AtomicReference<Integer> totalPrice = new AtomicReference<>(0);
		productsWithAmount.forEach((productWithAmount -> {
			totalPrice.updateAndGet(v -> v + productWithAmount.calculatePrice());
		}));
		System.out.println("totalPrice = " + totalPrice);
		return totalPrice.get();
	}

	public void boughtBy(StockManager stockManager) {
		productsWithAmount.forEach((productWithAmount)->{
			stockManager.minusStock(productWithAmount.getProduct(), productWithAmount.getAmount());
		});
	}

	public void soldBy(Customer customer) {
		System.out.println("hi");
		productsWithAmount.forEach((productWithAmount)->{
			customer.buy(productWithAmount.getProduct(), productWithAmount.getAmount());
		});}
}
