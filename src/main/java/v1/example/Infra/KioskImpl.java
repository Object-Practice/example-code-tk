package v1.example.Infra;

import v1.example.Domain.Kiosk;
import v1.example.Domain.Product;
import v1.example.Domain.StockManager;
import v1.example.Domain.Customer;
import v1.example.Infra.PayType.Card;
import v1.example.Infra.PayType.Cash;

public class KioskImpl implements Kiosk {
	private final StockManager stockManager;
	Card card = new Card(0);
	Cash cash = new Cash(0);

	public KioskImpl(StockManager stockManager) {
		this.stockManager = stockManager;
	}

	@Override
	public boolean sell(Product product, Customer customer, int amount) {
		if (stockManager.hasStock(product, amount) && product.isAvailableBy(customer)) {
			customer.buy(product, amount);
			stockManager.minusStock(product, amount);

			Integer totalPrice = product.calculatePrice(amount);
			if (customer.isCard()) {
				card.plusMoney(totalPrice);
			} else {
				cash.plusMoney(totalPrice);
			}
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean sellMany(Cart cart, Customer customer) {
		if (!(cart.isAffordableToSell(stockManager) && cart.isAffordableToBuy(customer))) {
			return false;
		};

		Integer totalPrice = cart.calculateTotalPrice();
		cart.soldBy(customer);
		cart.boughtBy(stockManager);
		if(customer.isCard()){
			card.plusMoney(totalPrice);
		}else{
			cash.plusMoney(totalPrice);
		}
		return true;

	};


	public void showInfo() {
		stockManager.showInfo();
	}

}
