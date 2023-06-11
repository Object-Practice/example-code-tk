package v1.example.Infra;

import v1.example.Domain.Product;
import v1.example.Domain.StockManager;
import java.util.List;
import java.util.Optional;

public class StockManagerImpl implements StockManager {
	private final List<Stock> stocks;

	public StockManagerImpl(List<Stock> stocks) {
		this.stocks = stocks;
	}

	void addStock(Stock stock) {
		stocks.add(stock);
	}

	@Override
	public boolean hasStock(Bundle bundle) {
		Optional<Stock> find = stocks.stream().filter((Stock stock) -> stock.hasStock(bundle)).findFirst();
		return find.isPresent();
	}



	public void minusStock(Bundle bundle){
		stocks.forEach((Stock stock)->{
			if(stock.hasStock(bundle)){
				stock.minusStock(bundle.getAmount());
			}
		});
	}

	@Override
	public void showInfo() {
		stocks.forEach((stock -> {

		}));
	}




}
