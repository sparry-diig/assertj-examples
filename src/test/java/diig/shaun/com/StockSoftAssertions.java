package diig.shaun.com;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.internal.cglib.proxy.Enhancer;

import org.assertj.core.api.ErrorCollector;
import org.assertj.core.api.SoftAssertionError;
import static org.assertj.core.groups.Properties.extractProperty;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class StockSoftAssertions {

  /** Collects error messages of all AssertionErrors thrown by the proxied method. */
  protected final ErrorCollector collector = new ErrorCollector();

  /** Creates a new </code>{@link SoftAssertions}</code>. */
  public StockSoftAssertions() {
  }

  /**
   * Verifies that no proxied assertion methods have failed.
   *
   * @throws SoftAssertionError if any proxied assertion objects threw
   */
  public void assertAll() {
    List<Throwable> errors = collector.errors();
    if (!errors.isEmpty()) {
      throw new SoftAssertionError(extractProperty("message", String.class).from(errors));
    }
  }

  @SuppressWarnings("unchecked")
  protected <T, V> V proxy(Class<V> assertClass, Class<T> actualClass, T actual) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(assertClass);
    enhancer.setCallback(collector);
    return (V) enhancer.create(new Class[] { actualClass }, new Object[] { actual });
  }

  /**
   * Creates a new "soft" instance of <code>{@link diig.shaun.com.StockAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public diig.shaun.com.StockAssert assertThat(diig.shaun.com.Stock actual) {
    return proxy(diig.shaun.com.StockAssert.class, diig.shaun.com.Stock.class, actual);
  }

}
