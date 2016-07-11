import diig.shaun.com.Stock;
import diig.shaun.com.StockSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import org.junit.Assert;

/**
 * Created by sparry on 24/12/2015.
 */
public class StockTest {

    @Test
    public void testBasicStockWithJUnitAsserts() {
        Stock google = Stock.createUSStock("GOOG", "Google Inc");
        //JUnit assertions
        Assert.assertNotNull(google);
        Assert.assertEquals("APPL", google.getSymbol());
        Assert.assertEquals("Google Inc", google.getName());
        Assert.assertEquals("USD", google.getCurrency());
        Assert.assertEquals("NASDEQ", google.getMarket());
    }

    @Test
    public void testBasicStockWithAssertJSoftAssertions() {
        Stock google = Stock.createUSStock("GOOG", "Google Inc");
        //Soft assertions
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(google).isNotNull()
                             .hasFieldOrPropertyWithValue("symbol", "APPL")
                             .hasFieldOrPropertyWithValue("name", "Google Inc")
                             .hasFieldOrPropertyWithValue("currency", "USD")
                             .hasFieldOrPropertyWithValue("market", "NASDEQ");
        sa.assertAll();
    }

    @Test
    public void testBasicStockWithAssertJCustomAssertions() {
        Stock google = Stock.createUSStock("GOOG", "Google Inc.");
        StockSoftAssertions sa = new StockSoftAssertions();
        sa.assertThat(google).hasName("Oracle Inc.").hasSymbol("APPL").hasCurrency("USD").hasMarket("NYSE");
        sa.assertThat(google).hasName("Google Inc.").hasSymbol("GOOG").hasCurrency("EUR").hasMarket("NIPPON");
        sa.assertAll();
    }
}