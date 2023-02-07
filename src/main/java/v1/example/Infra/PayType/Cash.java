package v1.example.Infra.PayType;

import v1.example.Infra.PayTypeEnum;

public class Cash extends PayType{
	public Cash(Integer money) {
		super(PayTypeEnum.CASH, money);
	}
}
