package v1.example.Infra;

import v1.example.Domain.Wallet;
import v1.example.Infra.PayType.Card;
import v1.example.Infra.PayType.Cash;

public class WalletImpl implements Wallet {
	private final Cash cash;
	private final Card card;
	IdCard idCard;

	public WalletImpl(Cash cash, Card card, IdCard idCard) {
		this.cash = cash;
		this.card = card;
		this.idCard = idCard;
	}

	@Override
	public boolean hasIdCard() {
		return idCard != null;
	}

	@Override
	public boolean hasMoneyOverPrice(int price, PayTypeEnum payType) {
		if (payType == PayTypeEnum.CASH) {
			return cash.getMoney() >= price;
		} else if (payType == PayTypeEnum.CARD) {
			return card.getMoney() >= price;
		} else return false;
	}

	@Override
	public void buy(Integer price, PayTypeEnum payType) {
		if (payType == PayTypeEnum.CASH) {
			cash.minusMoney(price);
		} else if (payType == PayTypeEnum.CARD) {
			card.minusMoney(price);
		}
	}
}
