package com.example.currencyexchangerate.e2e;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.example.currencyexchangerate.exchangerate.ExchangeRateService;
import com.example.currencyexchangerate.exchangerate.ExchangeRateServiceFactory;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateConnection;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateConnectionFactory;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGatewayFactory;
import java.math.BigDecimal;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class ExchangeRateServiceTest {

  private final RestOperations restTemplate = new RestTemplate();
  private final ExchangeRateConnectionFactory connectionFactory = new ExchangeRateConnectionFactory();
  private final ExchangeRateConnection connection = connectionFactory.createNbpConnection(restTemplate);
  private final ExchangeRateGatewayFactory gatewayFactory = new ExchangeRateGatewayFactory();
  private final ExchangeRateGateway exchangeRateGateway = gatewayFactory.createNbpExchangeRateGateway(connection);
  private final ExchangeRateServiceFactory serviceFactory = new ExchangeRateServiceFactory();
  private final ExchangeRateService exchangeRateService = serviceFactory.createBestExchangeRateService(exchangeRateGateway);

  @Ignore
  @Test
  public void getExchangeRateForUsdCurrency_returnsExchangeRate() {
    String currency = "USD";

    ExchangeRate rate = exchangeRateService.getCurrentExchangeRate(currency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), greaterThan(BigDecimal.ZERO));
    assertThat(rate.getValue(), is(new BigDecimal("3.6619")));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(currency));
  }

  @Ignore
  @Test
  public void getExchangeRateForChfCurrency_returnsExchangeRate() {
    String currency = "chf";

    ExchangeRate rate = exchangeRateService.getCurrentExchangeRate(currency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), greaterThan(BigDecimal.ZERO));
    assertThat(rate.getValue(), is(new BigDecimal("3.6850")));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(currency));
  }

  @Ignore
  @Test
  public void getExchangeRateForNonExistingCurrency_returnsZeroInRequestedCurrency() {
    String nonExistingCurrency = "abc";

    ExchangeRate rate = exchangeRateService.getCurrentExchangeRate(nonExistingCurrency);

    assertThat(rate, notNullValue());
    assertThat(rate.getValue(), is(BigDecimal.ZERO));
    assertThat(rate.getCurrencyCode(), equalToIgnoringCase(nonExistingCurrency));
  }
}
