package com.example.currencyexchangerate.unit.exchangerate;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.example.currencyexchangerate.exchangerate.ExchangeRateService;
import com.example.currencyexchangerate.exchangerate.ExchangeRateServiceFactory;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import java.math.BigDecimal;
import org.junit.Test;

public class ExchangeRateServiceTest {

  @Test
  public void getExchangeRateForUppercaseCurrency_returnsExpectedExchangeRate() {
    ExchangeRateService service = getExchangeRateServiceWithFakeGateway();
    String currency = "USD";

    ExchangeRate rate = service.getCurrentExchangeRate(currency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), greaterThan(BigDecimal.ZERO));
    assertThat(rate.getValue(), is(new BigDecimal("3.4315")));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(currency));
  }

  private ExchangeRateService getExchangeRateServiceWithFakeGateway() {
    ExchangeRateServiceFactory factory = new ExchangeRateServiceFactory();
    return factory.createBestExchangeRateService(new FakeExchangeRateGateway());
  }

  @Test
  public void getExchangeRateForLowercaseCurrency_returnsExpectedExchangeRate() {
    ExchangeRateService service = getExchangeRateServiceWithFakeGateway();
    String currency = "chf";

    ExchangeRate rate = service.getCurrentExchangeRate(currency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), greaterThan(BigDecimal.ZERO));
    assertThat(rate.getValue(), is(new BigDecimal("3.5620")));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(currency));
  }

  @Test
  public void getExchangeRateForNonExistingCurrency_returnsZeroWithRequestedCurrency() {
    ExchangeRateService service = getExchangeRateServiceWithFakeGateway();
    String nonExistingCurrency = "abc";

    ExchangeRate rate = service.getCurrentExchangeRate(nonExistingCurrency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), is(BigDecimal.ZERO));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(nonExistingCurrency));
  }

  @Test
  public void getExchangeRate_communicationWithServiceFails_returnsZeroWithRequestedCurrency() {
    ExchangeRateService service = getExchangeRateServiceWithFailureOnCallingGateway();
    String currency = "chf";

    ExchangeRate rate = service.getCurrentExchangeRate(currency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), is(BigDecimal.ZERO));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(currency));
  }

  private ExchangeRateService getExchangeRateServiceWithFailureOnCallingGateway() {
    ExchangeRateServiceFactory factory = new ExchangeRateServiceFactory();
    return factory.createBestExchangeRateService(new FailureOnCallingExchangeRateGateway());
  }
}
