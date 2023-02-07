package v1.example;


import v1.example.Infra.*;
import v1.example.Infra.PayType.Card;
import v1.example.Infra.PayType.Cash;
import v1.example.Infra.Product.IceCream;
import v1.example.Infra.Product.Snack;
import v1.example.Infra.Product.Soju;
import v1.example.Domain.Customer;
import v1.example.Domain.Kiosk;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		IceCream iceCream = new IceCream("iceCream", 300);
		Snack snack = new Snack("snack", 500);
		Soju soju = new Soju("soju", 200);
		Kiosk kiosk = new KioskImpl(new StockManagerImpl(List.of(new Stock(iceCream, 1), new Stock(snack, 1), new Stock(soju, 1))));
		Customer tk = new CustomerImpl(new WalletImpl(new Cash(500), new Card(0), new IdCard()), PayTypeEnum.CASH);
		Customer sw = new CustomerImpl(new WalletImpl(new Cash(500), new Card(0), null), PayTypeEnum.CASH);
		Customer jc = new CustomerImpl(new WalletImpl(new Cash(0), new Card(1000), new IdCard()), PayTypeEnum.CARD);

		boolean sell = kiosk.sell(snack, tk, 1);
		boolean sell1 = kiosk.sell(iceCream, tk, 1);

		boolean sell2 = kiosk.sell(soju, sw, 1);
		boolean sell3 = kiosk.sell(iceCream, sw, 1);
		boolean sell4 = kiosk.sell(snack, sw, 1);

		boolean sell5 = kiosk.sell(soju, jc, 1);
		boolean sell6 = kiosk.sell(iceCream, jc, 1);
		boolean sell7 = kiosk.sell(snack, jc, 1);

		System.out.println(sell);
		System.out.println(sell1);

		System.out.println(sell2);
		System.out.println(sell3);
		System.out.println(sell4);

		System.out.println(sell5);
		System.out.println(sell6);
		System.out.println(sell7);
	}
}
