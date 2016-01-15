import diig.shaun.com.Stock;
import diig.shaun.com.StockMarket;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;
import org.assertj.core.api.Assertions;

/**
 * Created by sparry on 21/12/2015.
 */
public class StockMarketTest {

    @Test
    public void testGetCurrentStocksWithJUnitAssert() throws Exception {
        StockMarket market = new StockMarket();
        List<Stock> stocks = market.getCurrentStocks();
        //JUnit asserts
        Assert.assertNotNull(stocks);
        Assert.assertEquals(2, stocks.size());
        Assert.assertEquals("APPL", stocks.get(0).getSymbol());
        Assert.assertEquals("GOOG", stocks.get(1).getSymbol());
    }

    @Test
    public void testGetCurrentStocksWithAssertJ() throws Exception {
        StockMarket market = new StockMarket();
        List<Stock> stocks = market.getCurrentStocks();
        //AssertJ
        Assertions.assertThat(stocks).isNotNull()
                                     .hasSize(2)
                                     .extracting("symbol")
                                     .contains("GOOG", "APPL");
    }
}