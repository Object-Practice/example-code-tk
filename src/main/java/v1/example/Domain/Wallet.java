package v1.example.Domain;

import v1.example.Infra.PayTypeEnum;

public interface Wallet {
	boolean hasIdCard();
	boolean hasMoneyOverPrice(int price, PayTypeEnum payType);
	void buy(Integer price, PayTypeEnum payType);

}
