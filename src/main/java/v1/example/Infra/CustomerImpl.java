package v1.example.Infra;

import v1.example.Domain.Customer;
import v1.example.Domain.Product;
import v1.example.Domain.Wallet;

public class CustomerImpl implements Customer {

	private final Wallet wallet;
	private PayTypeEnum payType;
	private Bag bag = new Bag();
	public CustomerImpl(Wallet wallet, PayTypeEnum payType){
		this.wallet = wallet;
		this.payType = payType;
	}
	@Override
	public boolean hasIdCard() {
		return wallet.hasIdCard();
	}

	void changePayType(PayTypeEnum payType){
		this.payType = payType;
	}

	@Override
	public boolean hasMoneyOverPrice(int price) {
		return wallet.hasMoneyOverPrice(price, payType);
	}

	@Override
	public void buy(Product product, int amount) {
		bag.addProduct(product);
		wallet.buy(product.getPrice(),payType);
	}

}
