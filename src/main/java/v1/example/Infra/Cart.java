package v1.example.Infra;

import v1.example.Domain.Customer;
import v1.example.Domain.StockManager;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Cart {
	private List<Bundle> bundles;

	public Cart(List<Bundle> bundles) {
		this.bundles = bundles;
	}

	boolean isAffordableToSell(StockManager stockManager) {
		Optional<Bundle> found = bundles.stream().filter((bundle -> {
			return !stockManager.hasStock(bundle);
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
		bundles.forEach((bundle -> {
			totalPrice.updateAndGet(v -> v + bundle.calculatePrice());
		}));
		System.out.println("totalPrice = " + totalPrice);
		return totalPrice.get();
	}

	public void boughtBy(StockManager stockManager) {
		bundles.forEach(stockManager::minusStock);
	}

	public void soldBy(Customer customer) {
		System.out.println("hi");
		bundles.forEach((bundle)->{
			customer.buy(bundle.getProduct(), bundle.getAmount());
		});}
}
