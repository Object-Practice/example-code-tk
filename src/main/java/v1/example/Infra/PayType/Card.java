package v1.example.Infra.PayType;

import v1.example.Infra.PayTypeEnum;

public class Card extends PayType {
	public Card(Integer money) {
		super(PayTypeEnum.CARD, money);
	}
}
