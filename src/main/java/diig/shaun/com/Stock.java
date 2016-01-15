package diig.shaun.com;

/**
 * Created by sparry on 21/12/2015.
 */
public class Stock {
    private final String symbol;
    private final String name;
    private final String currency;
    private final String market;
    private double currentPrice;
    private long quantity;

    public Stock(String symbol, String name, String currency, String market) {
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMarket() {
        return market;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public static Stock createUSStock(String symbol, String name) {
        return new Stock(symbol, name, "USD", "NYSE");
    }
}
