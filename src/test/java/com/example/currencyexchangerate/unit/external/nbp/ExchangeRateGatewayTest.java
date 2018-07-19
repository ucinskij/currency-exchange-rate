package com.example.currencyexchangerate.unit.external.nbp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGatewayFactory;
import com.example.currencyexchangerate.external.api.nbp.FakeNbpExchangeRateConnection;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class ExchangeRateGatewayTest {

  @Test
  public void getExchangeRate_validCurrency_returnsExchangeRateForGivenCurrency()
      throws ExecutionException, InterruptedException {
    ExchangeRateGateway gateway = getNbpExchangeRateGatewayWithFakeConnection();
    String currency = "USD";

    ExchangeRate exchangeRate = gateway.getExchangeRate(currency).get();

    assertNotNull(exchangeRate);
    assertThat(exchangeRate.getCurrencyCode(), is(currency));
    assertThat(exchangeRate.getValue(), is(BigDecimal.TEN));
  }

  private ExchangeRateGateway getNbpExchangeRateGatewayWithFakeConnection() {
    ExchangeRateGatewayFactory gatewayFactory = new ExchangeRateGatewayFactory();
    return gatewayFactory.createNbpExchangeRateGateway(new FakeNbpExchangeRateConnection());
  }
}
