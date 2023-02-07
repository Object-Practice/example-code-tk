package v1.example.Infra.PayType;

import v1.example.Infra.PayTypeEnum;

public abstract class PayType {
	PayTypeEnum type;
	Integer money;

	public PayType(PayTypeEnum type, Integer money) {
		this.type = type;
		this.money = money;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
}
