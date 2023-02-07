package v1.example.Infra;

import v1.example.Domain.Kiosk;
import v1.example.Domain.Product;
import v1.example.Domain.StockManager;
import v1.example.Domain.Customer;

public class KioskImpl implements Kiosk {
	private final StockManager stockManager;

	public KioskImpl(StockManager stockManager) {
		this.stockManager = stockManager;
	}

	@Override
	public boolean sell(Product product, Customer customer, int amount) {
		if (stockManager.hasStock(product, amount) && product.isAvailableBy(customer)) {
			customer.buy(product, amount);
			stockManager.minusStock(product, amount);
			return true;
		} else {
			return false;
		}
	}

	public void showInfo(){
		stockManager.showInfo();
	}
}
