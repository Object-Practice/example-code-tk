package v1.example.Domain;

import v1.example.Infra.Bundle;

public interface StockManager {
	boolean hasStock(Bundle bundle);
	void minusStock(Bundle bundle);

	void showInfo();
}
