package diig.shaun.com;

import org.assertj.core.api.Assertions;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class StockAssertions {

  /**
   * Creates a new instance of <code>{@link diig.shaun.com.StockAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static diig.shaun.com.StockAssert assertThat(diig.shaun.com.Stock actual) {
    return new diig.shaun.com.StockAssert(actual);
  }

  /**
   * Creates a new <code>{@link Assertions}</code>.
   */
  protected StockAssertions() {
    // empty
  }
}
