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

	@Override
	public boolean affordableToBuy(int price) {
		return wallet.hasMoneyOverPrice(price, payType);
	}

	void changePayType(PayTypeEnum payType){
		this.payType = payType;
	}


	@Override
	public void buy(Product product, int amount) {
		bag.addProduct(product);
		wallet.buy(product.getPrice(),payType);
	}

	@Override
	public boolean isCard(){
		return payType == PayTypeEnum.CARD;
	}
}
