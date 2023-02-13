package v1.example;


import v1.example.Domain.Product;
import v1.example.Infra.*;
import v1.example.Infra.PayType.Card;
import v1.example.Infra.PayType.Cash;
import v1.example.Infra.Product.IceCream;
import v1.example.Infra.Product.Snack;
import v1.example.Infra.Product.Soju;
import v1.example.Domain.Customer;
import v1.example.Domain.Kiosk;

import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		IceCream iceCream = new IceCream("iceCream", 300);
		Snack snack = new Snack("snack", 500);
		Soju soju = new Soju("soju", 200);


		Kiosk kiosk = new KioskImpl(new StockManagerImpl(List.of(new Stock(iceCream, 2), new Stock(snack, 2), new Stock(soju, 2))));
		Customer tk = new CustomerImpl(new WalletImpl(new Cash(500), new Card(0), new IdCard()), PayTypeEnum.CASH);
		Customer sw = new CustomerImpl(new WalletImpl(new Cash(500), new Card(0), null), PayTypeEnum.CASH);
		Customer jc = new CustomerImpl(new WalletImpl(new Cash(0), new Card(1000), new IdCard()), PayTypeEnum.CARD);
		Cart tkCart = new Cart(List.of(new ProductWithAmount(snack, 1), new ProductWithAmount(iceCream, 1)));
		Cart swCart = new Cart(List.of(new ProductWithAmount(snack, 1), new ProductWithAmount(iceCream, 1), new ProductWithAmount(soju, 1)));
		Cart jcCart = new Cart(List.of(new ProductWithAmount(snack, 1), new ProductWithAmount(iceCream, 1), new ProductWithAmount(soju, 1)));
	}
}
