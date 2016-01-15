package diig.shaun.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sparry on 21/12/2015.
 */
public class StockMarket {

    List<Stock> stockList = new ArrayList<Stock>();

    public StockMarket() {
        Stock google = Stock.createUSStock("GOOG", "Google Inc.");
        stockList.add(google);
        Stock apple = Stock.createUSStock("APPL", "Apple Inc.");
        stockList.add(apple);
    }

    public List<Stock> getCurrentStocks() {
        return stockList;
    };

}
